#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

 int main()
{
    int i,j,sum;
    long SUM[4];
    int static SALES[4][5]={10,4,5,6,7,
                            7,0,12,1,3,
                            4,9,5,0,8,
                            3,2,1,5,6};
    long static TIMH[5]={25000,15000,32000,21000,9200};

    /*1o ερώτημα*/
    printf("Sunoliko Poso Eisprakshs / Pwlhth: ");
    for(i=0;i<4;i++)
    {
        SUM[i]=0;
        for(j=0;j<5;j++)
        {
            SUM[i]+=SALES[i][j]*TIMH[j];
        }
        printf("%ld ",SUM[i]);
    }

    /*2o ερώτημα*/
    printf("\nPromhtheia / Pwlhth: ");
    for(i=0;i<4;i++)
    {
        printf("%.2f ",10/100.0*SUM[i]);
    }

    /*3o ερώτημα*/
    printf("\nPosothtes Proiontwn: ");
    for(j=0;j<5;j++)
    {
        sum=0;
        for(i=0;i<4;i++)
        {
            sum+=SALES[i][j];
        }
        printf("%d ",sum);
    }

    printf("\n");
    system("pause");

    return(0);
}
