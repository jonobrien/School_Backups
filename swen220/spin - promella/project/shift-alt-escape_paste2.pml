 
mtype = {CHILI, SANDWICH, PIZZA}
 
#define NOBODY
 
#define sema byte
#define up(s) { s++ ; }
#define down(s) { atomic{ s > 0 ; s-- } }
 
sema cust_mutex = 0;
sema cashier_mutex = 0;
sema server_mutex = 0;
byte cust_in_store = 0;
bool ready_for_order = false;
mtype order_placed;
bool order_placed_bool = false;
mtype order_taken;
bool order_taken_bool = false;
mtype order_delivered;
bool order_delivered_bool = false;
 
proctype Customer(mtype food) {
    do
    ::
        /* enter store */
        printf("Customer enters store\n");
        up(cust_mutex);
 
        /* record a new customer */
        cust_in_store++;
 
        /* wait for cashier */
        if
        :: ready_for_order ->
            /* place order for favorite food */
            printf("Customer places order for %e\n", food);
            order_placed = food;
            order_placed_bool = true;
        fi;
 
        /* wait for order to be fulfilled */
        if
        :: order_delivered_bool ->
            /* exit the store with food */
            printf("Customer exits store with %e\n", food);
            cust_in_store--;
            down(cust_mutex);
        fi;
    od;
}
 
proctype Cashier() {
    do
    ::
        if
        :: cust_in_store > 0 ->
            /* select a waiting customer */
            printf("Cashier selects customer\n");
            up(cashier_mutex);
        :: else ->
            /* wait for new customer */
            printf("Cashier is waiting for new customer\n");
        fi;
 
        if
        :: order_placed_bool ->
            /* take order */
            printf("Cashier takes order\n");
            order_taken = order_placed;
            /* pass order to server */
            printf("Cashier passes order to server\n");
            order_taken_bool = true;
            down(cashier_mutex);
        fi;
    od;
}
 
proctype Server() {
    do
    ::
        if
        :: order_taken_bool ->
            /* retrieve order (customer & food) */
            printf("Server receives order\n");
 
            /* make the order */
            printf("Server makes the order\n");
 
            /* deliver order to (correct) customer */
            printf("Server delivers order to customer\n");
            order_delivered = order_taken;
            order_delivered_bool = true;
            down(server_mutex);
        :: else ->
            /* wait for an order */
            printf("Server is waiting for an order\n");
            up(server_mutex);
        fi;
    od;
}
 
init {
    atomic {
        run Customer(PIZZA);
        run Cashier();
        run Server();
    }
}
 
/*
 * Safety - The server always gives the correct food
 * to the customer.
 */
ltl S_CorrectFood {
    [](order_placed == order_delivered)
}
 
/*
 * Liveness - It is always the case that if the customer
 * wants to place an order then eventually the customer
 * does so.
 */
ltl L_EventuallyOrder {
    [](cust_in_store == 1) -> <>(order_delivered_bool == true)
}
