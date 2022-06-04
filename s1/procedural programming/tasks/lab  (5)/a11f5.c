#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<math.h>

#define lines 10
#define columns 3

int main()
{
     double static TEMP[10][3] ={   4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10,
                                    4,5,10};
     double /*TEMP[lines][columns],*/sum,max,MAX[lines],MO[lines],ethnikos_mesos_oros,apoklhsh;
     int i,j;

    /*γέμισμα πίνακα*/
    /*for(i=0;i<lines;i++)
    {
        for(j=0;j<columns;j++)
        {
            printf("Dwse thn %dh metrhsh\n",j+1);
            TEMP[i][j]=GetReal();
        }
    }*/

    /*εθνικός μέσος όρος θερμοκρασίας*/
    sum=0;
    for(i=0;i<lines;i++)
    {
        for(j=0;j<columns;j++)
        {
            sum+=TEMP[i][j];
        }
    }
    ethnikos_mesos_oros=sum/30;

    /*μέση θερμοκρασία κάθε πόλης*/
    for(i=0;i<lines;i++)
    {
        sum=0;
        for(j=0;j<columns;j++)
        {
            sum+=TEMP[i][j];
        }
        MO[i]=sum/3;
    }

    /*απόκλιση κάθε θερμοκρασίας από τον εθνικό μέσο όρο*/
    for(i=0;i<lines;i++)
    {
        for(j=0;j<columns;j++)
        {
            apoklhsh=fabs(TEMP[i][j]-ethnikos_mesos_oros);
            /*if(apoklhsh<0)
            {
                apoklhsh=-apoklhsh;
            }*/
            TEMP[i][j]=apoklhsh;
        }
    }

    /*εύρεση μέγιστης απόκλισης κάθε πόλης από τον εθνικό μέσο όρο*/
    for(i=0;i<lines;i++)
    {
        max=TEMP[i][0];
        if(TEMP[i][1]>max)
            {
                max=TEMP[i][1];
            }
        if(TEMP[i][2]>max)
            {
                max=TEMP[i][2];
            }
        MAX[i]=max;
    }

    /*εμφάνιση αποτελεσμάτων*/
    printf("O ethnikos mesos oros einai %g\n",ethnikos_mesos_oros);
    for(i=0;i<lines;i++)
    {
        printf("mesh thermokrasia %.1lf , megisth apoklish %.1lf polhs %d\n",MO[i],MAX[i],i+1);
    }

    system("pause");
    return(0);
}
