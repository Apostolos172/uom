/*
 	Game:�� ���� ��� ����� ���������� �� �������� �� ����� ��� ������ � ������� �� ��������-�� �������� ��� ��� ���������-�����
		 �� �����, �� ����� ��� � ������� ��� ����� ��� ������, �� ����� ������������� ��� ���������� ���������� ��� �������� ���
  		 ���������� ���� ��� setters(��� ���� �������� ��� ������ ��� ������ ���� 1 ������) ��� getters ���� ����� ����������.
*/

public class Game 
{
	private int times;
	private int wins;
	private int losses;
	
	public Game()
	{
		times=0;
		wins=0;
		losses=0;
	}
	
	public int getTimes()
	{
		return times;
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public int getLosses()
	{
		return losses;
	}
	
	public void setTimes()
	{
		times+=1;
	}
	
	public void setWins()
	{
		wins+=1;
	}
	
	public void setLosses()
	{
		losses+=1;
	}
	
}
