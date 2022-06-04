#include<stdio.h>
#include<string.h>
#include"genlib.h"

#define M 100

typedef struct
{
    char firstname[15];
    char lastname[25];
    float grades[6];
    char sex;
    float average;
}studentT;

void readinput(FILE *infile, studentT students[], int *successmale, int *successfemale,float *posostomale, float *posostofemale);
void writeoutput(FILE *outfile, studentT students[], int *successmale, int *successfemale,float *posostomale, float *posostofemale);

int main(void)
{
    FILE *infile,*outfile;
    studentT students[M];
    int successmale,successfemale;
    float posostomale,posostofemale;

    infile=fopen("lyceum_1.dat","r");
    if(infile==NULL) exit(1);

    outfile=fopen("results_1.dat","w");

    readinput(infile,students,&successmale,&successfemale,&posostomale,&posostofemale);
    writeoutput(outfile,students,&successmale,&successfemale,&posostomale,&posostofemale);

    fclose(infile);
    fclose(outfile);

    system("pause");
    return(0);
}

void readinput(FILE *infile, studentT students[], int *successmale, int *successfemale,float *posostomale, float *posostofemale)
{
    int index,j,i,nscan,line,males,females;
    char firstname[15],lastname[25],sex,termch;
    float grades[6], average;

    males=females=0;
    *successmale=0;
    *successfemale=0;
    index=0;
    line=0;
    while(TRUE)
    {
        nscan=fscanf(infile,"%15[^,], %25[^,], %f, %f, %f, %f, %f, %f, %c%c",firstname,lastname,&grades[0],&grades[1],&grades[2],&grades[3],&grades[4],&grades[5],&sex,&termch);
        if(nscan==EOF) break;
        line++;
        if(nscan!=10||termch!='\n')
        {
            printf("Error in line %d: ",line);
            exit(1);
        }
        else
        {
            average=0;
            for(i=0;i<6;i++)
            {
                average+=grades[i];
            }
            average/=6;
            if(sex=='A')
                males++;
            else
                females++;
            if(average>=10)
            {
                index=*successmale+*successfemale;
                strcpy(students[index].firstname,firstname);
                strcpy(students[index].lastname,lastname);
                for(j=0;j<6;j++)
                {
                    students[index].grades[j]=grades[j];
                }
                students[index].sex=sex;
                students[index].average=average;
                if(sex=='A')
                    (*successmale)++;
                else
                    (*successfemale)++;
            }
        }
    }
    *posostomale=100.0*(*successmale)/males;
    *posostofemale=100.0*(*successfemale)/females;
}

void writeoutput(FILE *outfile, studentT students[], int *successmale, int *successfemale,float *posostomale, float *posostofemale)
{
    int i;

    fprintf(outfile,"%-12s %-12s %-12s %-12s\n","EPITYXOUSES","POSOSTO","EPITYXONTES","POSOSTO");
    fprintf(outfile,"%-12d %-12.1f %-12d %-12.1f",*successfemale,*posostofemale,*successmale,*posostomale);
    fputc('\n',outfile);
    for(i=0;i<=75;i++)
    {
        //fputc('-',outfile);fputc('\n',outfile);
        fprintf(outfile,"-");
    }
    fputc('\n',outfile);

    for(i=0;i<(*successfemale)+(*successmale);i++)
    {
        fprintf(outfile,"%-15s %-15s %4.1f %4.1f %4.1f %4.1f %4.1f %4.1f %4.1f %c\n",
                students[i].firstname,students[i].lastname,
                students[i].grades[0],students[i].grades[1],students[i].grades[2],
                students[i].grades[3],students[i].grades[4],students[i].grades[5],
                students[i].average,students[i].sex);
    }
}

