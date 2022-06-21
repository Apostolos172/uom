import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.StringBuilder;

public class Main 
{
	public static void main(String[] args) 
	{
		
		/*
		 ����� ���������� ����� ������� ��� ��� ������� ��� ������������:
		 	Prediction:�� ���� ��� ����� ���������� �� �������� �� ���������� ��� ����� � ������� 
		 		��� ��� ���������-����� �� ������ ����������, �� �����������, �� ���������� ��� � ������� ����� ���� ���� 
		 		��� � ��������� ������� ��� ����������, �� ����� ������������� ��� ���������� ���������� ��� �������� ��� ���������� 
		 		���� ��� setters ��� gettters ���� ����� ����������. ������ ��� ��� ����������� ����������� ��� ���������� ��� ���������
		 		�������� �������������� �� ������� searchAString, printPredictions, restartPredictions.
		 	Game:�� ���� ��� ����� ���������� �� �������� �� ����� ��� ������ � ������� �� ��������-�� �������� ��� ��� ���������-�����
		 		�� �����, �� ����� ��� � ������� ��� ����� ��� ������, �� ����� ������������� ��� ���������� ���������� ��� �������� ���
		 		���������� ���� ��� setters(��� ���� �������� ��� ������ ��� ������ ���� 1 ������) ��� getters ���� ����� ����������.
		 	Dictionary:�� ���� ��� ����� ����������� �� ������ �� ������ ���������������� �� ������ ��� ��� ������� ��� ���������� 
		 		���� ��� �� �������� ��� ������ getWord(int index).
		 	Menu:���� � ����� �������� �� ������� ������ printMenu ��� ��������� �� ����� ��� ����������.
		 	Checkers:���� � ����� �������� ��� �������� �������� ��� ��� ���������� ���� ��� �������� ��� �����, ��� ��� ��� ��� 
		 		���������� ��� ���������, ��� checkTheValidChoice ��� checkTheValidPrediction ����������.
		*/
				
		Scanner input = new Scanner(System.in);
		String choice,buffer;
		Game aPlayer = new Game();
		Dictionary aWord = new Dictionary();
		Prediction aPrediction = new Prediction();
		StringBuilder helpfulString = new StringBuilder();
		int word,i;
		Random numberOfWord = new Random();
		
		//��� ���� ������� ������������ ����� ����� �� ����������� ��������� �� ���� ������������ ��� ���������� �� ������������ �� ������ �� ��� ���� �����.
		//numberOfWord.setSeed(0);
		
		//����������� ��� ��������
		System.out.println("The game is to predict the hidden word, having in your choice 10 times to predict than the letters of the word are. ");
		System.out.println("The popular hangman!!!  ;)");
		System.out.println("Have fun!!!  :)");
		
		//�������� ��� ��������� ����� ��� ���������� ��� ������� ��� �� ��� � ������� ��� ������ ����� �������� ������� ������� �� ���� �������
		Menu.printMenu();
		choice=Checkers.checkTheValidChoice();
		
		//�� � ������� �������� �� ����� ��� �� �������� ��������������� E ���� ������� �� ��������� �������������� ���
		while(choice.compareTo("E")!=0)
		{
			//�� � ������� �������� �� ��� �� ���������� �� ����������� ����, �� ��� ����� ����� ���� ������ ����� ���� ����� ��� ��� �����-����� ��� 
			if(choice.compareTo("S")==0)
			{
				System.out.println("You have played so far " + aPlayer.getTimes() + " games. You won " + aPlayer.getWins() + " times and lost " + aPlayer.getLosses() + " times. \n");
			}
			else
			{
				//��������� ������� ��������
				aPlayer.setTimes();
				//������������ ��������
				aPrediction.setCorrect(0);
				aPrediction.setWrong(0);
				aPrediction.setTimes(10);
				aPrediction.restartPredictions();
				
				//������� ������������ ����� ��� ��� ����� Dictionary
				word=numberOfWord.nextInt(109);	
				aWord.getWord(word);
				
				/*  
				 	���������� ��� ���������� �������������� ��� �� ����� ��� ������ ��� ��������� ����� ��� ������������ ���� ��� ��� 
					���������� ��� ������.
				*/
				helpfulString.setLength(aWord.getWord(word).length());
				System.out.println("The random word is now: ");
				for(i=0; i<helpfulString.toString().length(); i++)
				{
					helpfulString.setCharAt(i, '-');
				}
				System.out.println(helpfulString.toString());
				System.out.println("You have " + aPrediction.getTimes() + " guesses left.");
				
				while(true)
				{	
					System.out.println("Your guess: ");
					//��������� �� � �������� ��� ������ ����� ������ ��� ����������� ����������
					buffer=Checkers.checkTheValidPrediction(aPrediction);
					aPrediction.setPredict(buffer);
									
					//��������� �� �� ������ ��� �������� � ������� ���������� ���� �������� ���� 
					//�� �� ������ ��� �������� � ������� ���������� ���� �������� ����:
					if(aWord.getWord(word).contains(aPrediction.getPredict().toUpperCase()))
					{
						/*
						 	�� ������ ��� �������� � ������� ��� ���������� ���� �������� ���� �������������� ��� ��������� �������������
						 	��� ����������� ���� ��� ���� ��������, �� ���� ��� ������ ��� ����� ���������.
						*/
						System.out.println("The guess is CORRECT!");
						aPrediction.setCorrect(aPrediction.getCorrect()+1);
						helpfulString.setCharAt(aWord.getWord(word).indexOf(aPrediction.getPredict().toUpperCase()),aWord.getWord(word).charAt(aWord.getWord(word).indexOf(aPrediction.getPredict().toUpperCase())));
						if(aWord.getWord(word).compareTo("HIPPOPOTAMUS")==0&&aPrediction.getPredict().toUpperCase().compareTo("P")==0
								||aWord.getWord(word).compareTo("TELEPHONE")==0&&aPrediction.getPredict().toUpperCase().compareTo("E")==0)
						{
							helpfulString.setCharAt(aWord.getWord(word).indexOf(aPrediction.getPredict().toUpperCase(),aWord.getWord(word).indexOf(aPrediction.getPredict().toUpperCase())+1),aWord.getWord(word).charAt(aWord.getWord(word).indexOf(aPrediction.getPredict().toUpperCase())));
						}
						helpfulString.setCharAt(aWord.getWord(word).lastIndexOf(aPrediction.getPredict().toUpperCase()),aWord.getWord(word).charAt(aWord.getWord(word).indexOf(aPrediction.getPredict().toUpperCase())));
					}
					//�� �� ������ ��� �������� � ������� ��� ���������� ���� �������� ����: 
					else
					{
						System.out.println("There are no " + aPrediction.getPredict() + " 's in the word.");
						aPrediction.setWrong(aPrediction.getWrong()+1);
						aPrediction.setTimes(aPrediction.getTimes()-1);
					}
					
					//�� � ������� �������� �� ���� �� ����, ����������� ��� ��� ��������� ���������
					if(aWord.getWord(word).equals(helpfulString.toString()))
					{
						System.out.println("Congratulations! You guessed the word: " + helpfulString.toString());
						System.out.println("You made " + aPrediction.getCorrect() + " correct guesses and " + aPrediction.getWrong() + " wrong guesses.");
						aPlayer.setWins();
						break;
					}
					
					//�� �� ������� ����� ��� �������� ��������� ���������, ����� �� ���� ���� � ������� �� ����
					if(aPrediction.getTimes()==0)
					{
						System.out.println("The random word is now: ");
						System.out.println(helpfulString);
						System.out.println("You haven' t any other times. Better luck next time.");
						System.out.println("You made " + aPrediction.getCorrect() + " correct guesses and " + aPrediction.getWrong() + " wrong guesses.");
						aPlayer.setLosses();
						break;
					}	
					
					System.out.println("\nThe random word is now: ");
					System.out.println(helpfulString);
					System.out.println("You have " + aPrediction.getTimes() + " guesses left.");
					aPrediction.printPredictions();
				}
			}
			//�������� ��� ��������� ����� ��� ���������� ��� ���������� ��������, ������ ��� ��� ���� ��� ������ ��������
			Menu.printMenu();
			choice=Checkers.checkTheValidChoice();
		}	
		input.close();
		System.out.println("Goodbye!   :(");
	}
}

