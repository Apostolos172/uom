/*Ο Στάθης κέρδισε σε έναν διαδικτυακό διαγωνισμό ένα εισιτήριο για ένα φιλανθρωπικό
heavy metal xmas bazaar όπου θα παρευρίσκονται πολλοί διάσημοι. Λόγω της μεγάλης
ζήτησης εισιτηρίων για τη συγκεκριμένη φιλανθρωπική εκδήλωση, ο Στάθης μπορεί να
παραμείνει μόνο για μια ώρα. Μπορεί όμως να επιλέξει ποια ώρα θα πάει στην εκδήλωση.
Κύριος στόχος του είναι να επιλέξει εκείνη την ώρα όπου θα μπορέσει να φωτογραφηθεί
(selfies) με όσο γίνεται περισσότερες διασημότητες (celebrities), και στη συνέχεια να
ανεβάσει τις φωτογραφίες στους λογαριασμούς του κοινωνικής δικτύωσης (Instagram και
Facebook). Με αυτόν τον τρόπο ευελπιστεί να αποκτήσει περισσότερους ακολούθους
(Followers).
Για τα παρακάνω χρονικά διαστήματα ισχύει[’φιξη, Αναχώρηση)
Π.χ. για το χρονικό διάστημα των Slayer [18.00, 19.00), σημαίνει ότι θα προσέρθουν
ακριβώς στις 18.00 στο xmas bazaar και θα αναχωρήσουν μέχρι τις 18.59. Δηλαδή, στις
19.00 δεν θα είναι στην εκδήλωση.*/

#include<stdio.h>
#include<stdlib.h>

typedef struct
{
    char name[30];
    int wra_afikshs;
    int wra_anaxwrhshs;
}celebrity;

void data(int size, celebrity table[]);

int main(void)
{
    int k,celebrities,i,thesh[24],max,pinakas_syxnothtwn[24],j,wra;
    celebrity *diashmothtes;

    printf("Give the number of the celebrities: ");
    scanf("%d%*c",&celebrities);

    diashmothtes=(celebrity *)malloc(celebrities*sizeof(celebrity));


    /*dedomena
    celebrity diashmothtes[0]={"Slayer",18, 19};
    celebrity diashmothtes[1]={"Metallica",19, 21};
    celebrity diashmothtes[2]={"Scorpions",22, 24};
    celebrity diashmothtes[3]={"Motley Crue",20, 22};
    celebrity diashmothtes[4]={"Nazareth",22, 23};
    celebrity diashmothtes[5]={"Queensryche",23, 24};
    celebrity diashmothtes[6]={"Accept",20, 22};
    celebrity diashmothtes[7]={"Judas Priest",21, 23};
    celebrity diashmothtes[8]={"Black Sabbath",19, 22};
    celebrity diashmothtes[9]={"Manowar",20, 23};
    celebrity diashmothtes[10]={"Ozzy",18, 21};
    celebrity diashmothtes[11]={"Iron Maiden",19, 20};
    celebrity diashmothtes[12]={"Megadeth",20,21};
    celebrity diashmothtes[13]={"Anthrax",22, 24};
    celebrity diashmothtes[14]={"Sepultura",19, 23};*/

    data(celebrities,diashmothtes);

    for(i=0;i<24;i++)
    {
        pinakas_syxnothtwn[i]=0;
    }

    for(i=0;i<celebrities;i++)
    {
        for(j=diashmothtes[i].wra_afikshs;j<diashmothtes[i].wra_anaxwrhshs;j++)
        {
            pinakas_syxnothtwn[j-1]+=1;
        }
    }

    max=pinakas_syxnothtwn[0];
    k=0;
    thesh[k]=0;
    for(i=1;i<24;i++)
    {
        if(pinakas_syxnothtwn[i]>max)
        {
            max=pinakas_syxnothtwn[i];
            k=0;
            thesh[k]=i;
        }
        else if(pinakas_syxnothtwn[i]==max)
        {
            k++;
            thesh[k]=i;
        }
    }

    printf("\nHere are the alternatives hours which you can choose to go to the party, in which you will see %d celebrities.\n\n",max);
    for(i=0;i<=k;i++)
    {
        printf("You can go at %d.\n",thesh[i]+1);
        printf("You will see at this time the following celebrities: \n");
        for(j=0;j<celebrities;j++)
        {
            for(wra=diashmothtes[j].wra_afikshs;wra<diashmothtes[j].wra_anaxwrhshs;wra++)
            {
                if(wra==thesh[i]+1)
                {
                    printf("%s  \n",diashmothtes[j].name);
                }
            }
        }
        printf("\n");
    }

    system("pause");
    return(0);
}

void data(int size, celebrity table[])
{
    int i;

    printf("\nGive the following times as the example: for 8:00 a.m. give 8 and for 8:00 p.m., which means 20:00 give 20.\n");
    for(i=0;i<size;i++)
    {
        printf("\nGive the name of the celebrity number %d: ",i+1);
        scanf("%29[^\n]%*c",table[i].name);
        printf("Give the time in which the celebrity number %d will arrive at the party: ",i+1);
        scanf("%d%*c",&(table[i]).wra_afikshs);
        printf("Give the time in which the celebrity number %d will leave the party: ",i+1);
        scanf("%d%*c",&(table[i]).wra_anaxwrhshs);
    }
}



