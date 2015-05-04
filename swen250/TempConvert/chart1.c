#include<stdio.h>
#include<stdlib.h>

void main()
{
    int Fahrenheit;
    printf("Fahrenheit-Celsius\n");
    for (Fahrenheit = 0; Fahrenheit < 301; Fahrenheit = Fahrenheit + 20)
        {
        int Celsius = (5.0/9.0)*(Fahrenheit-32);   
        printf("    %-9d%d\n", Fahrenheit, Celsius);
        }
}
