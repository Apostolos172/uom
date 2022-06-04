#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include<math.h>

main()
{
   long arithmos_autokinhtwn, orio, eth;
   double ruthmos_aukshshs;

   printf("Dwse ton arxiko arithmo autokinhtwn :\n");
   arithmos_autokinhtwn=GetLong();
   printf("Dwse ton ethsio ruthmo auxhshs :\n");
   ruthmos_aukshshs=GetReal();
   printf("Dwse to orio :\n");
   orio=GetLong();
   eth=0;

   while(arithmos_autokinhtwn<=orio)
   {
       arithmos_autokinhtwn=ceil(arithmos_autokinhtwn*(1+ruthmos_aukshshs));
       eth+=1;
   }

   printf("O arithmos autokinhtwn , afou kseperasthke to orio , einai :%ld\n",arithmos_autokinhtwn);
   printf("Ta eth pou xreiasthkan gia na kseperastei to orio einai :%ld\n",eth);

    system("pause");
}
