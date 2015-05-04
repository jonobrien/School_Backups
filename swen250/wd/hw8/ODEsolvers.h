/*  ===========================================================================
      ODEsolvers.h - Header file for ODEsolvers module 
      Version: 1.1
      Juan C. Cockburn, April 29 2014
    =========================================================================== */
#ifndef _ODESOLVERS_H_
#define _ODESOLVERS_H_

#include <stdlib.h>
/*  ===========================================================================
     Type definitions:
	   func3arg  - a function of 3 arguments
	   func4arg  - a function of 4 arguments
 =========================================================================== */
 typedef void (*func3arg) (double, double*, double*);

 typedef void (*func4arg) (double, double*, double*, double*);
/*    function which defines the right-hand side of a  system of differential equations
         in state-space form.  This function must be of the form
               void f ( double t, double *x, double *u, double *dx )   {
                   dx[0] = f0(t,x,u);
                   dx[1] = f1(t,x,u);
                   dx[2] =f2(t,x,u);
                    .......				          .
                }
          The function returns the vector dx,  of "derivatives" of the state

     INPUTS:
          t 	value of independent variable at current time
          x 	value of state variables at current time
          u 	value of input at current time

     OUTPUT:
          dx	value of function at t,x, and u

*/
void calc_input(double*, double*, double);




/*  ===========================================================================
    Function Prototypes"
	euler - Euler method
	rk2	  - Runge-Kuta 2nd order method  ( Heun's method )
	rk3	  - Runge-Kuta 3nd order method  ( classical )
	rk4	  - Runge-Kuta 4th order method  ( classical)
 =========================================================================== */
void eu( int, double, double*, double*, double, func4arg );
/*      CALLING SEQUENCE:
          euler ( neqn, t0, x0, u0, h, f );

     INPUTS:
          neqn   number of equations
          t0	value of independent variable at current time
          x0	value of state  variables at current time
          u0	value of input  at current time
          h	time step
          f         function which defines the differential equations
		(see ode_solvers.h for details)
     OUTPUT:
          x0	returns approximate solution time t0+h  (overwritten)
*/

void rk3 ( int, double, double*, double*, double, func4arg );
/*      CALLING SEQUENCE:
          rk3 ( neqn, t0, x0, u0, h, f );

     INPUTS:
          neqn    number of equations
          t0	value of independent variable at current time
          x0	value of state  variables at current time
          u0	value of input  at current time
          h	time step
          f         function which defines the differential equations
		(see ode_solvers.h for details)
     OUTPUT:
          x0	returns approximate solution time t0+h  (overwritten)
*/

void rk2 ( int, double, double*, double*, double, func4arg );
/*      CALLING SEQUENCE:
          rk2 ( neqn, t0, x0, u0, h, f );

     INPUTS:
          neqn    number of equations
          t0	value of independent variable at current time
          x0	value of state  variables at current time
          u0	value of input  at current time
          h	time step
          f         function which defines the differential equations
		(see ode_solvers.h for details)
     OUTPUT:
          x0	returns approximate solution time t0+h  (overwritten)
*/

void rk4 ( int, double, double*, double*, double, func4arg );
/*      CALLING SEQUENCE:
          rk4 ( neqn, t0, x0, u0, h, f );

     INPUTS:
          neqn    number of equations
          t0	value of independent variable at current time
          x0	value of state  variables at current time
          u0	value of input  at current time
          h	time step
          f         function which defines the differential equations
		(see ode_solvers.h for details)
     OUTPUT:
          x0	returns approximate solution time t0+h  (overwritten)
*/

#endif /* _ODESOLVERS_H_ */
