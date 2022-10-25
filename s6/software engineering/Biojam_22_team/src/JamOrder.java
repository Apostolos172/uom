
public class JamOrder {
	
	private Customer customer;
	private JamCatalog jamCatalogForOrder;

	
	public JamOrder(Customer customer, JamCatalog jamCatalogForOrder) {
		this.customer = customer;
		this.jamCatalogForOrder = jamCatalogForOrder;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public JamCatalog getJamCatalogForOrder() {
		return this.jamCatalogForOrder;
	}
	
	public void printData()
	{
        // σε κάθε κλάση 
        // εμφανίζει τις τιμές των ιδιοτήτων κάθε αντικειμένου.
        System.out.println("\n* * * * Έναρξη  Παραγγελίας * * * *\n");
        System.out.println("      Πελάτης: " + this.customer.getName());
        jamCatalogForOrder.printData();
        
        System.out.println("\n* * * *  Τέλος Παραγγελίας  * * * *");
		
	}
}