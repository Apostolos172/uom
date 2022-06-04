#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

#define m 10
#define n 3

main()
{
   // Δίνονται Αρχικές τιμές στον Πίνακα για εύκολο έλεγχο
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
    double average[m], mdeviation[m];
    double natavg;
    int i, j, choice;

	printf("Would you like to read temp data or use default? (1-read, 2-use Default): ");
    while(TRUE){
        choice = GetInteger();
        if (choice == 1)
           {  /* Reading the temp Table */
              for (i=0; i<m; i++)
                for (j=0; j<n; j++)
		  	    { printf("Temp of City %d During %d 8-hour period: ",i,j);
                  temper[i][j] = GetReal();
                }
              /* End reading the table */
            break;
            }
        else if (choice == 2) {break;}
        printf("Please enter a valid choice! \n (1-read, 2 - use Default): ");
    }


	/*Calculating The Average of all Cities&Temps*/
    natavg = 0;
    for (i=0; i<m; i++)
      for (j=0; j<n; j+=1)
         natavg += temper[i][j];
    natavg = natavg/(m*n);

	/*Calculating Average temp on each City*/
	for (i=0; i<m; i++)
    {
        average[i] = 0;
        for (j=0; j<n; j++)
        {
            average[i] += temper[i][j];
        }
        average[i] = average[i]/n;
    }

	/*Calculating Standard Deviation*/
    for (i=0; i<m; i++)
        for (j=0; j<n; j++)
            devnat[i][j] = fabs(natavg-temper[i][j]);

	/*Calculating max Deviation*/
    for (i=0; i<m; i++)
    {
        mdeviation[i] = devnat[i][0];
        for(j=1; j<n; j++)
            if (mdeviation[i]<devnat[i][j]) mdeviation[i] = devnat[i][j];
    }

    /*Printing results*/
    printf("National Average: %3.1f\n", natavg);
    for (i=0; i<m; i+=1)
		printf("City %d  Average: %.1lf  Max Deviation: %.1lf\n",i, average[i], mdeviation[i]);
}
