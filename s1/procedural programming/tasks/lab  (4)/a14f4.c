#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

double max(double a,double b);
double gr(double a,double b,double c);

main()
{
    double a,b,c,y;

    printf("Dwse ton prwto arithmo:\n");
    a=GetReal();
    printf("Dwse ton deutero arithmo:\n");
    b=GetReal();
    printf("Dwse ton trito arithmo:\n");
    c=GetReal();

    y=(2*max(a,b)+3*gr(a,b,c))/4;
    printf("H timh ths parastashs einai %g\n",y);

    system("pause");
}

double max(double a,double b)
{
    if(a>b)
    {
        return(a);
    }
    return(b);
}

double gr(double a,double b,double c)
{
    double max;

    max=a;
    if(b>max)
    {
        max=b;
    }
    if(c>max)
    {
        max=c;
    }
    return(max);
}

