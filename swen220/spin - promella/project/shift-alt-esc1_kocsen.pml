/*
 * Number of Customers, cashiers and Servers
 */
#define NCUST 1
#define NCASH 1
#define NSERV 1
 
/*
 * Channels defenitions.
 */
// To announce entry + id
chan customer_to_cashier = [NCUST] of { mtype, byte }; // ENTER, customer id
 
// To forward the order
chan cashier_to_server = [NCUST] of { mtype, mtype, byte }; // ORDER_UP (mtype), food, cid
 
// For customer to tell food to cashier
chan order_to_cashier = [0] of {mtype}; // Food mtype
 
// The recieving customer channel
chan to_customer[NCUST] = [0] of { mtype }; // Say DONE or READY FOR ORDER
 
/**
 * mtype Declarations
 * For better readability
 */
//Customer to cashier
mtype = { ENTER };
 
//Cashier/Server to Customer
mtype = { READY_FOR_ORDER, DONE  };
 
//Cashier to Server
mtype = { ORDER_UP };
 
/**
 * Food types!
 * As seen on the practical promela exam
 */
mtype = {CHILI, SANDWICH, PIZZA};
inline choose( food_item ) {
   atomic{
        if
           :: true -> food_item = CHILI;
           :: true -> food_item = SANDWICH;
           :: true -> food_item = PIZZA;
        fi;
   }
}
 
/**
 * LTL booleans
 */
bool food_order_is_return = true; // The food that was ordered was received
bool customer_can_place = false;  // If want to place order, eventually can
 
/**
 * Customer
 * Loop
 * - Customer enters by announcing it to customer_to_cashier channel (placed in queue)
 * - Customer locks and waits until is told that we are READY_FOR_ORDER
 *      - Customer sends his order
 *      - Customer locks and waits until order done
 *          - Customer gets order and peaces out (leaves)
 */
proctype Customer(byte id, my_food) {
    mtype receive_food;
 
    do
        // Customer places himself on the customer_to_cashier channel queue
        ::printf( "Customer %d has entered the store.\n", id );
        customer_to_cashier ! ENTER, id;
 
        // Customer locks until asked for order
        to_customer[id] ? READY_FOR_ORDER;
        printf("Customer C%d has placed his order of %e.\n", id, my_food);
        order_to_cashier ! my_food; // Places order
        customer_can_place = true;
       
        // Locks until told order is done
        to_customer[id] ? receive_food;  // Got my order!
        printf("Customer C%d exitting after recieving his %e order.\n", id, receive_food);
 
        // Assert food recieved is food ordered(for ltls)
        if
            :: receive_food != my_food -> food_order_is_return = false;
            :: else -> skip;
        fi;
    od;
 
}
 
/**
 * Cashier
 * Loop
 * - Cashier picks/waits until customer in customer_to_cashier
 *      - Cashier asks and gets order from customer
 *          - Cashier sends order to Server queue
 */
proctype Cashier() {
    byte cust_id;
    byte num_orders;
    mtype food_order;
 
    do
        // Cashier picks a customer
        :: printf("Cashier waiting for new customers\n");
        customer_to_cashier ?? ENTER, cust_id; // ?? picks random from queue
       
        // Cashier tells a customer he/she should order
        printf("Cashier selects customer %d.\n", cust_id);
        to_customer[cust_id] ! READY_FOR_ORDER;
 
        // Cashier gathers order from customer
        printf("Cashier takes order from customer C%d.\n", cust_id);
        order_to_cashier ? food_order;
 
        // Cashier sends order to server
        printf("Cashier passses %e order to server.\n", food_order);
        cashier_to_server ! ORDER_UP, food_order, cust_id;
    od;
}
 
/**
 * Server
 * Loop
 * - Server waits for ORDER_UP on server queue/channel
 *      - Server Cooks and tells Customer order is done
 */
proctype Server(byte id) {
    byte cooking_for_id; // id of customer
    mtype food_cooking;  // type of food cooking!
 
    do
        // Server is waiting for ORDER_UP signal (an order)
        :: printf("Server S%d waiting for an order...\n", id);
        cashier_to_server ? ORDER_UP, food_cooking, cooking_for_id;  // Server gets order
 
        // Server gets an order!
        printf("Server S%d retrieving order for C%d. Cooking %e\n", id, cooking_for_id, food_cooking);
 
        // Server cooking order
        printf("Server S%d is cooking the order (%e).\n", id, food_cooking);
 
        // Server delivering order
        printf("S%d delivering %e order to Customer C%d.\n", id, food_cooking, cooking_for_id);
        to_customer[cooking_for_id] ! food_cooking;
    od;
}
 
 
// Init creating cashier server(s) and customer(s)
init {
    byte i;
    mtype food;
    atomic {
        for( i:0 .. (NCASH -1)){
            run Cashier();
        }
 
        for( i:0 .. (NSERV -1)){
            run Server(i);
        }
 
        for( i:0 .. (NCUST -1)){
            choose(food);
            run Customer(i, food);
        }
    }
}
 
 
// LTL's
ltl Safety{
    []food_order_is_return == true;
}
 
ltl Liveness{
    <>customer_can_place == true;
}