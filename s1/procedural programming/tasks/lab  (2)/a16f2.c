/*Το πρόγραμμα ζητάει να πληκτρολογήσουμε το πλήθος των sms που
  στείλαμε και υπολογίζει και εμφανίζει σε ευρώ , το συνολικό ποσό που πρέπει να πληρώσουμε*/

#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int SMS;
    double poso,poso_se_euro;

    printf("Dwse plhthos SMS:\n");
    SMS=GetInteger();
    if(SMS<=10)
    {
        poso=SMS*2;
    }
    else if(SMS<=60)
    {
        poso=10*2+(SMS-10)*1.5;
    }
    else if(SMS<=160)
    {
        poso=10*2+50*1.5+(SMS-60)*1.2;
    }
    else
    {
        poso=10*2+50*1.5+100*1.2+(SMS-160)*1;
    }
    poso_se_euro=poso/100;
    printf("To synoliko poso se euro %g\n",poso_se_euro);
    system("pause");
}
