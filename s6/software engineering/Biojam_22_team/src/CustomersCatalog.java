import java.util.ArrayList;

public class CustomersCatalog {
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	
    public CustomersCatalog() {
        // δημιουργήθηκε στα πλαίσια της υλοποίησης
        // απαραίτητος ο κατασκευαστής για την δημιουργία αντίστοιχου αντικειμένου
        
	}


	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	

	public void addCustomer(Customer aC1) {
		
		customers.add(aC1);
		
	}

	public boolean searchAndCheckCustomer(Customer selectedCustomer) {
        // για τις περιπτώσεις που θέλει ο λογιστής να δει απλά την φερεγγυότητα ενός πελάτη 
        // χωρίς να βρίσκεται στην διαδικασία καταχώρησης παραγγελίας
        
		if(this.customers.contains(selectedCustomer)) {
			if(selectedCustomer.checkReliability()) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public void printData()
	{
        // σε κάθε κλάση 
        // εμφανίζει τις τιμές των ιδιοτήτων κάθε αντικειμένου.
        
		System.out.println("*------------------------------------------------------------------*");
		
		System.out.println("*              Λίστα με τα στοιχεία των Πελατών:                   *");
		
		System.out.println("--------------------------------------------------------------------");
        System.out.println("*     Επωνυμία Πελάτη:       |     ΑΦΜ:      |      Διεύθυνση:     *");
		System.out.println("*  -  -  -  -  -  -  -  -  -  -  -   -  -  -  -  -  -  -  -  -  -  *");
		
		for(Customer customer : this.customers ) {
			customer.printData();
		}
		System.out.println("*------------------------------------------------------------------*");
		System.out.println("\n");
		
	}
}
