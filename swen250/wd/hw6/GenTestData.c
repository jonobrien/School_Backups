/*****************************************************************************
 * EECC381 - Program to generate sensor test data.
*****************************************************************************/
#include <stdio.h>

#include "Equation.h"

/*****************************************************************************
 * Trivial program to generate all possible (within reason) values that the
 * sensor needs to handle.
*****************************************************************************/
int main(int argc, char *argv[])
  {
   /* The floating-point "counter" */
   double PhysicalQuantity;

   /* Sweep the sensor */
   for (PhysicalQuantity = MIN_ACCURATE_SENSOR; 
        PhysicalQuantity <= MAX_ACCURATE_SENSOR; 
        PhysicalQuantity += (MAX_SENSOR - MIN_SENSOR) / NUM_STEPS)
     {
      /* Generate the physical value to be measured */
      printf("%lf\n", PhysicalQuantity);
     } /* for() */

   return 0;
  } /* main() */
