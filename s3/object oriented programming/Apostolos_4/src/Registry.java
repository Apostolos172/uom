import java.util.ArrayList;

public class Registry {
	private Communication[] communications;
	private int counter;
	private ArrayList<Suspect> suspects;
	
	//constructor
	public Registry()
	{
		this.communications= new Communication[100];
		this.counter=0;
		this.suspects = new ArrayList<Suspect>();
	}
	
	//getters
	public Communication[] getCommunications() {
		return communications;
	}
	
	public ArrayList<Suspect> getSuspects() {
		return suspects;
	}

	public int getCounter() {
		return counter;
	}

	//other methods
	public void addSuspect(Suspect aSuspect)
	{
		/*
		 * ������� addSuspect(Suspect aSuspect) ����������� ���� �������.
		 */
		suspects.add(aSuspect);
	}

	public Suspect find_whose_phone(String a_phone_number)
	{
		/*
		 * ������� find_whose_phone(String a_phone_number) ��� ��������� ��� ������, � ������ �������
		 * �� �������� ���������� ������.
		 */
		for(Suspect s: suspects)
		{
			if((s.getTelephoneNumbers()).contains(a_phone_number))
			{
				return s;
			}
		}
		return null;
	}
	
	public void addCommunication(Communication aCommunication)
	{
		/*
		 * ������� addCommunication(Communication aCommunication) ����������� ���� ���� 
		 * ������������. �� � ����������� ����� ���� ������������ �������� Telephone_number_1
		 * ��� Telephone_number_2, ���� ����� �������� ��� ��������� ���� ������������ �������� 
		 * ������������ � ����� ��� ���������� ����.
		 */
		
		this.communications[counter]= aCommunication;
		this.counter++;
		//if(aCommunication.getType().equals("PhoneCall"))
		{
			if(((this.find_whose_phone(aCommunication.getTelephone_number_1())!=null)
					&&(this.find_whose_phone(aCommunication.getTelephone_number_2())!=null)))
			{
				this.find_whose_phone(aCommunication.getTelephone_number_1()).addPartner(this.find_whose_phone(aCommunication.getTelephone_number_2()));
				this.find_whose_phone(aCommunication.getTelephone_number_2()).addPartner(this.find_whose_phone(aCommunication.getTelephone_number_1()));
			}
		}
	}
	
	public Suspect getSuspectWithMostPartners()
	{
		/*
		 * ������� getSuspectWithMostPartners() � ����� ���������� ���� 
		 * ��� ���� �������� �� ���� ������������� �������� ����������.
		 */
		Suspect SuspectWithMostPartners= suspects.get(0);
		for(Suspect s: suspects)
		{
			if(SuspectWithMostPartners.getPartners().size()<=s.getPartners().size())
				SuspectWithMostPartners=s;
		}
		return SuspectWithMostPartners;
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2)
	{
		/*
		 * ������� getLongestPhoneCallBetween(String number1, String number2) � ����� ������� 
		 * �� ��������� ��� �������� ��� ���������� ��� ���������� ����� ������ ���� �� �� 
		 * ���������� ��������.
		 */
		ArrayList<Communication> communicatiosWithTheParticularNumbers = new ArrayList<>();
		
		for(int i=0; i<this.counter; i++)
		{
			if(communications[i].getType().equals("PhoneCall"))
			{
				if((communications[i].telephone_number_1.equals(number1)&&communications[i].telephone_number_2.equals(number2))
						||(communications[i].telephone_number_1.equals(number2)&&communications[i].telephone_number_2.equals(number1)))
				{
					communicatiosWithTheParticularNumbers.add(communications[i]);
				}
			}
		}
		
		int longestDuration= ((PhoneCall)communicatiosWithTheParticularNumbers.get(0)).getDuration();
		Communication longestcall= communicatiosWithTheParticularNumbers.get(0);
		for(Communication c: communicatiosWithTheParticularNumbers)
		{
			if(((PhoneCall)c).getDuration()>longestDuration)
			{
				longestDuration=((PhoneCall)c).getDuration();
				longestcall= c;
			}
		}
		
		return (PhoneCall)longestcall;
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2)
	{
		/*
		 * ������� getMessagesBetween(String number1, String number2) � ����� ������� �� 
		 * ��������� ��� �������� ��� ���������� ��� �� �������� ������ ���� ��� ��������� 
		 * ����������� ��� ��� ������ �Bomb�, �Attack�, �Explosives�, �Gun�.
		 */
		ArrayList<SMS> sms = new ArrayList<>();
		
		for(int i=0; i<this.counter; i++)
		{
			if(communications[i].getType().equals("SMS"))
			{
				if((communications[i].telephone_number_1.equals(number1)&&communications[i].telephone_number_2.equals(number2))
						||(communications[i].telephone_number_1.equals(number2)&&communications[i].telephone_number_2.equals(number1)))
				{
					if((((SMS)communications[i]).getContent_of_sms().contains("Bomb"))||
							(((SMS)communications[i]).getContent_of_sms().contains("Attack"))||
							(((SMS)communications[i]).getContent_of_sms().contains("Explosives"))||
							(((SMS)communications[i]).getContent_of_sms().contains("Gun")))
					{
						sms.add((SMS)communications[i]);
						//((SMS)communications[i]).printInfo();
					}
				}
			}
		}	
		return sms;
	}
	
	public ArrayList<String> getMessagesWith(String number, Suspect aSuspect)
	{
		/*
		 * ������� getMessagesWith(String number, Suspect aSuspect) � ����� ������� �� 
		 * ��������� ���� ���������� ������ ��� ���� ������ ��� ���������� ��� �� ����������� ��� ��������� 
		 * ������ ��� ������� ��� ��� ��������� ��� ������� ��� ��������� 
		 * ����������� ��� ��� ������ �Bomb�, �Attack�, �Explosives�, �Gun�.
		 */
		
		ArrayList<String> content_of_smses = new ArrayList<>();
		ArrayList<SMS> smses = new ArrayList<>();
		
		for(String telephone_number : aSuspect.getTelephoneNumbers())
		{
			smses.addAll(this.getMessagesBetween(telephone_number, number));
		}
		for(SMS s : smses)
		{
			content_of_smses.add(s.getContent_of_sms());
		}
	
		return content_of_smses;
	}
	
	public void printSuspectsFromCountry(String country) 
	{
		/*
		 * ������� getSuspectsFromCountry(String country) � ����� ������� �� ��������� �� ����� ���� 
		 * ����� ��� ��������� ����� ���� �������� ��� ���������� ��� ����
		 */
		for(Suspect s: suspects)
		{
			if(s.getOriginCountry().equalsIgnoreCase(country))
				System.out.println(s.getName() + " (" + s.getCodeName() + ")" );
		}
	}
	
}
