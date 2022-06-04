#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int i;
    double sum;

    for(i=1;i<=100;i++)
    {
        sum+=1.0/i;
    }
    printf("To athroisma einai :%.7g\n",sum);

    system("pause");
}
