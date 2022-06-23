import java.util.ArrayList;

public class Suspect {
	private String Name;
	private String CodeName;
	private String OriginCountry;
	private String Town;
	private ArrayList<String> TelephoneNumbers;
	private ArrayList<Suspect> partners;

	//constructor
	public Suspect(String Name, String CodeName, String OriginCountry, String Town)
	{
		this.Name= Name;
		this.CodeName= CodeName;
		this.OriginCountry= OriginCountry;
		this.Town= Town;
		
		this.TelephoneNumbers= new ArrayList<String>();
		this.partners= new ArrayList<Suspect>();
	}
	
	//getters
	public String getName() {
		return Name;
	}

	public String getCodeName() {
		return CodeName;
	}

	public String getOriginCountry() {
		return OriginCountry;
	}

	public ArrayList<String> getTelephoneNumbers() {
		return TelephoneNumbers;
	}
	
	public ArrayList<Suspect> getPartners() {
		return partners;
	}
	
	//other methods
	
	public void addNumber(String telephone_number)
	{
		/*
		 * Μέθοδος addNumber(String telephone_number) η οποία προσθέτει έναν αριθμό 
		 * στη λίστα τηλεφωνικών αριθμών του υπόπτου.
		 */
		this.TelephoneNumbers.add(telephone_number);
	}
	
	public void addPartner(Suspect apartner)
	{
		/*
		 * Μέθοδος addPartner(Suspect apartner) η οποία προσθέτει έναν ύποπτο στη λίστα πιθανών συνεργατών 
		 * ενός υπόπτου. Αυτό γίνεται αφού προηγηθεί έλεγχος για το αν πρόκειται για ύποπτο που 
		 * είναι ήδη στη λίστα πιθανών συνεργατών.
		 */
		if(!(this.partners.contains(apartner)))
		{
			this.partners.add(apartner);
		}
	}
	
	public boolean isConnectedTo(Suspect aSuspect)
	{
		/*
		 * Μέθοδος isConnectedTo(Suspect aSuspect) η οποία δέχεται ως παράμετρο έναν άλλο ύποπτο 
		 * και επιστρέφει true ή false ανάλογα με το αν είναι συνδεδεμένοι.
		 */
		if(this.partners.contains(aSuspect))
			return true;
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		/*
		 * Μέθοδος getCommonPartners(Suspect aSuspect) η οποία δέχεται ως παράμετρο έναν άλλο 
		 * ύποπτο και επιστρέφει μια λίστα με τους κοινούς πιθανούς συνεργάτες των δύο υπόπτων.
		 */
		ArrayList<Suspect> commonPartners = new ArrayList<Suspect>();
		
		for(int i=0; i<this.partners.size(); i++)
		{
			if((aSuspect.getPartners()).contains(this.partners.get(i)))
				commonPartners.add(partners.get(i));
		}
		
		return commonPartners;
	}
	
	public void printCompatriotsPartners()
	{
		/*
		 * Μέθοδος η οποία τυπώνει τους πιθανούς συνεργάτες (ονόματα και κωδικοί-ονόματα) του υπόπτου, με 
		 * έναν αστερίσκο (*) μετά το κωδικό όνομα στην περίπτωση που κατάγονται από την ίδια χώρα.
		 */
		for(int i=0; i<(this.partners).size(); i++)
		{		
			if(this.partners.get(i).OriginCountry.equals(this.OriginCountry))
				System.out.println("Partner: " + this.partners.get(i).Name + "(" + this.partners.get(i).CodeName + ") " + " *");
			else
				System.out.println("Partner: " + partners.get(i).Name + "(" + partners.get(i).CodeName + ") ");
		}
	}
	

}
