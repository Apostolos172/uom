#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

int total(int n);
void enhmerwsh(int n);

main()
{
    int n;
    for(n=100;n<=1000;n=n+900)
    {
        enhmerwsh(n);
    }

    system("pause");
}

int total(int n)
{
    int sum,i;
    sum=0;

    for(i=1;i<=n;i++)
    {
        sum+=i;
    }

    return(sum);
}

void enhmerwsh(int n)
{
    printf("To athroisma pou zhteitai me telikh timh ton arithmo %d einai %d\n",n,total(n));
}
