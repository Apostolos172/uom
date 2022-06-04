#include<stdio.h>
#include<string.h>
#include"genlib.h"
#include"simpio.h"

#define M 100

typedef struct
{
    char name[30];
    int apousies;
} studentT;

void readinput(FILE *infile,studentT students[],int *pApousies,int *pstudents);
void writeoutput(FILE *outfile, int size, studentT students[],int total);

int main(void)
{
    char inputfilename[30];
    char outputfilename[30];
    FILE *infile;
    FILE *outfile;
    studentT students[M];
    int number_of_students,number_of_apousies;

    while(TRUE)
    {
        printf("Dwse to onoma tou arxeiou eisodou: ");
        gets(inputfilename);
        infile=fopen(inputfilename,"r");
        if (infile != NULL) break;
        printf("%s does not exist.\n",inputfilename);
    }

    printf("Dwse to onoma tou arxeiou eksodou: ");
    gets(outputfilename);
    outfile=fopen(outputfilename,"w");

    readinput(infile,students,&number_of_apousies,&number_of_students);
    writeoutput(outfile,number_of_apousies,students,number_of_students);

    fclose(infile);
    fclose(outfile);

    system("pause");
    return(0);
}

void readinput(FILE *infile,studentT students[],int *pApousies,int *pstudents)
{
    char name[30],comments[68],terma;
    int apousies,nscan,line;

    line=0;
    *pApousies=0;
    *pstudents=0;
    while(TRUE)
    {
        //πόσες τιμές κατάφερε να διαβάσει επιστρέφει η fscanf
        nscan=fscanf(infile,"%30[^,], %d, %68[^\n]%c",name,&apousies,comments,&terma);
        if(nscan==EOF) break;
        line++;
        if(nscan!=4||terma!='\n')
        {
            printf("Error in line %d. Program termination\n", line);
            exit(1);
        }
        if(apousies>100)
        {
            strcpy(students[*pApousies].name,name);
            students[*pApousies].apousies=apousies;
            (*pApousies)++;
        }
        (*pstudents)++;
    }
}

void writeoutput(FILE *outfile, int size, studentT students[],int total)
{
    int i;

    fprintf(outfile, "%-30s %-9s\n","ONOMATEPWNYMO","APOYSIES");

    for(i=1;i<=39;i++)
         fputc('-',outfile);
    fputc('\n',outfile);

    for(i=0;i<size; i++)
        fprintf(outfile,"%-30s%9d\n",students[i].name,students[i].apousies);

    for(i=1;i<=39;i++)
        fputc('-',outfile);
    fputc('\n',outfile);
    fprintf(outfile,"%-30s%9d\n","SYNOLO MATHHTWN",total);
    fprintf(outfile,"%-30s%9d\n","SYNOLO APONTWN",size);
}

