/*�� �������� ���������, ����������� �� �������� ���� �����������,
  ���������� �� ���� ��� ����������� �� ��� ����� � ���������� ��� ����� ��� �����.*/

#include<stdio.h>
#include"genlib.h"
#include"simpio.h"

main()
{
    int hmeres_ergasias;
    long hmerhsia_amoibh;
    double rate, dwro;

    printf("Dwse tis hmeres ergasias tou etous:\n");
    hmeres_ergasias=GetInteger();

    printf("Dwse thn hmerisia amoibh:\n");
    hmerhsia_amoibh=GetLong();

    printf("Dwse to pososto dwroy:\n");
    rate=GetReal();

    dwro=hmeres_ergasias*hmerhsia_amoibh*rate;
    printf("To dwro einai%g\n",dwro);
}
