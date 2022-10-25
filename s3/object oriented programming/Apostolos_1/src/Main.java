import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
import java.lang.StringBuilder;

public class Main 
{
	public static void main(String[] args) 
	{
		
		/*
		 Έχουν υλοποιηθεί πέντε κλάσεις για τις ανάγκες του προγράμματος:
		 	Prediction:Σε αυτή την κλάση θεωρήθηκαν ως οντότητα οι προβλέψεις που κάνει ο παίκτης 
		 		και σαν ιδιότητες-πεδία οι σωστές προβλέψεις, οι λανθασμένες, οι προβλέψεις που ο παίκτης κάνει κάθε φορά 
		 		και ο συνολικός αριθμός των προβλέψεων, τα οποία μεταβάλλονται και ανακτώνται αντίστοιχα στη διάρκεια του παιχνιδιού 
		 		μέσα από setters και gettters όπου είναι απαραίτητο. Επίσης για τις δυνατότητες διαχείρισης των προβλέψεων της τρέχουσας
		 		παρτίδας δημιουργήθηκαν οι μέθοδοι searchAString, printPredictions, restartPredictions.
		 	Game:Σε αυτή την κλάση θεωρήθηκαν ως οντότητα οι φορές που παίζει ο χρήστης το παιχνίδι-οι παρτίδες και σαν ιδιότητες-πεδία
		 		οι νίκες, οι ήττες και ο αριθμός των φορών που παίζει, τα οποία μεταβάλλονται και ανακτώνται αντίστοιχα στη διάρκεια του
		 		παιχνιδιού μέσα από setters(που απλά αυξάνουν τον αριθμό των πεδίων κατά 1 άμμεσα) και getters όπου είναι απαραίτητο.
		 	Dictionary:Σε αυτή την κλάση περιέχονται οι λέξεις οι οποίες χρησιμοποιούνται ως λέξεις για την κρεμάλα και αντλούνται 
		 		μέσα από τη μοναδική της μέθοδο getWord(int index).
		 	Menu:Αυτή η κλάση περιέχει τη στατική μέθοδο printMenu που εμφανίζει το μενού του παιχνιδιού.
		 	Checkers:Αυτή η κλάση περιέχει δύο στατικές μεθόδους για την εγκυρότητα τόσο της επιλογής στο μενού, όσο και για την 
		 		εγκυρότητα της πρόβλεψης, τις checkTheValidChoice και checkTheValidPrediction αντίστοιχα.
		*/
				
		Scanner input = new Scanner(System.in);
		String choice,buffer;
		Game aPlayer = new Game();
		Dictionary aWord = new Dictionary();
		Prediction aPrediction = new Prediction();
		StringBuilder helpfulString = new StringBuilder();
		int word,i;
		Random numberOfWord = new Random();
		
		//Δεν θέτω κάποιον συγκεκριμένο σπόρο γιατί σε διαφορετική περίπτωση σε κάθε επανεκκίνηση του παιχνιδιού θα εμφανίζονταν οι λέξεις με την ίδια σειρά.
		//numberOfWord.setSeed(0);
		
		//Καλωσόρισμα στο παιχνίδι
		System.out.println("The game is to predict the hidden word, having in your choice 10 times to predict than the letters of the word are. ");
		System.out.println("The popular hangman!!!  ;)");
		System.out.println("Have fun!!!  :)");
		
		//Εμφάνιση του κεντρικού μενού του παιχνιδιού και έλεγχος για το εάν η επιλογή του παίκτη είναι αποδεκτή ειδάλως εισάγει εκ νέου επιλογή
		Menu.printMenu();
		choice=Checkers.checkTheValidChoice();
		
		//Αν ο παίκτης επιλέξει να φύγει από το παιχνίδι πληκτρολογώντας E απλά κλείνει το πρόγραμμα αποχαιρετώντας τον
		while(choice.compareTo("E")!=0)
		{
			//Αν ο παίκτης επιλέξει να δει τα στατιστικά σε οποιαδήποτε φάση, θα δει πόσες φορές έχει παίξει μέχρι τώρα καθώς και τις νίκες-ήττες του 
			if(choice.compareTo("S")==0)
			{
				System.out.println("You have played so far " + aPlayer.getTimes() + " games. You won " + aPlayer.getWins() + " times and lost " + aPlayer.getLosses() + " times. \n");
			}
			else
			{
				//Ενημέρωση αριθμού παρτίδων
				aPlayer.setTimes();
				//Προετοιμασία παρτίδας
				aPrediction.setCorrect(0);
				aPrediction.setWrong(0);
				aPrediction.setTimes(10);
				aPrediction.restartPredictions();
				
				//Επιλογή ψευδοτυχαίας λέξης από την κλάση Dictionary
				word=numberOfWord.nextInt(109);	
				aWord.getWord(word);
				
				/*  
				 	Δημιουργία του βοηθητικού αλφαριθμητικού που θα κρατά την πορεία της κρυμμένης λέξης που σχηματίζεται μέσα από τις 
					προβλέψεις του παίκτη.
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
					//Ελέγχεται αν η πρόβλεψη του παίκτη είναι έγκυρη σαν εισαγόμενος χαρακτήρας
					buffer=Checkers.checkTheValidPrediction(aPrediction);
					aPrediction.setPredict(buffer);
									
					//Ελέγχεται αν το γράμμα που εισήγαγε ο χρήστης περιέχεται στην κρυμμένη λέξη 
					//Αν το γράμμα που εισήγαγε ο χρήστης περιέχεται στην κρυμμένη λέξη:
					if(aWord.getWord(word).contains(aPrediction.getPredict().toUpperCase()))
					{
						/*
					 	Το γράμμα που εισήγαγε ο χρήστης και περιέχεται στην κρυμμένη λέξη αντικαθίσταται στο βοηθητικό αλφαριθμητικό
					 	που προβάλλεται μετά από κάθε πρόβλεψη, σε όλες τις θέσεις που τυχόν βρίσκεται.
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
					//Αν το γράμμα που εισήγαγε ο χρήστης δεν περιέχεται στην κρυμμένη λέξη: 
					else
					{
						System.out.println("There are no " + aPrediction.getPredict() + " 's in the word.");
						aPrediction.setWrong(aPrediction.getWrong()+1);
						aPrediction.setTimes(aPrediction.getTimes()-1);
					}
					
					//Αν ο χρήστης κατάφερε να βρει τη λέξη, μαντεύοντας και τον τελευταίο χαρακτήρα
					if(aWord.getWord(word).equals(helpfulString.toString()))
					{
						System.out.println("Congratulations! You guessed the word: " + helpfulString.toString());
						System.out.println("You made " + aPrediction.getCorrect() + " correct guesses and " + aPrediction.getWrong() + " wrong guesses.");
						aPlayer.setWins();
						break;
					}
					
					//Αν οι δυνατές φορές για πρόβλεψη γραμμάτων τελείωσαν, χωρίς να έχει βρει ο παίκτης τη λέξη
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
			//Εμφάνιση του κεντρικού μενού του παιχνιδιού και δυνατότητα επιλογής, έπειτα από την λήξη της πρώτης παρτίδας
			Menu.printMenu();
			choice=Checkers.checkTheValidChoice();
		}	
		input.close();
		System.out.println("Goodbye!   :(");
	}
}

