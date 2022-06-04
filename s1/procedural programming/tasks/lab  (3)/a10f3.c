/*Το πρόγραμμα κατασκευάζει και εμφανίζει ένα πίνακα προπαίδειας από το 1 έως το 10*/

#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int number, paragontas, propaideia;

    for(number=1;number<=10;number++)
    {
        printf("%4d",number);
        for(paragontas=1;paragontas<=10;paragontas++)
        {
            propaideia=paragontas*number;
            printf("%4d",propaideia);
        }
        printf("\n");
    }
    system("pause");
}
