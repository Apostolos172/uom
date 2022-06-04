#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

int main()
{
    int TABLE[5],i,TEMP[5];

    for(i=0;i<5;i++)
    {
        printf("Dwse ton %do arithmo: \n",i+1);
        TABLE[i]=GetInteger();
    }

    /*printf(" %d",TABLE[4]);
    for(i=0;i<4;i++)
    {
        printf(" %d",TABLE[i]);
    }
    printf("\n");*/

    for(i=0;i<5;i++)
    {
        TEMP[i]=TABLE[i];
    }

    for(i=0;i<4;i++)
    {
        TABLE[i+1]=TEMP[i];
    }
    TABLE[0]=TEMP[4];


    for(i=0;i<5;i++)
    {
        printf("%d ",TABLE[i]);
    }
    printf("\n");

    system("pause");
    return(0);
}
