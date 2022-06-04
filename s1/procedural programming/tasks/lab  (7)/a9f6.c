#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

#define pwlhtes 4
#define proionta 5

/*Στους μονοδιάστατους πίνακες που τοποθετούνται ως τυπικές παράμετροι στις συναρτήσεις δεν απαιτείται η δήλωση της διάστασης και εντός των αγκυλών*/
void calculateSales(int pwl, int pro,int times[pro], int salesTable[pwl][pro], int salesPerson[pwl]);
void calculateProductsSales(int pwl, int pro,int times[pro], int salesTable[pwl][pro], int productSale[pro]);
void printArray(int size, int table[size]);
void maxArray(int size,int table[size],int *max,int *pos);

int main(void)
{
    int salesTable[pwlhtes][proionta]={ 10, 4,  5,  6, 7,
                                        7,  0,  12, 1, 3,
                                        4,  19, 5,  0, 8,
                                        3,  2,  1,  5, 6  };
    int times[proionta]={250, 150, 320, 210, 920};
    int salesPerson[pwlhtes],productSale[proionta];
    int best_salesman,sales_best_salesman;
    int best_product,items_best_product;


    calculateSales(pwlhtes,proionta,times,salesTable,salesPerson);
    calculateProductsSales(pwlhtes,proionta,times,salesTable,productSale);

    printf("SalesMan Sales\n");
    printArray(pwlhtes,salesPerson);

    maxArray(pwlhtes,salesPerson,&best_salesman,&sales_best_salesman);
    printf("Best SalesMan was %d with %d sales.\n",sales_best_salesman,best_salesman);

    printf("Product Items\n");
    printArray(proionta,productSale);

    maxArray(proionta,productSale,&best_product,&items_best_product);
    printf("Best Product was %d with %d items.\n",items_best_product,best_product);

    system("pause");
    return(0);
}

void calculateSales(int pwl, int pro,int times[pro], int salesTable[pwl][pro], int salesPerson[pwl])
{
    int i,j;

    for(i=0;i<pwl;i++)
    {
        salesPerson[i]=0;
        for(j=0;j<pro;j++)
        {
            salesPerson[i]+=salesTable[i][j]*times[j];
        }
    }
}

void calculateProductsSales(int pwl, int pro,int times[pro], int salesTable[pwl][pro], int productSale[pro])
{
    int i,j;

    for(j=0;j<pro;j++)
    {
        productSale[j]=0;
        for(i=0;i<pwl;i++)
        {
            productSale[j]+=salesTable[i][j];
        }
    }
}

void printArray(int size, int table[size])
{
    int i;

    for(i=0;i<size;i++)
    {
        printf("   %-5d %-5d\n",i,table[i]);
    }
}

void maxArray(int size,int table[size],int *max,int *pos)
{
    int i;

    *max=table[0];
    *pos=0;
    for(i=1;i<size;i++)
    {
        if(table[i]>*max)
        {
            *max=table[i];
            *pos=i;
        }
    }
}
