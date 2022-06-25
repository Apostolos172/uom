import java.util.ArrayList;

public class JamCatalog {
	private ArrayList<Jam> jams = new ArrayList<Jam>();
	
	
	public JamCatalog() {
		// δημιουργήθηκε στα πλαίσια της υλοποίησης
		// απαραίτητος ο κατασκευαστής για την δημιουργία αντίστοιχου αντικειμένου
		
	}

	public void addJam(Jam jam1) {
		// δημιουργήθηκε στα πλαίσια της υλοποίησης
		// απαραίτητη λειτουργία για την προσθήκη αντίστοιχου αντικειμένου στην λίστα
		
		this.jams.add(jam1);
	}
	
	public void updateJam(Jam jam1) {
		// δημιουργήθηκε στα πλαίσια της υλοποίησης
		// απαραίτητη λειτουργία για την ενημέρωση λίστας μαρμελάδων με αφαίρεση ποσότητας μαρμελάδας 
		
		for(Jam jam : this.jams ) {
			if(jam.getName().equals(jam1.getName())) {
				int quantity = jam.getQuantity() - jam1.getQuantity();
				jam.setQuantity(quantity);
			}
		}
	}
	
	public void printData()
	{
		// σε κάθε κλάση 
		// εμφανίζει τις τιμές των ιδιοτήτων κάθε αντικειμένου.
		System.out.println("-----------------------------------");
		System.out.println("*  Μαρμελάδα:     |    Ποσότητα:  *");
		System.out.println("*  -  -  -  -  -  -   -  -  -  -  *");
		for(Jam jam : this.jams ) {
			jam.printData();
		}
		System.out.println("*---------------------------------*");
	}
	
}