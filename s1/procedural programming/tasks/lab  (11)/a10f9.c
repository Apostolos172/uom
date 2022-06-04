#include<stdio.h>
#include"genlib.h"

int main(void)
{
    FILE *eisodos,*eksodos;
    int ch,epomeno;

    printf("To programma pairnontas ta dedomena apo to arxeio eisodou i10f9.dat\n prosthetei enan keno xarakthra, an den yparxei hdh, meta apo tous xarakthres ',' kai '.'\n kai antigrafei to neo keimeno sto arxeio eksodou o10f9.dat.\n\n");

    eisodos=fopen("i10f9.dat","r");
    if(eisodos==NULL)
    {
        printf("To arxeio i10f9.dat den yparxei. Prospathhse pali.\n");
        exit(1);
    }

    eksodos=fopen("o10f9.dat","w");

    while(TRUE)
    {
        ch=fgetc(eisodos);
        if(ch==EOF) break;
        epomeno=fgetc(eisodos);
        if(epomeno==EOF&&ch!='.') break;
        fputc(ch,eksodos);
        if(epomeno==EOF) break;
        if((ch==','||ch=='.')&&epomeno!=' ')
        {
            fputc(' ',eksodos);
        }
        fputc(epomeno,eksodos);
    }

    fclose(eisodos);
    fclose(eksodos);

    system("pause");
    return(0);
}
