#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

int main(void)
{
  int sum,i;
  char string[100];

  printf("Dwse ena alfarithmhtiko: ");
  gets(string);

  sum=0;
  for(i=0;string[i]!='\0';i++)
  {
      //with other way: isdigit()
      if(string[i]>=48&&string[i]<=57)
      {
          printf("%c + ",string[i]);
          switch(string[i])
          {
                case 49:
                    sum+=1;
                    break;
                case 50:
                    sum+=2;
                    break;
                case 51:
                    sum+=3;
                    break;
                case 52:
                    sum+=4;
                    break;
                case 53:
                    sum+=5;
                    break;
                case 54:
                    sum+=6;
                    break;
                case 55:
                    sum+=7;
                    break;
                case 56:
                    sum+=8;
                    break;
                default:
                    sum+=9;
                    break;
          }
      }
  }
  printf("\b\b= %d\n",sum);

  system("pause");
  return(0);
}
