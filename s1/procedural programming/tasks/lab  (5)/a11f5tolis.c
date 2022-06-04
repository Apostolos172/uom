#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<math.h>


main()
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
     double sum1,sum2=0,max,MAX[10],MO[10],ethnikos_mesos_oros,apoklhsh;
     int i,j;

     for(i=0;i<10;i++)
    {
        sum1=0;
        for(j=0;j<3;j++)
        {

           /*printf("Dwse thn %dh metrhsh\n",j+1);
            TEMP[i][j]=GetReal();*/
            sum1+=TEMP[i][j];
        }
        MO[i]=sum1/3;
        sum2+=MO[i];
    }
    ethnikos_mesos_oros=sum2/10;

    printf("O ethnikos mesos oros einai %g\n",ethnikos_mesos_oros);
    for(i=0;i<10;i++)
    {
        for(j=0;j<3;j++)
        {
            apoklhsh=fabs(TEMP[i][j]-ethnikos_mesos_oros);
            /*if(apoklhsh<0)
            {
                apoklhsh=-apoklhsh;
            }*/
            TEMP[i][j]=apoklhsh;
        }
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
        printf("MAX %.1lf mesh thermokrasia %.1lf polhs %d\n",MAX[i],MO[i],i+1);
    }
}



