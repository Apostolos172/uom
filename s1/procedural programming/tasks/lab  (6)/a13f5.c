#include<stdio.h>
#include<stdlib.h>
#include"genlib.h"
#include"simpio.h"

#define grammes 10
#define sthles 10

void populate_data(int r, int c, int table[r][c]);
void print_array(int r, int c, int table[r][c]);
void max_ana_grammh(int r, int c, int table[r][c], int max[r], int thesh_max[r]);
void change_array(int r, int c, int table[r][c], int max[r], int thesh_max[r]);

int main()
{
    int table[grammes][sthles],max[grammes],thesh_max[grammes],rows,columns;

    populate_data(grammes,sthles,table);
    printf("Dwse ton arithmo twn grammwn: \n");
    rows=GetInteger();
    printf("Dwse ton arithmo twn sthlwn: \n");
    columns=GetInteger();
    printf("ARXIKOS PINAKAS\n");
    print_array(rows,columns,table);
    max_ana_grammh(rows,columns,table,max,thesh_max);
    change_array(rows,columns,table,max,thesh_max);
    printf("ALLAGMENOS PINAKAS\n");
    print_array(rows,columns,table);

    system("pause");
    return(0);
}

void populate_data(int r, int c, int table[r][c])
{
    int i,j;

    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            table[i][j]=rand()%100;
        }
    }
}

void print_array(int r, int c, int table[r][c])
{
    int i,j;

    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            printf("%d ",table[i][j]);
        }
        printf("\n");
    }
}


void max_ana_grammh(int r, int c, int table[r][c], int max[r], int thesh_max[r])
{
    int i,j;

    for(i=0;i<r;i++)
    {
        max[i]=table[i][0];
        thesh_max[i]=0;
        for(j=1;j<c;j++)
        {
            if(table[i][j]>max[i])
            {
                max[i]=table[i][j];
                thesh_max[i]=j;
            }
        }
    }
}

void change_array(int r, int c, int table[r][c], int max[r], int thesh_max[r])
{
    int i,j;

    for(i=0;i<r;i++)
    {
        for(j=0;j<thesh_max[i];j++)
        {
               table[i][j]=max[i];
        }
    }
}

