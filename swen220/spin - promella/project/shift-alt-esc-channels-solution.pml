/* Global variables and defines */
#define NCUST 3
#define NSERV 2
mtype = {CHILI, SANDWICH, PIZZA};

byte cust_served = 0;

/* LTL used variables */
bool correct_order = true;
mtype favorite_food[NCUST]; /* List of each customer's favorite food */

byte orders_placed = 0;

bool cashier_correct_order = true;
bool server_busy = false;

byte serv_cust[NSERV] = 255;

/* Customer/Cashier interaction */
chan customer_enter_store = [NCUST] of {byte};
chan customer_order[NCUST] = [0] of {mtype};

/* Cashier/Server interaction */
chan post_order = [NCUST] of {byte, mtype};

/* Server/Customer interaction */
chan order_done[NCUST] = [0] of {mtype};

proctype Customer(byte id, food) {
	/* Customer variables */
	mtype delivery = 255; /* Delivered order */

	do
	:: skip ->
		/* Enter store */
		printf("Customer %d enters the store\n", id);

		/* Record a new customer */
		customer_enter_store ! id;

		/* Wait for cashier */
		customer_order[id] ? _;

		/* Place order for favorite food */
		printf("Customer %d places an order for %e\n", id, food);
		customer_order[id] ! food;
		orders_placed++;

		/* wait for order to be fulfilled */
		order_done[id] ? delivery;

		/* Exit store with food */
		if
		:: delivery != food -> correct_order = false;
		:: else;
		fi;
		printf("Customer %d leaves with %e. Their favorite food is %e.\n", id, delivery, food);
		cust_served++;
	od;
}

proctype Cashier() {
	/* Cashier's variables */
	byte cust_id = 255; /* selected customer */
	mtype order = 255; /* Customer's order */

	do
		/* Wait for a new customer */
	:: customer_enter_store ? cust_id;
		printf("The cashier sees someone in line\n");

		/* Select a waiting customer */
		printf("The cashier selects customer %d\n", cust_id);

		/* Take order */
		customer_order[cust_id] ! 255;
		customer_order[cust_id] ? order;
		printf("Cashier gets customer %d's order for %e\n", cust_id, order);

		/* Pass order to server(s) */
		post_order ! cust_id, order;
		printf("Cashier puts an order in for %e\n", order);
	od;
}

proctype Server(byte id) {
	/* Server's variables */
	mtype my_order = 255;
	byte my_cust = 255;

	do
		/* Wait for an order */
	:: post_order ? my_cust, my_order;
		printf("Server %d sees an order in the queue\n", id);

		/* Retrieve order (customer and food) */
		serv_cust[id] = my_cust;
		printf("Server %d takes customer %d's order for %e\n", id, my_cust, my_order);

		if /* Make sure the cashier gave the correct order for the customer */
		:: favorite_food[my_cust] != my_order -> cashier_correct_order = false;
		:: else;
		fi;

		/* Make the order */
		printf("Server %d makes a %e\n", id, my_order);
		server_busy = true; /* The server is doing something */

		/* Deliver order to (correct) customer */
		printf("Server %d delivers the %e to customer %d\n", id, my_order, my_cust);
		serv_cust[id] = 255;
		order_done[my_cust] ! my_order;
	od;
}

init {
	atomic {
		run Customer(0, PIZZA);
		favorite_food[0] = PIZZA;
		run Customer(1, CHILI);
		favorite_food[1] = CHILI;
		run Customer(2, SANDWICH);
		favorite_food[2] = SANDWICH;
		run Cashier();
		run Server(0);
		run Server(1);
	}
}

/* LTL formulas */
ltl Safe_1 {
	[]correct_order
	/* Correct order variable is always true - set to false by customer */
}

ltl Live_1 {
	<>(orders_placed == NCUST)
	/* Every customer will eventually place an order */
}

ltl Safe_2 {
	[]cashier_correct_order
	/* Cashier is always correct - set to false by Server */
}

ltl Live_2 {
	<>server_busy
	/* A server eventually makes something */
}

ltl Safe_3 {
	[]((serv_cust[0] != serv_cust[1]) || serv_cust[0] == 255); /* 255 is empty */
	/* The two servers never have the same customer */
}