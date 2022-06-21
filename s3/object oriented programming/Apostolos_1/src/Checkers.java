/*
	Checkers:���� � ����� �������� ��� �������� �������� ��� ��� ���������� ���� ��� �������� ��� �����, ��� ��� ��� ��� 
		 ���������� ��� ���������, ��� checkTheValidChoice ��� checkTheValidPrediction ����������.
*/

import java.util.Scanner;

public class Checkers {
	
	public static String checkTheValidChoice()
	{	
		/*
	  		� ������� ���� ������� ������� �� � ������� ���� ����� ������ ������� ��� �� �������� ����� ������������� 
	  		�� ����� ��� ��������� ���� ��� ����, �������� ���������� ���� ������ �� ����� �� ���� ���� ������� ����� 
	  		�� ����� ������  
		*/
		
		int flag;
		String choice;
		Scanner input = new Scanner(System.in);
		
		choice=input.nextLine();
		flag= 1;
		while(flag==1)
		{
			choice = choice.toUpperCase();
			if(choice.compareTo("E")==0||choice.compareTo("N")==0||choice.compareTo("S")==0)
			{
				flag=0;
			}
			else
			{
				System.out.println("Enter again:");
				choice=input.nextLine();
			}		
		}
		return choice;
	}
		
	public static String checkTheValidPrediction(Prediction Prediction)
	{		
	 
		//	� ������� ���� ������� ������� �� � ������� ���� ����� ������ �������� ��� ������ ������������� 
	  	//	�� ����� ��� ��������� ���� �� �������������, �������� ���������� ���� ������ �� ����� �� ���� ���� �������� ����� 
	  	//	�� ����� ������  
			
		int flag;
		String buffer;
		Scanner input = new Scanner(System.in);
			
		while(true)
		{
			buffer=input.nextLine().toUpperCase();
			
			if(Prediction.searchAString(buffer))
				System.out.println("You have already chosen this letter. Predict another one: ");
			else
			{
				flag=0;
				if(buffer.compareTo("A")==0
				||buffer.compareTo("B")==0
				||buffer.compareTo("C")==0
				||buffer.compareTo("D")==0
				||buffer.compareTo("E")==0
				||buffer.compareTo("F")==0
				||buffer.compareTo("G")==0
				||buffer.compareTo("H")==0
				||buffer.compareTo("I")==0
				||buffer.compareTo("J")==0
				||buffer.compareTo("K")==0
				||buffer.compareTo("L")==0
				||buffer.compareTo("M")==0
				||buffer.compareTo("N")==0
				||buffer.compareTo("O")==0
				||buffer.compareTo("P")==0
				||buffer.compareTo("Q")==0
				||buffer.compareTo("R")==0
				||buffer.compareTo("S")==0
				||buffer.compareTo("T")==0
				||buffer.compareTo("U")==0
				||buffer.compareTo("V")==0
				||buffer.compareTo("W")==0
				||buffer.compareTo("X")==0
				||buffer.compareTo("Y")==0
				||buffer.compareTo("Z")==0)
				{
					flag=1;
				}
				if(flag==0)
				{
					System.out.println("Please give a letter: ");
				}
				else
				{
					break;
				}
			}
		}
		return buffer;
	}
	
	/*
	
	// � �������� ������� �������� ���� ��� �������� ���� ��� � ������� ����� ������ ���� ���������
	
	public static String checkTheValidPrediction(Prediction Prediction)
	{
		
		//	� ������� ���� ������� ������� �� � ������� ���� ����� ������ �������� ��� ������ ������������� 
		//	�� ����� ��� ��������� ���� �� �������������, �������� ���������� ���� ������ �� ����� �� ���� ���� �������� ����� 
		//	�� ����� ������  
		
		
		int flag,i;
		String buffer;
		Scanner input = new Scanner(System.in);
		
		while(true)
		{
			buffer=input.nextLine().toUpperCase();
			
			if(Prediction.searchAString(buffer))
				System.out.println("You have already chosen this letter. Predict another one: ");
			else
			{
				flag=0;
				for(i=10; i<=35; i++)
				{
					if(Integer.parseInt(buffer,36)==i)
					{
						flag=1;
						break;
					}
				}
				if(flag==0)
				{
					System.out.println("Please give a letter: ");
				}
				else
				{
					break;
				}
			}
		}
		return buffer;
	}
	
	*/
}
