/*�� �������� ��������� ������� ���� ������ ������ ��� �� 1 ��� �� 7, ��� �� ������
  ��� ������� ��� ���������� ����� ��� ���������.*/

#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int arithmos;

    printf("Dwse enan arithmo apo to 1 eos to 7:\n");
    arithmos=GetInteger();
    printf("The day is ");
    switch(arithmos)
    {
    case 1:
        printf("Monday.\n");
        break;
    case 2:
        printf("Tuesday.\n");
        break;
    case 3:
        printf("Wednesday.\n");
        break;
    case 4:
        printf("Thursday.\n");
        break;
    case 5:
        printf("Friday.\n");
        break;
    case 6:
        printf("Saturday.\n");
        break;
    default:
        printf("Sunday.\n");
        break;
    }
    system("pause");
}
