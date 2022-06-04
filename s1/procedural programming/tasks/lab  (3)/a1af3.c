#include<stdio.h>
#include<math.h>

main()
{
   long arithmos_autokinhtwn, orio, eth;
   double ruthmos_aukshshs;

   arithmos_autokinhtwn=80000;
   ruthmos_aukshshs=0.07;
   orio=160000;
   eth=0;

   do
   {
       arithmos_autokinhtwn=ceil(arithmos_autokinhtwn*(1+ruthmos_aukshshs));
       eth+=1;
   }while(arithmos_autokinhtwn<=orio);

   printf("O arithmos autokinhtwn , afou kseperasthke to orio , einai :%ld\n",arithmos_autokinhtwn);
   printf("Ta eth pou xreiasthkan gia na kseperastei to orio einai :%ld\n",eth);

    system("pause");
}
