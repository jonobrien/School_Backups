/***********************************************************************************
 Purpose : Show how to cal gnuplot to generate plots from a C program
 Requires: ipend.sim (file name with data for plots)
           gnuplot   (tested with version 4.4 )
           pipes     (Not ANSI C, tested under Linux)
 Author  : Juan C. Cockburn Nov 2010
 Revised : Oct 2012, improved comments m juan.cockburn@rit.edu
 Warning : popen is not part of standard C; expect warnings is using -ansi !
 ***********************************************************************************/
#include <stdio.h>

int main(void) {
/* Declare variables */
  FILE *pipe; /* pipe is a pointer to a a pipe process */

  printf(" ----------------------------------------------------------\n");
  printf(" Example: Using gnuplot to draw figures within C programs   \n");
  printf("          (Opens an X11 Windows for display) \n");
  printf(" ----------------------------------------------------------\n");

/* Open pipe to communicate with gnuplot */
  if( (pipe = (FILE *) popen("gnuplot -persist","w")) == NULL ) {
    fprintf(stderr,"Unable to open pipe to gnuplot\n");
    return -1;
  }
    
/* Send gnuplot commands through pipe */
  /* gnuplot: send output to X11 terminal with desired font */
  fprintf(pipe,"set terminal x11 font 'Vera.ttf'\n");

  /* gnuplot: set title, labels, legend  and line styes */
  fprintf(pipe,"set title 'Inverted Pendulum Simulation [RK4 solver]'\n");
  fprintf(pipe,"set xlabel 'Time [sec]'\n");
  fprintf(pipe,"set ylabel 'State Trajectories'\n");
  fprintf(pipe,"set style data lines\n");	/* draw lines between data points 	*/
  fprintf(pipe,"set key bottom left\n");  	/* legend location 					*/
  fprintf(pipe,"set key box\n");			/* legend format 					*/

  /* gnuplot: set parameters to draw multiple plots in the same figure 		*/
  fprintf(pipe,"set multiplot\n");			/* multiple plots is one figure */
  fprintf(pipe,"set xrange [0:10]\n");		/* set x range					*/
  fprintf(pipe,"set yrange [-5:6]\n");		/* set y range					*/

  /* gnupolot: read deata file plot each curve */
  fprintf(pipe,"plot 'ipend.sim' using 1:2 lt 1 lw 4 t 'cart position',"); 	/* 1st col vs 2nd col */
  fprintf(pipe,"'ipend.sim' using 1:3 lt 2 lw 4 t 'pend angle',");			/* 1st col vs 2rd col */
  fprintf(pipe,"'ipend.sim' using 1:4 lt 3 lw 4 t 'cart velocity',");		/* 1st col vs 5th col */
  fprintf(pipe,"'ipend.sim' using 1:5 lt 4 lw 4 t 'pend velocity'\n");		/* 1st col vs 5th col */

  /* gnuplot: clean up and close  pipe */
  fprintf(pipe,"unset multiplot\n");

/* Close pipe */
  pclose(pipe);

  return 0 ;
}
