#include<stdio.h>

main()
{
    int Fahrenheit;
    printf("Fahrenheit-Celsius\n");
    for (Fahrenheit = 0; Fahrenheit < 301; Fahrenheit = Fahrenheit + 20)
        printf("%6d %10.1f\n", Fahrenheit , (5.0/9.0)*(Fahrenheit-32));
}
