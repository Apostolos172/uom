#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

int main()
{
    int M,N,i,j;
    long TABLE[100][100],SUMC[100],SUML[100],diag1,diag2;

    /*�������� �������*/
    printf("Dwse ton arithmo twn grammwn: \n");
    M=GetInteger();

    /*�������� ������*/
    printf("Dwse ton arithmo twn sthlwn: \n");
    N=GetInteger();

    /*������� ������*/
    for(i=0;i<M;i++)
    {
        for(j=0;j<N;j++)
        {
            printf("Thesh [%ld,%ld]:",i,j);
            TABLE[i][j]=GetLong();
        }

    }

    /*����������� ����������� ���� ������*/
    for(i=0;i<M;i++)
    {
        SUML[i]=0;
        for(j=0;j<N;j++)
        {
            SUML[i]+=TABLE[i][j];
        }
    }

    /*����������� ����������� ���� �����*/
    for(j=0;j<N;j++)
    {
        SUMC[j]=0;
        for(i=0;i<M;i++)
        {
            SUMC[j]+=TABLE[i][j];
        }
    }

    /*���������� ���������*/
    if(M==N)
    {
        diag1=diag2=0;
        for(i=0;i<M;i++)
        {
            diag1+=TABLE[i][i];
            for(j=0;j<N;j++)
            {
                if(i+j==M-1)
                {
                    diag2+=TABLE[i][j];
                }
            }
        }
    }

    /*�������� �������������*/

    printf("Table:\n");
    for(i=0;i<M;i++)
    {
        for(j=0;j<N;j++)
        {
            printf("%4ld",TABLE[i][j]);
        }
        printf(" | = %-ld",SUML[i]);
        printf("\n");
    }
    printf("------------\n");
    for(j=0;j<N;j++)
        {
            printf("%4ld",SUMC[j]);
        }
    printf("\n");

    if(M==N)
    {
        printf("Sum Diag 1: %ld, Sum Diag 2: %ld",diag1,diag2);
        printf("\n");
    }

    system("pause");
    return(0);
}
