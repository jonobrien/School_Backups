
//Foods that a customer can order
mtype {CHILI, SANDWICH, PIZZA, NONE}; //NONE acts as a flag resetter
mtype allFoods[4];
 
#define NCUST 3 //really 1, just helps with indexing arrays
#define NSERV 1
#define semaphore byte
 
 
/*
 * Mutex semaphores for all processes
 * that need synchronized access to
 * their critical sections.
 */
semaphore customerMutex[NCUST] = 1;
semaphore custMutex = 1;
semaphore cashierMutex = 1;
semaphore serverMutex[NSERV] = 1;
 
/*
 * Up and down functions on semaphores.
 * down blocks if the semaphore is 0 on entry.
 */
inline up(s)    { s++ }
inline down(s)  { atomic{ s > 0 ; s-- } }
 
//Customer/Cashier Globals
bool customerInStore[NCUST] = false; //This is how we record new customers
bool cashierBusy = false; //This is how the customer knows that
                          //the cashier is ready to take his order
bool customerWaiting[NCUST] = false;
bool custPlacedOrder[NCUST] = false;
bool orderTaken[NCUST] = false;
bool someCustSelected = false;
 
//Cashier/Server Globals
mtype foodArray[4]; //constant array to hold all foods
mtype customerOrder[NCUST]; //changes based on the customer
bool custOrderSent[NCUST] = false;
bool serverBusy[NSERV] = false;
 
 
//Server/Customer Globals
bool orderFulfilled[NCUST] = false;
 
 
proctype Customer(mtype favFood, id) {
        do
        ::  customerWaiting[id] == false -> //initialize customer state
                printf("Customer %d enters store\n", id);
                custPlacedOrder[id] = false;
                orderFulfilled[id] = false;
                customerWaiting[id] = true;
                if
                :: !cashierBusy -> //wait for cashier to be ready for customer
                        down(customerMutex[id]); //enter CS and place order
                        customerOrder[id] = foodArray[id];
                        printf("Customer %d tells Cashier he wants %e\n", id, foodArray[id]); //place order
                        custPlacedOrder[id] = true;
                        if
                        :: orderFulfilled[id] -> //wait for the order to be fulfilled to reset state
                                customerWaiting[id] = false;
                                custPlacedOrder[id] = false;
                                orderFulfilled[id] = false;
                                printf("C%d's order has been fulfilled and he leaves the restauraunt\n", id);
                                printf("------------------------------------------------------------\n");
                                custOrderSent[id] = false;
                                orderTaken[id] = false;
                                customerOrder[id] = NONE;
                                someCustSelected = false;
                                up(customerMutex[id]);
                        fi;
                fi;
        od;
}
 
proctype Cashier() {
        bool someCustPlacedOrder = false;
        byte custID; //for our iterator
        mtype custsOrder;
        do
        :: for (custID : 0 .. 2) { //search for waiting customers
                if //if customer's waiting and hasn't ordered yet
                ::  customerWaiting[custID] && !custPlacedOrder[custID] && !someCustSelected ->
                        down(cashierMutex);
                        someCustPlacedOrder = true;
                        custOrderSent[custID] = false;
                        cashierBusy = false;
                        someCustSelected = true;
                        //printf("Cashier selects customer %d\n", custID);
                :: custPlacedOrder[custID] && !serverBusy[0] && !orderTaken[custID] ->
                        orderTaken[custID] = true;
                        custOrderSent[custID] = true; //notify server of the customer & his order
                        printf("Cashier selects customer %d and takes his order of %e\n", custID, customerOrder[custID]);
                        printf("Cashier sends customer %d's order of %e to the server\n", custID, customerOrder[custID]);
                        custsOrder = foodArray[custID]; //take/acknowledge the customer's order
                        up(cashierMutex);
                :: !someCustPlacedOrder && custID == 2 ->
                        printf("Cashier waits for a customer to approach him\n");
                :: else ->
                        skip;
                fi;
        }
        od;
}
 
proctype Server() {
        bool receivedOrder = false;
        byte custID;
        do
        :: for (custID : 0 .. 2) {
                if
                :: custOrderSent[custID] ->
                   down(serverMutex[0]);
                   receivedOrder = true;
                   serverBusy[0] = true;
                   printf("Server retrieves & creates customer %d's order of %e\n", custID, customerOrder[custID]);
                   printf("Server delivers customer %d his order of %e\n", custID, customerOrder[custID]);
                   orderFulfilled[custID] = true; //reset the flag
                   up(serverMutex[0]);   
                   serverBusy[0] = false;
                   cashierBusy = false; //now that the order's been fulfilled, the Cashier
                                                                                   //can take this cust's order again if he comes back
                   receivedOrder = false;
                :: !custOrderSent[0] && ! custOrderSent[1] && !custOrderSent[2] -> //!receivedOrder && custID == 2->
                   printf("Server waits for an order to come in\n");
                :: else ->
                        skip;
                fi;
        }
        od;
}
 
ltl Safety {
        //if the customer places an order       .....   the server will give him the right one
        [] customerWaiting[2] && ! cashierBusy -> customerOrder[2] == PIZZA
}
 
ltl Liveness {
        //It is always the case that if the customer wants to place an order then eventually
        //the customer does so.
        [] customerWaiting[2] -> <> custPlacedOrder[2]
}
 
init {
        foodArray[0] = CHILI;
        foodArray[1] = SANDWICH;
        foodArray[2] = PIZZA;
        foodArray[3] = NONE;
        run Customer(CHILI, 0);
        run Customer(SANDWICH, 1);
        run Customer(PIZZA, 2);
        run Cashier();
        run Server();
}
