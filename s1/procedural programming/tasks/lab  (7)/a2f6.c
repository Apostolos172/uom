#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

#define size 100

int populate_data(int siz, int table[siz]);
void min_max(int siz, int table[siz], int *pmin, int *pmax);

int main(void)
{
    int table[size],plhthos,min,max;

    plhthos=populate_data(size,table);
    min_max(plhthos,table,&min,&max);
    printf("The range of values is %d - %d\n",min,max);

    system("pause");
    return(0);
}

int populate_data(int siz, int table[siz])
{
    int n,i;

    i=-1;
    printf("Enter the elements of the array, one per line.\nUse -1 to signal the end of the list.\n");
    while(TRUE)
    {
        printf(" ? ");
        n=GetInteger();
        if(n==-1) break;
        i+=1;
        table[i]=n;
    }
    return(i+1);
}

void min_max(int siz, int table[siz], int *pmin, int *pmax)
{
    int i;

    *pmin=table[0];
    *pmax=table[0];
    for(i=1;i<siz;i++)
    {
        if(table[i]<*pmin)
        {
            *pmin=table[i];
        }
        if(table[i]>*pmax)
        {
            *pmax=table[i];
        }
    }
}
