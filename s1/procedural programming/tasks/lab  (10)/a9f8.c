#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

typedef struct
{
    char name[20];
    char surname[20];
    float salary_per_hour;
    int hours;
    float miktes_apodoxes;
    float krathseis;
    float foros;
    float kathares_apodoxes;
}employee;

void get_data(int n, employee table[]);
void calc_salaries(int n, employee table[]);
void print_data(int n, employee table[]);

int main(void)
{
    int n;

    printf("Dwse to plhthos twn ypallhlwn: ");
    n=GetInteger();
    printf("\n");

    employee kathhghtes[n];

    get_data(n,kathhghtes);
    calc_salaries(n,kathhghtes);
    print_data(n,kathhghtes);

    system("pause");
    return(0);
}

void get_data(int n, employee table[])
{
    int i;

    for(i=0;i<n;i++)
    {
        printf("Dwse ta stoixeia tou kathhghth: %d",i);
        printf("\nDwse onoma: ");
        gets(table[i].name);
        printf("Dwse epwnymo: ");
        gets(table[i].surname);
        printf("Dwse mistho wras: ");
        table[i].salary_per_hour=GetReal();
        printf("Dwse wres ergasias: ");
        table[i].hours=GetInteger();
        printf("\n");
    }
}

void calc_salaries(int n, employee table[])
{
    int i;

    for(i=0;i<n;i++)
    {
        table[i].miktes_apodoxes=table[i].hours*table[i].salary_per_hour;
        table[i].krathseis=15/100.0*table[i].miktes_apodoxes;
        table[i].foros=7/100.0*(table[i].miktes_apodoxes-table[i].krathseis);
        table[i].kathares_apodoxes=table[i].miktes_apodoxes-table[i].krathseis-table[i].foros;
    }
}

void print_data(int n, employee table[])
{
    int i;

    printf(" %-10s %-15s %10s %15s %10s %15s %10s %10s\n","Name","Surname","Hourly Rate","Hours Worked","Gross","Deductions","Tax","Net");
    for(i=0;i<104;i++)
    {
        printf("-");
    }
    printf("\n");
    for(i=0;i<n;i++)
    {
        printf(" %-10s %-15s  %10.2f %15d %10.2f %15.2f %10.2f %10.2f\n",table[i].name,table[i].surname,table[i].salary_per_hour,table[i].hours,table[i].miktes_apodoxes,table[i].krathseis,table[i].foros,table[i].kathares_apodoxes);
    }
    for(i=0;i<104;i++)
    {
        printf("-");
    }
    printf("\n");
}

