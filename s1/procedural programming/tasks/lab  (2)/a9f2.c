#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int code,arithmos_temaxiwn,timh;
    double rate,sale,telikh_timh_ths_paraggelias;

    printf("Dwse ton kwdiko tou proiontos:\n");
    code=GetInteger();
    printf("Dwse ton arithmo twn temaxiwn:\n");
    arithmos_temaxiwn=GetInteger();
    timh=code%100+code/100;
    if(arithmos_temaxiwn<=30)
    {
        rate=0.1;
    }
    else if(arithmos_temaxiwn<=70)
    {
        rate=0.2;
    }
    else
    {
        rate=0.35;
    }
    sale=rate*arithmos_temaxiwn*timh;
    telikh_timh_ths_paraggelias=timh*arithmos_temaxiwn-sale;
    printf("H timh pwlhshs tou proiontos einai %d\n",timh);
    printf("H ekptwsh einai %g\n",sale);
    printf("H telikh timh ths paraggelias einai %g\n",telikh_timh_ths_paraggelias);
    system("pause");
}
