#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include"string.h"

#define size 20

typedef struct
{
   int arithmos;
   char marka[20];
   int kybika;
   char onoma[20];
   int hmeres_enoikiashs;
   float thmh_hmeras;
   float total_charge;
}enoikiashT;

typedef struct
{
    char type[20];
    int cc;
    float amount;
}best_carT;

void data(int n, enoikiashT table[]);
float plhrwmh(int n, enoikiashT table[]);
best_carT max(int n, enoikiashT table[]);
void printing(int n, enoikiashT table[], best_carT car, float total);

int main(void)
{
    enoikiashT etairia[size];
    best_carT car1;
    int n;
    float total;

    printf("Dwse to plhthos twn enoikiasewn: \n");
    n=GetInteger();
    data(n,etairia);
    total=plhrwmh(n,etairia);
    car1=max(n,etairia);
    printing(n,etairia,car1,total);

    system("pause");
    return(0);
}



void data(int n, enoikiashT table[])
{
    int i;

    printf("\n");
    for(i=0;i<n;i++)
    {
        printf("Dwse ta stoixeia ths enoikiashs: \n");
        table[i].arithmos=GetInteger();
        printf("Dwse marka: \n");
        gets(table[i].marka);
        printf("Dwse kybika: \n");
        table[i].kybika=GetInteger();
        printf("Dwse onoma pelath: \n");
        gets(table[i].onoma);
        printf("Dwse hmeres enoikiashs: \n");
        table[i].hmeres_enoikiashs=GetInteger();
        printf("Dwse thmh ana hmera: \n");
        table[i].thmh_hmeras=GetReal();
        printf("\n");
    }
}

float plhrwmh(int n, enoikiashT table[])
{
    int i;
    float sum=0;

    for(i=0;i<n;i++)
    {
        table[i].total_charge=table[i].hmeres_enoikiashs*table[i].thmh_hmeras;
        sum+=table[i].total_charge;
    }

    return(sum);
}

best_carT max(int n, enoikiashT table[])
{
    int i;
    best_carT temp_max;

    strcpy(temp_max.type, table[0].marka);
    //temp_max.type[20]=table[0].marka[20];
    temp_max.cc=table[0].kybika;
    temp_max.amount=table[0].total_charge;
    for(i=1;i<n;i++)
    {
        if(table[i].total_charge>temp_max.amount)
        {
            //temp_max.type[20]=table[i].marka[20];
            strcpy(temp_max.type, table[i].marka);
            temp_max.cc=table[i].kybika;
            temp_max.amount=table[i].total_charge;
        }
    }

    return(temp_max);
}

void printing(int n, enoikiashT table[], best_carT car, float total)
{
    int i;

    printf("\n\n");
    printf(" %-7s %-20s %-10s %-5s %-5s %-6s %-6s\n","Number","Name","Type","CC","Days","Prices","Total");
    for(i=0;i<70;i++)
    {
        printf("-");
    }
    printf("\n");
    for(i=0;i<n;i++)
    {
        printf(" %-7d ",table[i].arithmos);
        printf("%-20s ",table[i].onoma);
        printf("%-10s ",table[i].marka);
        printf("%-5d ",table[i].kybika);
        printf("%-5d ",table[i].hmeres_enoikiashs);
        printf("%-6.2f ",table[i].thmh_hmeras);
        printf("%-6.2f ",table[i].total_charge);
        printf("\n");
    }
    for(i=0;i<70;i++)
    {
        printf("-");
    }
    printf("\n");
    printf("%58s %-5.2f\n","Total",total);
    printf("\n Best car: %s %d rented for %.2f Euros.\n",car.type,car.cc,car.amount);
}

