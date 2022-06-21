/*
 	 Prediction:�� ���� ��� ����� ���������� �� �������� �� ���������� ��� ����� � ������� 
		 		��� ��� ���������-����� �� ������ ����������, �� �����������, �� ���������� ��� � ������� ����� ���� ���� 
		 		��� � ��������� ������� ��� ����������, �� ����� ������������� ��� ���������� ���������� ��� �������� ��� ���������� 
		 		���� ��� setters ��� gettters ���� ����� ����������. ������ ��� ��� ����������� ����������� ��� ���������� ��� ���������
		 		�������� �������������� �� ������� searchAString, printPredictions, restartPredictions.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Prediction 
{
	private ArrayList<String> predicts;
	private int times;
	private int correct;
	private int wrong;
	
	public Prediction()
	{
		predicts= new ArrayList<>();
		times=0;
		correct=0;
		wrong=0;
	}
	
	public String getPredict() 
	{
		return predicts.get(predicts.size()-1);
	}
	
	public int getTimes()
	{
		return times;
	}

	public int getWrong()
	{
		return wrong;
	}
	
	public int getCorrect()
	{
		return correct;
	}
	
	public boolean searchAString(String aPrediction)
	{
		return predicts.contains(aPrediction);
	}
	
	public void printPredictions()
	{
		System.out.println("Your previous predictions are: ");
		
		for(String p: predicts)
		{
			System.out.println(p);
		}
		// �
		/*
		int i;
		for(i=0; i<predicts.size(); i++)
		{
			System.out.println(predicts.get(i));
		}
		*/
	}
	
	public void restartPredictions()
	{
		predicts.clear();
	}
	
	public void setPredict(String predict) 
	{
		predicts.add(predict);
	}
	
	public void setTimes(int times)
	{
		this.times = times;
	}
	
	public void setWrong(int wrong)
	{
		this.wrong = wrong;
	}
	
	public void setCorrect(int correct)
	{
		this.correct = correct;
	}

}
