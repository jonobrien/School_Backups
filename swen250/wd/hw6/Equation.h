/* The number of sensor measurements over the full operating range. */
#define NUM_STEPS (4000)

/* The full range of possible sensor values */
#define MIN_SENSOR (0.0)
#define MAX_SENSOR (5.0)

/* The range of sensor values for which the sensor is accurate */
#define MIN_ACCURATE_SENSOR (0.1)
#define MAX_ACCURATE_SENSOR (4.9)

#define A2D_SIZE (12)
#define MAX_A2D ((1 << A2D_SIZE) - 1)

double DcOffset;
#define MIN_DC_OFFSET (+1.00)
#define MAX_DC_OFFSET (+2.00)

double Linear;
#define MIN_LINEAR (0.995)
#define MAX_LINEAR (1.025)

double Square;
#define MIN_SQUARE (-0.001)
#define MAX_SQUARE (+0.003)

double Period;
#define MIN_PERIOD (0.00040)
#define MAX_PERIOD (0.00060)

double Scale;
#define MIN_SCALE (375.0)
#define MAX_SCALE (400.0)
