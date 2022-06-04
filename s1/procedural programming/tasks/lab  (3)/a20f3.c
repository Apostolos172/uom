#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int max, min, hlikia;

    max=-1;
    min=10000;
    while(TRUE)
    {
        printf("Dwse hlikia:");
        hlikia=GetInteger();
        if(hlikia==-1)break;
        if(hlikia<min)
        {
            min=hlikia;
        }
        if(hlikia>max)
        {
            max=hlikia;
        }
    }
    printf("H megaluterh hlikia einai %d\n",max);
    printf("H mikroterh hlikia einai %d\n",min);

    system("pause");
}
