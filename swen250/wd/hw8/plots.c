/***********************************************************************************
 Purpose : Show how to use gnuplot to generate plots from C
 Requires: ipend.sim (file with inverted pendulum simulation results)
           gnuplot   (tested with version 4.4 )
           pipes     (OK under Linux)
 Author  : Juan C. Cockburn - Nov 2010, Feb 2013
 
 Note: To use Vera.ttf in gnuplot you may need to add the following three lines
       to your .bashrc (paths given are for Ubuntu Linux)
  # Set fontpath for gnuplot										
  export GDFONTPATH=/usr/share/fonts/truetype/ttf-bitstream-vera 
  export GNUPLOT_DEFAULT_GDFONT="Vera.ttf"						
 
 ***********************************************************************************/
#include <stdio.h>

int main(int argc, char *argv[]) {

  FILE *pipe;

  printf(" ----------------------------------------------------------\n");
  printf(" Example: Using gnuplot to draw figures within C programs   \n");
  printf(" Side effect: A figure called invpend.png \n");
  printf(" ----------------------------------------------------------\n");

  /* Open gnuplot pipe */
  if( (pipe = (FILE *) popen("gnuplot -persist","w")) == NULL ) {
    printf("Unable to open pipe to gnuplot\n");
    return -1;
  }

  /* Send plot to png image file */
  fprintf(pipe,"set terminal png\n"); 
  /* Set name of png image file */
  fprintf(pipe,"set output 'pend_%s.png'\n",argv[1]);

  /* Set title, labels, legend  and line stye */
  fprintf(pipe,"set title 'Inverted Pendulum Simulation [RK4 solver]'\n");
  fprintf(pipe,"set xlabel 'Time [sec]'\n");
  fprintf(pipe,"set ylabel 'State Trajectories'\n");
  fprintf(pipe,"set style data lines\n");
  fprintf(pipe,"set key bottom left\n");
  fprintf(pipe,"set key box\n");

  /* Set parameters to draw multiple plots in the same figure */
  fprintf(pipe,"set multiplot\n");
  fprintf(pipe,"set xrange [0:20]\n");
  fprintf(pipe,"set yrange [-5:6]\n");



  /* Read simulation results and plot each trajectory */
  fprintf(pipe,"plot ");
  fprintf(pipe,"'pend_%s.sim' using 1:2 lt 1 lw 4 t 'cart position',",argv[1]);
  fprintf(pipe,"'pend_%s.sim' using 1:3 lt 2 lw 4 t 'pend angle',",argv[1]);
  fprintf(pipe,"'pend_%s.sim' using 1:4 lt 3 lw 4 t 'cart velocity',",argv[1]);
  fprintf(pipe,"'pend_%s.sim' using 1:5 lt 4 lw 4 t 'pend velocity'\n",argv[1]);

  /* clean up and close pipe */
  fprintf(pipe,"unset multiplot\n");
  pclose(pipe);

  return 0 ;
}
