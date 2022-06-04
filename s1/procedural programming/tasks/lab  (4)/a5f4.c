#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

bool IsArmstrong(int sum,int n);
int Sum_Cube(int n);
int cube(int a);

int main()
{
    int sum,n;

    printf("Parakatw emfanizontai oi arithmoi Armstrong apo to 1 mexri to 999:\n");
    for(n=1;n<1000;n++)
    {
        sum=Sum_Cube(n);
        if(IsArmstrong(sum,n))
        {
            printf("%4d ",n);
        }
    }
    system("pause");
}

bool IsArmstrong(int sum,int n)
{
    return(n==sum);
}

int Sum_Cube(int n)
{
    int prwto,dyo_teleutaia,deutero,trito,sum;

    if(n<=9)
    {
        sum=n;
    }
    else if(n<=99)
    {
        sum=(n/10)*(n/10)+(n%10)*(n%10);
    }
    else
    {
        prwto=n/100;
        dyo_teleutaia=n%100;
        deutero=dyo_teleutaia/10;
        trito=dyo_teleutaia%10;
        sum=cube(prwto)+cube(deutero)+cube(trito);
    }
    return(sum);
}

int cube(int a)
{
    int kybos,i;
    kybos=1;

    for(i=0;i<3;i++)
    {
        kybos=a*kybos;
    }
    return(kybos);
}
