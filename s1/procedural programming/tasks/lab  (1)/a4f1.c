/*�� ��������� ���������� �� ������ ��� �� ���������� ���� ��� ��� ������ ������� ������������ �� ���� �� �������
  ������� ��� ������� � ������� ���� �� ��� ������ ���� ��� ������������*/

#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    double profit,saleAmount;
    int rate;
    long purchaseAmount;

    printf("Dwse thn katharh axia:\n");
    purchaseAmount=GetLong();

    printf("dwse to pososto kerdous:\n");
    rate=GetInteger();

    profit=purchaseAmount*rate/100.0;
    saleAmount=profit+purchaseAmount;

    printf("To kerdos einai %g.\n",profit);
    printf("To synoliko poso einai %g.\n",saleAmount);
}
