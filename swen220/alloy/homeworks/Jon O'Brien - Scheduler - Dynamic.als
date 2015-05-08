//Jon O'Brien
//Scheduler Dynamic Activity

// Dynamic Operations

// (1) Block the currently running task (there must
// be one). 
// If possible, some runnable task is made running,
// with real time tasks having preference over
// background (IDLE) tasks.
//
// Complete the assertion that block maintains the
// invariant. You need only consider the first and
// second steps.

// pred block[st : Step] 

// -----------------------------------------------------

// (2) Unblock one of the blocked tasks.
// This may result in a new running task if
//		a) no task was running previously.
//		b) the running task was background and the
//			 unblocked task is real time.
//
// Complete the invariant ensuring unblock
// maintains the invariant.

// pred unblock[t : Task, st : Step] 

// ------------------------------------------------------

// (3) Attempt to switch the currently running task with
// one of the other runnable tasks.
// This is only valid when there *is* a running task.
// The current task may continue to be the running one
// if:
//		a) it is the only runnable task.
//		b) it is a real time task and the only other
//		 	 runnable tasks are background.
//
// Complete the invariant ensuring unblock maintains
// the invariant

// pred switch[st : Step] 


open util/ordering[Step] as step
sig Step{}


/**
		The set of tasks, including the idle task.
*/
enum Task {IDLE, Java, Python, Ruby}

/**
		The (one and only) Scheduler.
*/
one sig Scheduler {
	onCPU :			Task -> Step,	// the task using the CPU
	blocked :		Task -> Step,	// the set of blocked tasks
	runnable :	Task -> Step	// the set of runnable tasks
}

pred OneTaskOnCPU[st : Step] {
		one Scheduler.onCPU.st
}
/**
		All tasks are either runnable or blocked, and
		no task is both runnable and blocked.
		(i.e., blocked and runnable partition task)
*/
pred Partitioning[st : Step] {
	Scheduler.(runnable.st + blocked.st) = Task
	no Scheduler.runnable.st & Scheduler.blocked.st
}

/**
		The IDLE task is always runnable.
		The IDLE task is on the cpu if and only if
		there are no other runnable tasks.
*/
pred IDLE_Task_Runnable[st : Step] {
	IDLE in Scheduler.runnable.st
}

/**
		The IDLE task is on the cpu if and only if
		there are no other runnable tasks.
*/
pred IDLE_Task_LastToRun[st : Step] {
	IDLE = Scheduler.onCPU.st <=> IDLE = Scheduler.runnable.st
}

/**
		The task on the CPU is a runnable task.
*/
pred onCPU_is_Runnable[st : Step] {
	Scheduler.onCPU.st in Scheduler.runnable.st
}

//invariant references all original static facts as inital state
pred Invariant[st : Step] {
		OneTaskOnCPU[st]
		Partitioning[st]
		IDLE_Task_Runnable[st]
		IDLE_Task_LastToRun[st]
		onCPU_is_Runnable[st]
}

//define the initial state and initial step
pred init[st : Step] {
	one Scheduler.onCPU.st
	Scheduler.onCPU.st + IDLE = Scheduler.runnable.st
	Scheduler.blocked.st = Task - IDLE - Scheduler.onCPU.st
}
//ensure legal state exists with step change
pred init_exists {
	Invariant[step/first]
	init[step/first]
}
run init_exists for 4 but exactly 1 Step
//ensure legal closure of initial state
assert init_closed {
	all st : Step | init[st] => Invariant[st]
}
check init_closed for 4 but exactly 1 Step

/*
 * Block the task currently on the CPU
 */
pred block[st : Step] {
	/*
	 * Preconditions
	 */
	st != last
	Scheduler.onCPU.st != IDLE

	let st' = next[st] {
		/*
		 * Effects
		 */
		Scheduler.runnable.st' = Scheduler.runnable.st - Scheduler.onCPU.st
		Scheduler.blocked.st' = Scheduler.blocked.st + Scheduler.onCPU.st

		IDLE = Scheduler.runnable.st' => Scheduler.onCPU.st' = IDLE
		IDLE != Scheduler.runnable.st' => 
			(
				Scheduler.onCPU.st' in Scheduler.runnable.st' - IDLE &&
				one Scheduler.onCPU.st'
			)
	}
}
assert block_closed {
	all st : Step - step/last {
		Invariant[st] && block[st] => Invariant[next[st]]
	}
}
check block_closed for 4 but exactly 2 Step

pred block_exists {
	Invariant[step/first]
	block[step/first]
}
run block_exists for 4 but exactly 2 Step


/*
 * Unblock a currently blocked task.
 */
pred unblock[st : Step, t : Task] {
	/*
	 * Preconditions
	 */
	st != last
	t in Scheduler.blocked.st

	let st' = next[st] {
		/*
		 * Effects
		 */
		Scheduler.runnable.st' = Scheduler.runnable.st + t
		Scheduler.blocked.st' = Scheduler.blocked.st - t
		Scheduler.onCPU.st = IDLE => Scheduler.onCPU.st' = t
		Scheduler.onCPU.st != IDLE => Scheduler.onCPU.st' = Scheduler.onCPU.st
		
	}
}

assert unblock_closed {
	all t : Task, st : Step - last {
		Invariant[st] && unblock[st, t] => Invariant[next[st]]
	}
}
check unblock_closed for 4 but exactly 2 Step

pred unblock_exists {
	some t : Task {
		Invariant[first]
		unblock[first, t]
	}
}
run unblock_exists for 4 but exactly 2 Step


/*
 *  - - - - - - - - Unblock a currently blocked task.  - - - - - - - - - - - - - - - - - - - - 
 */
pred switch[st : Step] {
	/*
	 * Preconditions
	 */
	st != last
	some disj t1, t2 : Task | (t1 + t2) in Scheduler.runnable.st - IDLE

	let st' = next[st] {
		/*
		 * Effects
		 */

		some t : Scheduler.runnable.st {
			t != IDLE
			t != Scheduler.onCPU.st

			Scheduler.onCPU.st' = t
		}

		/*
		 * Framing
		 */
		Scheduler.runnable.st' = Scheduler.runnable.st
		Scheduler.blocked.st' = Scheduler.blocked.st
	}
}
assert switch_closed {
	all st : Step - step/last {
		Invariant[st] && switch[st] => Invariant[next[st]]
	}
}
check switch_closed for 4 but exactly 2 Step

pred switch_exists {
	Invariant[step/first]
	switch[step/first]
}
run switch_exists for 4 but exactly 2 Step

/******* Trace Predicate ********/

pred trace {
	init[step/first]

	all st : Step - step/last {
			(
				block[st]
			)
					||
			(
				some t : Task | unblock[st, t]
			)
					||
			(
				switch[st]
			)
	}
}
run trace for 4 but 8 Step

pred suppose {
	trace

	some disj st1, st2, st3, st4 : Step {
		Scheduler.onCPU.st1 = IDLE
		Scheduler.onCPU.st2 = Java
		Scheduler.onCPU.st3 = Python
		Scheduler.onCPU.st4 = Ruby
	}
}
run suppose for 4 but 12 Step















