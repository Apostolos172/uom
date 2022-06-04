#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include"string.h"
#include"strlib.h"

#define size 50

void shuffle_word(char string[]);

int main(void)
{
    char string[size];

    printf("Word to shuffle:\n");
    gets(string);
    printf("Initial word: %s, ",string);
    shuffle_word(string);
    printf("New word: %s\n",string);

    system("pause");
    return(0);
}

void shuffle_word(char string[])
{
    int i,i1,i2,len;
    char temp;

    len=strlen(string);
    for(i=0;i<len/2;i++)
    {
        while(TRUE)
        {
            i1=rand()%10;
            if(i1<len) break;
        }
        while(TRUE)
        {
            i2=rand()%10;
            if(i2<len) break;
        }
        temp=string[i1];
        string[i1]=string[i2];
        string[i2]=temp;
    }
}
