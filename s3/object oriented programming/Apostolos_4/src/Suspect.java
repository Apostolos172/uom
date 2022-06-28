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
		 * ������� addNumber(String telephone_number) � ����� ��������� ���� ������ 
		 * ��� ����� ����������� ������� ��� �������.
		 */
		this.TelephoneNumbers.add(telephone_number);
	}
	
	public void addPartner(Suspect apartner)
	{
		/*
		 * ������� addPartner(Suspect apartner) � ����� ��������� ���� ������ ��� ����� ������� ���������� 
		 * ���� �������. ���� ������� ���� ��������� ������� ��� �� �� ��������� ��� ������ ��� 
		 * ����� ��� ��� ����� ������� ����������.
		 */
		if(!(this.partners.contains(apartner)))
		{
			this.partners.add(apartner);
		}
	}
	
	public boolean isConnectedTo(Suspect aSuspect)
	{
		/*
		 * ������� isConnectedTo(Suspect aSuspect) � ����� ������� �� ��������� ���� ���� ������ 
		 * ��� ���������� true � false ������� �� �� �� ����� ������������.
		 */
		if(this.partners.contains(aSuspect))
			return true;
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		/*
		 * ������� getCommonPartners(Suspect aSuspect) � ����� ������� �� ��������� ���� ���� 
		 * ������ ��� ���������� ��� ����� �� ���� ������� �������� ���������� ��� ��� �������.
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
		 * ������� � ����� ������� ���� �������� ���������� (������� ��� �������-�������) ��� �������, �� 
		 * ���� ��������� (*) ���� �� ������ ����� ���� ��������� ��� ���������� ��� ��� ���� ����.
		 */
		for(int i=0; i<(this.partners).size(); i++)
		{		
			if(this.partners.get(i).OriginCountry.equals(this.OriginCountry))
				System.out.println("Partner: " + this.partners.get(i).Name + "(" + this.partners.get(i).CodeName + ") " + " *");
			else
				System.out.println("Partner: " + partners.get(i).Name + "(" + partners.get(i).CodeName + ") ");
		}
	}
	
	public ArrayList<String> getCompatriotsPartners()
	{
		/*
		 * ������� � ����� ������� ���� �������� ���������� (�������) ��� �������,
		 * ���� ��������� ��� ���������� ��� ��� ���� ����.
		 */
		ArrayList<String> compatriotsPartners = new ArrayList<>();
		
		for(int i=0; i<(this.partners).size(); i++)
		{		
			if(this.partners.get(i).OriginCountry.equals(this.OriginCountry))
				compatriotsPartners.add(this.partners.get(i).getName());
		}
		return compatriotsPartners;
	}
	
	public ArrayList<Suspect> getSuggestedPartners()
	{
		/*  ��� ����� ���������� ���������� ����������� ��� ���������� ���� ������ �� �������������� ��������
			��������-���������� (Suggested Partners). ������� �� ���� ������� ��� SurveillanceNet, �� ����
			������� � ���� �������� ���������� ���� � ��� �, ��� � � ���� �������� ���������� ���� �, � ��� �,
			���� �� ������� ��� ��� ������ � �� ������ �� ���������� �� ������������ ������ ��������� ��� �.
			(� ������� ����� ������������� �� ��� ���� ��� ����������� ������������ ������� �� ��� �����
			��� ��������� ������ �� ������� ����� ��� ���� �� ����������� ������� ������ �� ������ ���������
			�������, �� ���� ����� ���� ������� ������ �� ���������� ������ �� ���� ������ ��� ����� ���, �
			���� ��������� ��� �� ���������� ����������� �� ���� ���������� ��� ���������� ���). � ����
			������� �� ������ ���� ������ � �� ���������� �� ������������ ������ ��������� ��� �.
		 */
		
		ArrayList<Suspect> suggestedSuspects = new ArrayList<>();
		ArrayList<Suspect> partnerspartners = new ArrayList<>();
		
		for(Suspect s : this.partners) {
			partnerspartners = s.partners;
			for(Suspect p : partnerspartners) {
				if((!(this.partners.contains(p)))&&(p!=this)) {
					suggestedSuspects.add(p);
				}
			}
		}
			
		return suggestedSuspects;
	}
}
