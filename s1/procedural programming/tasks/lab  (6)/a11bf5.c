#include<stdio.h>
#include<math.h>
#include"genlib.h"
#include"simpio.h"

#define m 10
#define n 3

void Read_Data(int r, int c, double temper[r][c]);
double Calculate_Average(int r, int c, double temper[r][c]);
void Calculate_Average_temp_on_each_City(int r, int c, double temper[r][c], double average[r]);
void Calculating_Standard_Deviation(int r, int c, double temper[r][c], double avg, double devnat[r][c]);
void Calculating_max_Deviation(int r, int c, double devnat[r][c], double mdeviation[r]);
void Printing_results(int r, double average[r],double mdeviation[r], double avg);

int main()
{
    double temper[m][n] =       {   10,20,30,
                                    40,50,60,
                                    70,80,90,
                                    10,20,30,
                                    40,50,60,
                                    70,80,90,
                                    10,20,30,
                                    40,50,60,
                                    70,80,90,
                                    00,00,00};
    double devnat[m][n];
    double avg;
    double average[m],mdeviation[m];
    int i, j, choice;

	printf("Would you like to read temp data or use default? (1-read, 2-use Default): ");
    while(TRUE)
    {
        choice = GetInteger();
        if (choice == 1)
           {  /* Reading the temp Table */
              for (i=0; i<m; i++)
                for (j=0; j<n; j++)
		  	    { printf("Temp of City %d During %d 8-hour period: ",i+1,j+1);
                  temper[i][j] = GetReal();
                }
              /* End reading the table */
            break;
            }
        else if (choice == 2) {break;}
        printf("Please enter a valid choice! \n (1-read, 2 - use Default): ");
    }

    /*Read_Data(m,n,temper);*/
    avg=Calculate_Average(m,n,temper);
    Calculate_Average_temp_on_each_City(m,n,temper,average);
    Calculating_Standard_Deviation(m,n,temper,avg,devnat);
    Calculating_max_Deviation(m,n,devnat,mdeviation);
    Printing_results(m,average,mdeviation,avg);

    return(0);
}

void Read_Data(int r, int c, double temper[r][c])
{
    int i,j;

    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            printf("Temp of City %d During %d 8-hour period: ",i+1,j+1);
            temper[i][j]=GetReal();
        }
    }
}

double Calculate_Average(int r, int c, double temper[r][c])
{
    int i,j;
    double natavg;

    natavg = 0;
    for (i=0; i<r; i++)
    {
        for (j=0; j<c; j+=1)
        {
            natavg += temper[i][j];
        }
    }
    natavg = natavg/(r*c);
    return(natavg);
}

void Calculate_Average_temp_on_each_City(int r, int c, double temper[r][c], double average[r])
{
    int i,j;

    for (i=0; i<r; i++)
    {
        average[i] = 0;
        for (j=0; j<c; j++)
        {
            average[i] += temper[i][j];
        }
        average[i] = average[i]/c;
    }
}

void Calculating_Standard_Deviation(int r, int c, double temper[r][c], double avg, double devnat[r][c])
{
    int i,j;

    for (i=0; i<m; i++)
    {
        for (j=0; j<n; j++)
        {
             devnat[i][j] = fabs(avg-temper[i][j]);
        }
    }
}

void Calculating_max_Deviation(int r, int c, double devnat[r][c], double mdeviation[r])
{
    int i,j;

    for (i=0; i<m; i++)
    {
        mdeviation[i] = devnat[i][0];
        for(j=1; j<n; j++)
        {
            if (mdeviation[i]<devnat[i][j])
            {
                mdeviation[i] = devnat[i][j];
            }
        }
    }
}

void Printing_results(int r, double average[r],double mdeviation[r], double avg)
{
    int i;

    printf("%3.1f\n", avg);
    for (i=0; i<m; i+=1)
		printf("City %2d:   %4.1f  %.1f\n",i+1, average[i], mdeviation[i]);
    system("PAUSE");
}
