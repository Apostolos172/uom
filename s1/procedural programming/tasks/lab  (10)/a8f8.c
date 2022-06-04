#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

typedef struct
{
    int width;
    int height;
    int depth;
    int area;
    int volume;
}box;

void diastaseis(box *pblock);
void upologismos_embadou(box *pblock);
void upologismos_ogkou(box *pblock);

int main(void)
{
    box block;

    diastaseis(&block);
    upologismos_embadou(&block);
    upologismos_ogkou(&block);
    printf("To emvadon tou koutiou einai %d cm2.\n",block.area);
    printf("O ogos tou koutiou einai %d cm3.\n",block.volume);

    system("pause");
    return(0);
}

void diastaseis(box *pblock)
{
    printf("Dwse to mhkos tou koutiou se cm: ");
    (*pblock).width=GetInteger();
    printf("Dwse to ypsos tou koutiou se cm: ");
    (*pblock).height=GetInteger();
    printf("Dwse to vathos tou koutiou se cm: ");
    (*pblock).depth=GetInteger();
}

void upologismos_embadou(box *pblock)
{
    (*pblock).area=2*(*pblock).width*(*pblock).height+2*(*pblock).width*(*pblock).depth+2*(*pblock).height*(*pblock).depth;
}

void upologismos_ogkou(box *pblock)
{
    (*pblock).volume=(*pblock).width*(*pblock).height*(*pblock).depth;
}
