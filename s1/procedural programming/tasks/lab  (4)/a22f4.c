#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

int plhthos_temaxiwn(int i);
double thmh_proiontos(int i);
int kathgoria_FPA(int i);
double upologismos_FPA(double sunoliko_poso,int kathgoria);

main()
{
    int i,plhthos,kathgoria;
    double sum,thmh,FPA,sunoliko_poso,sum_FPA;

    sum=0;
    for(i=1;i<=5;i++)
    {
        plhthos=plhthos_temaxiwn(i);
        thmh=thmh_proiontos(i);
        kathgoria=kathgoria_FPA(i);
        sunoliko_poso=plhthos*thmh;
        FPA=upologismos_FPA(sunoliko_poso,kathgoria);
        sum+=FPA+sunoliko_poso;
        sum_FPA+=FPA;
    }
    printf("To sunoliko kostos einai %g\n",sum);
    printf("To sunoliko FPA einai %g\n",sum_FPA);

    system("pause");
}

int plhthos_temaxiwn(int i)
{
    printf("Dwse to plhthos temaxiwn apo to proion %d:\n",i);
    return(GetInteger());
}

double thmh_proiontos(int i)
{
    printf("Dwse thmh gia to proion %d:\n",i);
    return(GetReal());
}

int kathgoria_FPA(int i)
{
    int kathgoria_FPA;

    printf("Dwse kathgoria FPA gia to proion %d:\n",i);
    kathgoria_FPA=GetInteger();
    if(!(kathgoria_FPA>=1&&kathgoria_FPA<=4))
    {
       printf("Lathos kathgoria FPA\n");
    }
    return(kathgoria_FPA);
}

double upologismos_FPA(double sunoliko_poso,int kathgoria)
{
    double poso_FPA;

    switch(kathgoria)
    {
    case 1:
        poso_FPA=0;
        break;
    case 2:
        poso_FPA=0.06*sunoliko_poso;
        break;
    case 3:
        poso_FPA=0.13*sunoliko_poso;
        break;
    default:
        poso_FPA=0.19*sunoliko_poso;
        break;
    }
    return(poso_FPA);
}

