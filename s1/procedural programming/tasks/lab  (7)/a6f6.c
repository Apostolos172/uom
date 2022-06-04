#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

#define N 5

void realData(int r, int c, int table[r][c]);
void FindMean(int r, int c, int table[r][c], double *pmoA, double *pmoG, int stoixeio);

int main(void)
{
    int table[N][4],stoixeio;
    double moA,moG;

    realData(N,4,table);

    FindMean(N,4,table,&moA,&moG,1);
    printf("\n\nMesos oros barous andrwn: %g",moA);
    printf("\nMesos oros barous gynaikwn: %g",moG);

    FindMean(N,4,table,&moA,&moG,2);
    printf("\n\nMesos oros ypsous andrwn: %g",moA);
    printf("\nMesos oros ypsous gynaikwn: %g",moG);

    FindMean(N,4,table,&moA,&moG,3);
    printf("\n\nMesos oros hlikias andrwn: %g",moA);
    printf("\nMesos oros hlikias gynaikwn: %g",moG);

    printf("\n");
    system("pause");
    return(0);
}

void realData(int r, int c, int table[r][c])
{
    int i,j;

    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            switch(j)
            {
            case 0:
                printf("Dwse fylo:\n");
                break;
            case 1:
                printf("Dwse baros:\n");
                break;
            case 2:
                printf("Dwse ypsos:\n");
                break;
            default:
                printf("Dwse hlikia:\n");
                break;
            }
            table[i][j]=GetInteger();
        }
        printf("-----\n");
    }
}

void FindMean(int r, int c, int table[r][c], double *pmoA, double *pmoG, int stoixeio)
{
    int i,gynaikes,andres;

    gynaikes=andres=0;
    *pmoA=*pmoG=0;
    for(i=0;i<r;i++)
    {
        if(table[i][0]==0)
        {
            *pmoA+=table[i][stoixeio];
            andres++;
        }
        else
        {
            *pmoG+=table[i][stoixeio];
            gynaikes++;
        }
    }
    if(andres!=0)
    {
        *pmoA/=andres;
    }
    else
    {
        printf("\n\nKanenas andras\n");
    }

    if(gynaikes!=0)
    {
        *pmoG/=gynaikes;
    }
    else
    {
        printf("\n\nKamia gynaika\n");
    }

}
