import java.util.ArrayList;

public class JamOrderCatalog {
	private ArrayList<JamOrder> jamOrders = new ArrayList<JamOrder>();

	
	public JamOrderCatalog() {
        // δημιουργήθηκε στα πλαίσια της υλοποίησης
        // απαραίτητος ο κατασκευαστής για την δημιουργία αντίστοιχου αντικειμένου
        
	}

	public ArrayList<JamOrder> getJamOrders() {
		return jamOrders;
	}
	
	public boolean addJamOrder(JamOrder JO1) {
		boolean reliable = JO1.getCustomer().checkReliability();
		
		if(reliable) {
			jamOrders.add(JO1);
		}
		
		return reliable;
	}
	
	public boolean removeJamOrder(JamOrder JO1) {
        // δημιουργήθηκε στα πλαίσια της υλοποίησης
        // απαραίτητη λειτουργία για την αφαίρεση αντίστοιχου αντικειμένου παραγγελίας από την λίστα
        
		return jamOrders.remove(JO1);
	}
	
	public void printData()
	{
		int count = 0;
        // σε κάθε κλάση 
        // εμφανίζει τις τιμές των ιδιοτήτων κάθε αντικειμένου.
        System.out.println("\n* * * * * * * * * * * * * * * * * *");
        System.out.println("\n    Λίστα Παραγγελιών Μαρμελάδας:   ");
		System.out.println("\n-  -  -  -  -  -   -  -  -  -  -  -");
		for(JamOrder JO1 : this.jamOrders ) {
			count ++;
			
            System.out.println("      Καταχωρημένη Παραγγελία " + count);
			System.out.println("          --------------");
			JO1.printData();
			
			System.out.println("\n-  -  -  -  -  -   -  -  -  -  -  -");
		}
		System.out.println("\n* * * * * * * * * * * * * * * * * *\n");
		
	}
}