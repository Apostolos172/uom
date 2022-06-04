//Stock Market Analysis

#include <stdio.h>
#include"genlib.h"//Εδώ περιέχεται η system και η bool δήλωση
//#include"simpio.h"

bool element(float value, int row, int *pos, int r, int c, float table[r][c]);
void high_low(int r,int c, float deriv_day_data[][c],int *high,int *low,int paragwgos);
void printing3(int size, float table1[], int table2[], float table3[]);
void value(int size, int risks[], float cds_prices[], float timh[]);
void printing2(int size, float table[]);
void printing(int size, float table[], float max);
void diaxwristiko(int size);
void max_pinaka(int size, float table[], float *max);
void interesting_values(int size, float table_prices[], float table[], int *ni_table, float max);

int main(void)
{
   float stock_prices[10] = {34.5, 22.4, 77.8, 22.1, 10.0, 11.25, 12, 13, 16, 20.5 };
   float deriv_prices[5] = {30.5, 21.4, 89.8, 20.1, 10.0};
   float cds_prices[11] = {38.5, 33.4, 67.8, 12.1, 16.0, 10.25, 11, 23, 36, 10.1 ,30.4};
   int risk[11] = {90,10,20,30,50,60,30,30,30,10,10};

   float max_stock, max_deriv, max_cds;
   float timh_aksiologhshs[11];

   float interesting_stock[10];
   int ni_stock;
   float interesting_cds[11];
   int ni_cds;

   int i,high,low;

   float deriv_day_data[5][10] =  {
                {30.5,25,22,32.3,30.5,32.6,38.9,40,22,30.5},
                {22.5,21.4,14,40.3,22.5,12.6,38.9,40,39,21.4},
                {30.5,25,22,89.8,34.5,89.8,38.9,40,30,89.8},
                {20.2,35,20.1,12.3,20.1,32.6,38.9,40,22,20.1},
                {45.5,10.0,22,10.0,14.5,23.6,48.9,8,10.0,10.0}
                                  };

   // Calculating Max Values
   max_pinaka(10,stock_prices,&max_stock);
   max_pinaka(5,deriv_prices,&max_deriv);
   max_pinaka(11,cds_prices,&max_cds);

   // Finding Interesting Values
   interesting_values(10,stock_prices,interesting_stock,&ni_stock,max_stock);
   interesting_values(11,cds_prices,interesting_cds,&ni_cds,max_cds);

   //Printing
   printf("Stock Prices.\n");
   diaxwristiko(30);
   printing(10,stock_prices,max_stock);
   printing2(ni_stock, interesting_stock);
   diaxwristiko(10);

   // Derivatives
   printf("Derivative Prices.\n");
   diaxwristiko(30);
   printing(5,deriv_prices,max_deriv);
   diaxwristiko(10);

   // Cds Prices
   printf("CDS Prices.\n");
   diaxwristiko(30);
   printing(11,cds_prices,max_cds);
   printing2(ni_cds, interesting_cds);
   diaxwristiko(10);

   value(11,risk,cds_prices,timh_aksiologhshs);
   printing3(11,cds_prices,risk,timh_aksiologhshs);

   //3o erwthma
   printf("\n");
   for(i=0;i<5;i++)
   {
         high_low(5,10,deriv_day_data,&high,&low,i);
         printf("Devirative %d, high %d / low %d values.\n",i,high,low);
   }

   system("pause");
   return(0);
}

void high_low(int r,int c, float deriv_day_data[][c],int *high,int *low,int paragwgos)
{
    int j;

    *high=*low=0;
    for(j=0;j<(c-1);j++)
    {
        if(deriv_day_data[paragwgos][j]>deriv_day_data[paragwgos][c-1])
        {
            *high+=1;
        }
        else if(deriv_day_data[paragwgos][j]<deriv_day_data[paragwgos][c-1])
        {
            *low+=1;
        }
    }
}

void printing3(int size, float table1[], int table2[], float table3[])
{
    int i;

    for(i=0;i<size;i++)
    {
        printf("\nCDS assessment: cds [%.2f] Risk [%d] Value [%.2f]",table1[i],table2[i],table3[i]);
    }
    printf("\n");
}

void printing2(int size, float table[])
{
    int i;

    for(i=0;i<size;i++)
    {
        printf(" [%4.2f] ",table[i]);
    }
    printf("\n");
}

void diaxwristiko(int size)
{
    int i;

    for(i=0;i<size;i++)
    {
        printf("-");
    }
    printf("\n");
}


void max_pinaka(int size, float table[], float *max)
{
    int i;

    *max=table[0];
    for(i=0;i<size;i++)
    {
        if(table[i]>*max)
        {
            *max=table[i];
        }
    }
}

void interesting_values(int size, float table_prices[], float interesting_table[], int *ni_table, float max)
{

   int i;

   *ni_table=0;
   for(i=0;i<size;i++)
   {
       if (table_prices[i] > max / 2)
       {
          interesting_table[(*ni_table)++] = table_prices[i];
       }
   }

}

void printing(int size, float table[], float max)
{
    int i;

    printf("Max Price:: %4.2f \n",max);
    for(i=0;i<10;i++)
    {
        printf("%s(%3.2f) ",(max== table[i] ? "-Max-" : ""),table[i]);
    }
    printf("\n");
}

void value(int size, int risks[], float cds[], float timh[])
{
    int i;

    for(i=0;i<size;i++)
    {
        if(cds[i]<20&&risks[i]<50)
        {
            timh[i]=20;
        }
        else if(cds[i]>=20&&risks[i]<80)
        {
            timh[i]=10+(cds[i]*risks[i])/100;
        }
        else
        {
            timh[i]=100+(cds[i]*risks[i])/100;
        }
    }
}


