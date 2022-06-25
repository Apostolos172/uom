public class Jam {
	
	private int quantity;
	private String name;
	
	
	public Jam(String name, int quantity) {
		// δημιουργήθηκε στα πλαίσια της υλοποίησης
		// απαραίτητος ο κατασκευαστής για την δημιουργία αντίστοιχου αντικειμένου
		
		this.name = name;
		this.quantity = quantity;
		
	}
	

	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getName() {
		return name;
	}


	public void printData()
	{
		// σε κάθε κλάση 
		// εμφανίζει τις τιμές των ιδιοτήτων κάθε αντικειμένου.
		System.out.format("*  Jam %-10s | %9s %5s\n", this.name, this.quantity, "*");
	}
}