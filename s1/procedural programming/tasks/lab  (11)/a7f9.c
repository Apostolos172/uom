#include<stdio.h>
#include"genlib.h"

int main(void)
{
    FILE *input,*output;
    int flag,prohgoumeno,ch;

    printf("To programma pairnontas dedomena apo to arxeio eisodou i7f9.dat emfanizei sto arxeio\n keimenou o7f9.dat tous arithmous pou uparxoun sto arxeio eisodou,\n enan arithmo se kathe seira.\n\n");

    input=fopen("i7f9.dat","r");
    if(input==NULL)
    {
        printf("To arxeio i7f9.dat den yparxei. Prospathhse pali.\n");
        exit(1);
    }

    output=fopen("o7f9.dat","w");

    while(TRUE)
    {
        flag=0;
        ch=fgetc(input);
        if(ch==EOF) break;
        if(ch>=48&&ch<=57)
        {
             fputc(ch,output);
             flag=1;
             prohgoumeno=0;
        }
        if(flag!=1&&prohgoumeno!=1)
        {
            fputc('\n',output);
            prohgoumeno=1;
        }
    }

    fclose(input);
    fclose(output);

    system("pause");
    return(0);
}
