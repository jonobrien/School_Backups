/**
 *	Fields and Date atoms used for scheduling games.
 */
some sig Field{}
some sig Date{}

/**
 * Scheduled games take place on a field on a given date.
 */
some sig Game {
	where	: lone Field,
	when	: lone Date
}

/**
 * There is one field complex with a schedule of games.
 */
one sig FieldComplex {
	schedule : set Game
}

/**
 * Games *not* on the schedule have no associated field
 * or date.
 */
fact NotOnSchedule_NoFieldNoDate {
   // FILL IN
}

/**
 * Games that *are* on the schedule have one field and one
 * date.
 */
fact OnSchedule_HaveFieldAndDate {
   // FILL IN
}

/**
 * Games on the same field are scheduled for
 * different dates.
 */
fact SameFieldMeansDifferentDate {
   // FILL IN
	}


/**
 * Find solutions where at least one game is on
 * the schedule with a date. Note that 'some when'
 * implies 'some where' and 'some schedule' in order to
 * adhere to the facts.
 */
run {
	some when
} for 4
