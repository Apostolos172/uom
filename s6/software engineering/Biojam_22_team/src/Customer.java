import java.util.Random;

public class Customer {
	private String afm;
	private String name;
	private String address;
	private String tel;
	private String email;
	private String tk;
	
	
	public Customer(String afm, String name, String address, String tel, String email, String tk) {
		
		this.afm = afm;
		this.name = name;
		this.address = address;
		this.tel = tel;
		this.email = email;
		this.tk = tk;
	}


	public Customer(String afm, String name) {
	
		this.afm = afm;
		this.name = name;
	}


	public Customer(String name, String afm, String address) {
		// ������������� ��� ������� ��� ����������
		// ������������� ��� ��� ���������� ���� ��� ��������� ��� �������� ���� ��������
		this.afm = afm;
		this.name = name;
		this.address = address;
	}


	public String getAfm() {
		return this.afm;
	}

	public String getName() {
		return this.name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getTel() {
		return this.tel;
	}

	public String getEmail() {
		return this.email;
	}

	public String getTk() {
		return this.tk;
	}
	
	public boolean checkReliability() {
		// ������� ������� �������������
		
		Random rand = new Random(); //instance of random class
	    int upperbound = 2;
	    //generate random values from 0-1
	    int int_random = rand.nextInt(upperbound); 
	    if(int_random==1)
	    {
	    	return true;
	    }
	    return false;
	}
	
	public void printData()
	{
		// �� ���� ����� 
		// ��������� ��� ����� ��� ��������� ���� ������������.
		
		System.out.format("*     %-23s|   %s   |   %15s %3s\n", this.name, this.afm, this.address, "*");
		
	}
}
