
public class SMS extends Communication{
	private String content_of_sms;
	
	//constructor
	public SMS(String telephone_number_1, String telephone_number_2, 
			int year, int month, int day, String content_of_sms)
	{
		super(telephone_number_1, telephone_number_2, 
				year, month, day);
		this.content_of_sms= content_of_sms;
	}
	
	//getters
	public String getContent_of_sms() {
		return content_of_sms;
	}
	
	//Μέθοδος που επιστρέφει τον τύπο της επικοινωνίας
	public String getType()
	{
		return "SMS";
	}
	
	//Μέθοδος printInfo() εκτύπωσης όλων των ιδιοτήτων των επικοινωνιών
	public void printInfo()
	{
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + content_of_sms);
	}
}
