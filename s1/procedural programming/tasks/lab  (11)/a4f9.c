#include<stdio.h>
#include<string.h>
#include"genlib.h"

#define size 7

typedef struct
{
    char onoma[25];
    long promhtheia;
}pwlhths;

int main(void)
{
    int kwdikos,line,i,nscanf,j;
    char name[25],ch;
    float pososto;
    long aksia;
    pwlhths pwlhtes[size];
    FILE *eisodos,*eksodos;

    printf("To programma pairnontas ta dedomena tou arxeiou i4f9.dat dhmiourgei deutero arxeio keimenou me onoma o3f9.dat\n pou periexei ta onomatepwnyma twn pwlhtwn me to poso ths promhtheias pou antistoixei ston kathena.\n\n");

    eisodos=fopen("i4f9.dat","r");
    if(eisodos==NULL)
    {
        printf("To arxeio i4f9.dat den yparxei. Prospathhse pali.\n");
        exit(1);
    }

    eksodos=fopen("o3f9.dat","w");

    line=0;
    while(TRUE)
    {
        nscanf=fscanf(eisodos,"%d,%25[^,],%ld%c",&kwdikos,name,&aksia,&ch);
        if(nscanf==EOF) break;
        line++;
        if(nscanf!=4||ch!='\n')
        {
            printf("Error in line %d. Program termination\n", line);
            exit(1);
        }
        strcpy(pwlhtes[line-1].onoma,name);
        switch(kwdikos)
        {
            case 11:
                pososto=0.03;
                break;
            case 12:
                pososto=0.05;
                break;
            case 13:
                pososto=0.08;
                break;
            default:
                pososto=0.11;
                break;
        }
        pwlhtes[line-1].promhtheia=pososto*aksia;
    }

    fclose(eisodos);

    fprintf(eksodos,"%-24s %6s\n","ONOMATEPWNYMO PWLHTH","POSO");
    for(j=0;j<31;j++)
    {
        fprintf(eksodos,"-");
    }
    fprintf(eksodos,"\n");
    for(i=0;i<line;i++)
    {
        fprintf(eksodos,"%-24s %6ld\n",pwlhtes[i].onoma,pwlhtes[i].promhtheia);
    }

    fclose(eksodos);

    system("pause");
    return(0);
}

