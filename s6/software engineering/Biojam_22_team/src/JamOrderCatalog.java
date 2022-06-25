import java.util.ArrayList;

public class JamOrderCatalog {
	private ArrayList<JamOrder> jamOrders = new ArrayList<JamOrder>();

	
	public JamOrderCatalog() {
		// ������������� ��� ������� ��� ����������
		// ����������� � ������������� ��� ��� ���������� ����������� ������������
		
	}

	public ArrayList<JamOrder> getJamOrders() {
		return jamOrders;
	}
	
	public boolean addJamOrder(JamOrder JO1) {
		boolean reliable = JO1.getCustomer().checkReliability();
		
		if(reliable) {
			jamOrders.add(JO1);
		}
		
		return reliable;
	}
	
	public boolean removeJamOrder(JamOrder JO1) {
		// ������������� ��� ������� ��� ����������
		// ���������� ���������� ��� ��� �������� ����������� ������������ ����������� ��� ��� �����
		
		return jamOrders.remove(JO1);
	}
	
	public void printData()
	{
		int count = 0;
		// �� ���� ����� 
		// ��������� ��� ����� ��� ��������� ���� ������������.
		System.out.println("\n* * * * * * * * * * * * * * * * * *");
		System.out.println("\n    ����� ����������� ����������:   ");
		System.out.println("\n-  -  -  -  -  -   -  -  -  -  -  -");
		for(JamOrder JO1 : this.jamOrders ) {
			count ++;
			
			System.out.println("      ������������ ���������� " + count);
			System.out.println("          --------------");
			JO1.printData();
			
			System.out.println("\n-  -  -  -  -  -   -  -  -  -  -  -");
		}
		System.out.println("\n* * * * * * * * * * * * * * * * * *\n");
		
	}
}