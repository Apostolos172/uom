import java.util.ArrayList;

public class CustomersCatalog {
	private ArrayList<Customer> customers = new ArrayList<Customer>();

	
	public CustomersCatalog() {
		// ������������� ��� ������� ��� ����������
		// ����������� � ������������� ��� ��� ���������� ����������� ������������
		
	}


	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	

	public void addCustomer(Customer aC1) {
		
		customers.add(aC1);
		
	}

	public boolean searchAndCheckCustomer(Customer selectedCustomer) {
		// ��� ��� ����������� ��� ����� � �������� �� ��� ���� ��� ������������ ���� ������ 
		// ����� �� ��������� ���� ���������� ����������� �����������
		
		if(this.customers.contains(selectedCustomer)) {
			if(selectedCustomer.checkReliability()) {
				return true;
			}
		}
		
		return false;
		
	}
	
	public void printData()
	{
		// �� ���� ����� 
		// ��������� ��� ����� ��� ��������� ���� ������������.
		
		System.out.println("*------------------------------------------------------------------*");
		
		System.out.println("*              ����� �� �� �������� ��� �������:                   *");
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("*     �������� ������:       |     ���:      |      ���������:     *");
		System.out.println("*  -  -  -  -  -  -  -  -  -  -  -   -  -  -  -  -  -  -  -  -  -  *");
		
		for(Customer customer : this.customers ) {
			customer.printData();
		}
		System.out.println("*------------------------------------------------------------------*");
		System.out.println("\n");
		
	}
}
