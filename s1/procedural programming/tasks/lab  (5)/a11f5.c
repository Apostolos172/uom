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

    /*������� ������*/
    /*for(i=0;i<lines;i++)
    {
        for(j=0;j<columns;j++)
        {
            printf("Dwse thn %dh metrhsh\n",j+1);
            TEMP[i][j]=GetReal();
        }
    }*/

    /*������� ����� ���� ������������*/
    sum=0;
    for(i=0;i<lines;i++)
    {
        for(j=0;j<columns;j++)
        {
            sum+=TEMP[i][j];
        }
    }
    ethnikos_mesos_oros=sum/30;

    /*���� ����������� ���� �����*/
    for(i=0;i<lines;i++)
    {
        sum=0;
        for(j=0;j<columns;j++)
        {
            sum+=TEMP[i][j];
        }
        MO[i]=sum/3;
    }

    /*�������� ���� ������������ ��� ��� ������ ���� ���*/
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

    /*������ �������� ��������� ���� ����� ��� ��� ������ ���� ���*/
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

    /*�������� �������������*/
    printf("O ethnikos mesos oros einai %g\n",ethnikos_mesos_oros);
    for(i=0;i<lines;i++)
    {
        printf("mesh thermokrasia %.1lf , megisth apoklish %.1lf polhs %d\n",MO[i],MAX[i],i+1);
    }

    system("pause");
    return(0);
}
