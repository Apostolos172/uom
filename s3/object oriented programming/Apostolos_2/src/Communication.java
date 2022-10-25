
public abstract class Communication {
	protected String telephone_number_1;
	protected String telephone_number_2;
	protected int year;
	protected int month;
	protected int day;
	
	//constructor
	public Communication(String telephone_number_1, String telephone_number_2, 
			int year, int month, int day)
	{
		this.telephone_number_1= telephone_number_1;
		this.telephone_number_2= telephone_number_2;
		this.year= year;
		this.month= month;
		this.day= day;
	}
	
	//getters
	public String getTelephone_number_1() {
		return telephone_number_1;
	}

	public String getTelephone_number_2() {
		return telephone_number_2;
	}
	
	//Μέθοδος που επιστρέφει τον τύπο της επικοινωνίας
	abstract public String getType();

	//Μέθοδος printInfo() εκτύπωσης όλων των ιδιοτήτων των επικοινωνιών
	public void printInfo()
	{
		System.out.println("Between " + telephone_number_1 + "---" + telephone_number_2 );
		System.out.println("on " + year + "/" + month + "/" + day );
	}
}
