/*Το πρόγραμμα υπολογίζει τα δημοτικά τέλη και το δημοτικό φόρο
  ανάλογα με τα τετραγωνικά ενός σπιτιού*/

#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    long    mikta_tm,ka8ara_tm;
    double  DT,DF;

    printf("Dwse ta ka8ara tm tou spitiou?\n");
    ka8ara_tm=GetLong();

    printf("Dwse ta mikta tm tou spitiou?\n");
    mikta_tm=GetLong();

    DT=ka8ara_tm*1.33*61/365;
    DF=mikta_tm*0.13*61/365;

    printf("Ta DT einai:%g\n",DT);
    printf("O DF einai:%g\n",DF);
}
