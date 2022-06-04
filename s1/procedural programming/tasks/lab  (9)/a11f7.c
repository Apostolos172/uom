#include<stdio.h>
#include"genlib.h"
#include"simpio.h"
#include"string.h"

#define LENGTH 50

void remove_spaces(char temp[],char email[]);

int main(void)
{
    int len,i,index;
    char temp[LENGTH];
    char email[LENGTH];
    char name[LENGTH];
    char server[LENGTH];

    printf("Give an email address: \n");
    gets(temp);

    remove_spaces(temp,email);

    /*for(i=0;email[i]!='@';i++)
    {
        printf("%c",email[i]);
    }
    printf("\n");
    printf("The length of the name is %d\n",i);*/

    index=0;
    while(email[index]!='@')
    {
        index++;
    }
    strncpy(name,email,index);
    name[index]='\0';
    printf("The name of the email address is: %s\n",name);
    printf("The length of the name is: %d.\n",index);

    index++;
    for(i=0;(i+index)<=strlen(email);i++)
    {
        server[i]=email[i+index];
    }
    printf("Server: %s\n",server);

    /*len=strlen(temp);

    printf("The mail server is: ");
    for(i=index+1;i<=len;i++)
    {
        printf("%c",email[i]);
    }
    printf("\n");*/

    system("pause");
    return(0);
}

void remove_spaces(char temp[],char email[])
{
    int i,k=0,len;
    len=strlen(temp);

    for(i=0;i<=len;i++)
    {
        if(temp[i]!=' ')
        {
            email[k]=temp[i];
            k++;
        }
    }
}
