#include"genlib.h"

#define participants 7
#define skills 9

void fill_the_table(int fill,int size, int table[]);

int main(void)
{
    /*int participants_skills[participants][skills]={ {1,1,1,1,2,2},
                                                    {1,2,2,1,1,1},
                                                    {2,1,2,1,1,1},
                                                    {2,2,1,1,1,1},
                                                    {1,2,1,2,1,2},
                                                    {1,1,1,2,1,2}};*/
    int participants_skills[participants][skills]={ {1,1,1,2,2,1,2,1,1},
                                                    {2,2,1,1,1,1,1,2,1},
                                                    {1,2,1,2,1,2,1,1,2},
                                                    {1,1,2,1,1,2,1,1,2},
                                                    {1,1,2,1,1,2,1,1,2},
                                                    {1,1,1,1,1,1,2,2,2},
                                                    {2,1,2,1,1,1,2,1,1}};
    int t,hire,i,j,max,k,flag,thesh,n;
    int number_of_skills[participants];
    int thesh_max[participants];
    int skills_taktopoihthkan[skills];

    fill_the_table(1,skills,skills_taktopoihthkan);
    fill_the_table(0,participants,number_of_skills);
    fill_the_table(0,participants,thesh_max);

    for(i=0;i<participants;i++)
    {
        for(j=0;j<skills;j++)
        {
            if(participants_skills[i][j]==2)
            {
                number_of_skills[i]++;
            }
        }
    }

    k=-1;
    while(flag!=1)
    {
        flag=1;
        max=-1;
        for(i=0;i<participants;i++)
        {
            if(number_of_skills[i]>max)
            {
                max=number_of_skills[i];
                thesh=i;
            }
        }
        k++;
        thesh_max[k]=thesh;

        n=0;
        for(j=0;j<skills;j++)
        {
            if(participants_skills[thesh_max[k]][j]==2&&skills_taktopoihthkan[j]==1)
            {
                n++;
                skills_taktopoihthkan[j]=2;
                for(t=0;t<participants;t++)
                {
                    if(participants_skills[t][j]==2)
                            number_of_skills[t]--;
                }
            }
        }
        if(n==0)
        {
            k--;
            number_of_skills[thesh_max[k+1]]=0;
        }

        number_of_skills[thesh_max[k]]=0;

        for(i=0;i<participants;i++)
        {
            if(number_of_skills[i]!=0)
            {
                flag=0;
            }
        }
    }

    printf("\nThe company will hire the participants with the following numbers ID: ");
    for(i=0;i<=k;i++)
    {
        printf("%d, ",thesh_max[i]+1);
    }
    printf("\b\b.\n\n");

    system("pause");
    return(0);
}

void fill_the_table(int fill,int size, int table[])
{
    int i;

    for(i=0;i<size;i++)
    {
        table[i]=fill;
    }
}
