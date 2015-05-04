/*****************************************************************
 * Applied Programming: 
 *    Solution of Overdetermined System of Equations Ax=b
 *    arising in least square problems via QR factorization                 
 *    using the GSL
 *
 * Compile with: gcc leastsquares.c -o ls -lgsl -lgslcblas
 *
 * Tested in Ubuntu 12.04 LTS
 * Revised: Juan C. Cockburn, 2012-10-17 (juan.cockburn@rit.edu)
 ****************************************************************/

#include <stdio.h>
#include <gsl/gsl_math.h>
#include <gsl/gsl_blas.h>
#include <gsl/gsl_vector.h>
#include <gsl/gsl_matrix.h>
#include <gsl/gsl_linalg.h>

/* Dimension of A matrix: M*N for this example */ 
#define M 6
#define N 3

int main(void)
{
  int i, j;         /* counters               */
  gsl_matrix *A;    /* coefficient matrix     */
  gsl_vector *b;    /* coefficient vector     */
  gsl_vector *x_ls; /* least squares solution */
  gsl_vector *tau;  /* temp variables for gsl */
  gsl_vector *res;  /* vector of residuals    */

  /* Allocate space for Matrix and vectors */
  A    = gsl_matrix_alloc(M, N);
  b    = gsl_vector_alloc(M);
  x_ls = gsl_vector_alloc(N);
  res  = gsl_vector_alloc(M);
  tau  = gsl_vector_alloc(N);

  /* In practice you will read A and b from stdio or a file   */
  /* In this example I just made up the matrix A and vector b */
  /* Set coefficient vector b */
  for(i = 0; i < M; i++) 
    gsl_vector_set(b, i, (double)i+1);

  /* Set coefficient Matrix A  */
  for(i = 0; i < M; i++)
    gsl_matrix_set(A, i, 0, 1.0);
  for(i = 1; i < M; i++)
    for(j = 0; j < N; j++)
      gsl_matrix_set(A, i, j, 1.0 / (double)(i + j + 1));

  /* Print matrix A and vector  b */
  printf("A (%d x %d) \t\t\t\t\t b (%d x 1)\n", M,N,M);
  for(i = 0; i < M; i++) {
    printf("%3d: ", i);
    for(j = 0; j < N; j++)
      printf("% 12.5g ", gsl_matrix_get(A, i, j));
    printf("|  % 12.5g ", gsl_vector_get(b, i));
    printf("\n");
  }
  printf("\n");

  /* Find QR decomposition */
  /* Warning: gls_linalg_QR_decomp overwrites A */
  gsl_linalg_QR_decomp(A, tau);

  /* Print overwitten matrix A */
  printf("A (%d x %d) overwritten after QR decomposition \n", M,N);
  for(i = 0; i < M; i++) {
    printf("%3d: ", i);
    for(j = 0; j < N; j++) 
      printf("% 12.5g ", gsl_matrix_get(A, i, j));
      printf("\n");
    }
    printf("\n");

  /* Solve R x_ls = Q^T b*/
  /* Note that we pass the "new A" and tau as arguments */
  gsl_linalg_QR_lssolve(A, tau, b, x_ls,res);

  /* Print least squares solution x_ls */
  /* You could so check the residuals  */
  printf("Least Squares Solution:\n");
  for(i = 0; i < N; i++)
    printf("x_ls[%1d] = % 16.8e \n",i, gsl_vector_get(x_ls, i));
  printf("\n");

  /* Free memory  */
  gsl_vector_free(tau);
  gsl_vector_free(res);
  gsl_matrix_free(A);
  gsl_vector_free(b);
  gsl_vector_free(x_ls);

  return 0; /* main */
}

