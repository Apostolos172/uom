#include<stdio.h>
#include<stdlib.h>
#include"genlib.h"
#include"simpio.h"

#define size 50

void populate_data(int r, int table[r]);
void print_array(int r, int table[r]);
int check_table(int r, int table[r], int theseis_n[r], int n);

int main()
{
    int a[size],n,theseis_n[size],i,fores;

    populate_data(size, a);
    print_array(size, a);
    printf("\n---------------\nDwse enan arithmo apo to 0 ews to 9: \n");
    n=GetInteger();
    fores=check_table(size, a, theseis_n, n)+1;
    printf("O arithmos %d emfanizetai %d fores.\nStis theseis:\n",n,fores);
    print_array(fores,theseis_n);
    printf("\n---------------\n");

    system("pause");
    return(0);
}

void populate_data(int r, int a[r])
{
    int i;

    for(i=0;i<r;i++)
    {
        a[i]=rand()%10;
    }
}

void print_array(int r, int a[r])
{
    int i;

    for(i=0;i<r;i++)
    {
        printf(" %-2d",a[i]);
    }
}

int check_table(int r, int table[r], int theseis_n[r], int n)
{
    int i,k;

    k=-1;
    for(i=0;i<size;i++)
    {
        if(table[i]==n)
        {
            k+=1;
            theseis_n[k]=i;
        }
    }
    return(k);
}

