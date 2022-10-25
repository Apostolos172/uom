//Menu:Αυτή η κλάση περιέχει τη στατική μέθοδο printMenu που εμφανίζει το μενού του παιχνιδιού.

public class Menu {
	
	public static void printMenu()
	{
		/*
	  	Η στατική αυτή μέθοδος εκτυπώνει απλά το κεντρικό μενού του παιχνιδιού, προτρέποντας τελικά και το χρήστη 
	  	να εισάγει την επιλογή του  
	*/
		
		System.out.println("-----------------------------");
		System.out.println("MAIN MENU");
		System.out.println(" - Start a new Game (N)");
		System.out.println(" - Statistics (S)");
		System.out.println(" - Exit (E)");
		System.out.println("------------------------------");
		System.out.println("Please enter your choice:");
	}
	
}
