
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
		// �� ���� ����� 
		// ��������� ��� ����� ��� ��������� ���� ������������.
		System.out.println("\n* * * * ������  ����������� * * * *\n");
		System.out.println("      �������: " + this.customer.getName());
		jamCatalogForOrder.printData();
		
		System.out.println("\n* * * *  ����� �����������  * * * *");
		
	}
}