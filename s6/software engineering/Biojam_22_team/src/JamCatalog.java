import java.util.ArrayList;

public class JamCatalog {
	private ArrayList<Jam> jams = new ArrayList<Jam>();
	
	
	public JamCatalog() {
		// ������������� ��� ������� ��� ����������
		// ����������� � ������������� ��� ��� ���������� ����������� ������������
		
	}

	public void addJam(Jam jam1) {
		// ������������� ��� ������� ��� ����������
		// ���������� ���������� ��� ��� �������� ����������� ������������ ���� �����
		
		this.jams.add(jam1);
	}
	
	public void updateJam(Jam jam1) {
		// ������������� ��� ������� ��� ����������
		// ���������� ���������� ��� ��� ��������� ������ ���������� �� �������� ��������� ���������� 
		
		for(Jam jam : this.jams ) {
			if(jam.getName().equals(jam1.getName())) {
				int quantity = jam.getQuantity() - jam1.getQuantity();
				jam.setQuantity(quantity);
			}
		}
	}
	
	public void printData()
	{
		// �� ���� ����� 
		// ��������� ��� ����� ��� ��������� ���� ������������.
		System.out.println("-----------------------------------");
		System.out.println("*  ���������:     |    ��������:  *");
		System.out.println("*  -  -  -  -  -  -   -  -  -  -  *");
		for(Jam jam : this.jams ) {
			jam.printData();
		}
		System.out.println("*---------------------------------*");
	}
	
}