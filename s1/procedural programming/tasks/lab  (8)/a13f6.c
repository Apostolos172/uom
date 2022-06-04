#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

int pshfia_arithmou(int size, int table[], long arithmos);
int max_pinaka(int size, int table[], int max);
float mesos_oros_pinaka(int size, int table[]);
void decompose(long n, int *plhthos_digits, float *mesos_oros_digits, int *max_digit);

int main(void)
{
    int plhthos_pshfiwn,max_pshfio;
    long n;
    float mesos_oros_pshfiwn;

    printf("Please insert non-negative number: ");
    n=GetLong();
    decompose(n,&plhthos_pshfiwn,&mesos_oros_pshfiwn,&max_pshfio);
    printf("\nDigits: %d, Average: %4.3f, Max: %d",plhthos_pshfiwn,mesos_oros_pshfiwn,max_pshfio);
    printf("\n");

    system("pause");
    return(0);
}

void decompose(long n, int *plhthos_digits, float *mesos_oros_digits, int *max_digit)
{
    int DIGITS[10];

    //Η αποσύνθεση ενός αριθμού μπορεί να χωριστεί σε επιμέρους ενέργειες
    *plhthos_digits=pshfia_arithmou(10,DIGITS,n);
    *mesos_oros_digits=mesos_oros_pinaka(*plhthos_digits,DIGITS);
    *max_digit=max_pinaka(*plhthos_digits,DIGITS,*max_digit);
}

int pshfia_arithmou(int size, int table[], long arithmos )
{
    int k;

    k=-1;
    while(arithmos/10!=0)
    {
        k+=1;
        table[k]=arithmos%10;
        arithmos=arithmos/10;
    }
    table[k+1]=arithmos;
    k=k+1;
    return(k+1);
}

int max_pinaka(int size, int table[], int max)
{
    int i;

    max=table[0];
    for(i=1;i<size;i++)
    {
        if(table[i]>max)
        {
            max=table[i];
        }
    }
    return(max);
}

float mesos_oros_pinaka(int size, int table[])
{
    int i,sum;

    sum=0;
    for(i=0;i<size;i++)
    {
        sum+=table[i];
    }
    return(1.0*sum/(size));
}
