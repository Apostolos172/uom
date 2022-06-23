
public class PhoneCall extends Communication{
	private int duration;
	
	//constructor
	public PhoneCall(String telephone_number_1, String telephone_number_2, 
			int year, int month, int day, int duration)
	{
		super(telephone_number_1, telephone_number_2, 
				year, month, day);
		this.duration= duration;
	}
	
	//getters
	public int getDuration() {
		return duration;
	}
	
	//Μέθοδος που επιστρέφει τον τύπο της επικοινωνίας
	public String getType()
	{
		return("PhoneCall");
	}
	
	//Μέθοδος printInfo() εκτύπωσης όλων των ιδιοτήτων των επικοινωνιών
	public void printInfo()
	{
		System.out.println("This phone call has the following info");
		super.printInfo();
		System.out.println("Duration: " + duration);
	}
}
