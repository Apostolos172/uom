#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int wres;
    long code;
    double ethsios_misthos,ebdomadiaia_amoibh,amoibh_ana_wra,help;

    printf("Dwse ton kwdiko:\n");
    code=GetLong();
    if(code>=1000)
    {
       printf("Dwse ton ethsio mistho: \n");
       ethsios_misthos=GetReal();
       ebdomadiaia_amoibh=ethsios_misthos/52;
    }
    else
    {
        printf("Dwse tis wres ebdomadiais ergasias:\n");
        wres=GetReal();
        printf("Dwse thn amoibh ana wra:\n");
        amoibh_ana_wra=GetReal();
        if(wres<=40)
        {
            ebdomadiaia_amoibh=wres*amoibh_ana_wra;
        }
        else
        {
            help=(wres-40)*amoibh_ana_wra;
            ebdomadiaia_amoibh=40*amoibh_ana_wra+help+help*50/100;
        }
    }
        printf("H ebdomadiaia amoibh einai %g\n",ebdomadiaia_amoibh);
        system("pause");
}
