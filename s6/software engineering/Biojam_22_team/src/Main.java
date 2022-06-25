
public class Main {

	public static void main(String[] args) {

		
		System.out.println("- - - - - - - - - - - - - ���������� ������������ - - - - - - - - - - - - - ");
		
		
		/* 
		 * 4 ����������� ��� ������ ������(Jam) 
		 * �� ����� �� ������������ ���� �������� ��������� (���������� ��������� ����������) 
		 * ��� �� �� �������������� �������� ����� ��� attributes ��� ������ eidos ��� posotita
		 */
		
		//���������� ������������ Jam
		Jam jam1 = new Jam("fraoula", 600);
		System.out.println("Object Jam1 has been created.");
		Jam jam2 = new Jam("kerasi", 420);
		System.out.println("Object Jam2 has been created.");
		Jam jam3 = new Jam("portokali", 480);
		System.out.println("Object Jam3 has been created.");
		Jam jam4 = new Jam("mantarini", 360);
		System.out.println("Object Jam4 has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		// ���������� ������������ Jam Catalog
		JamCatalog CatalogOfJamsInBiojam = new JamCatalog();
		System.out.println("Object CatalogOgJamsInBioJam has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		CatalogOfJamsInBiojam.addJam(jam1);
		System.out.println("Object Jam1 has been added to the object CatalogOfJamsInBiojam.");
		
		CatalogOfJamsInBiojam.addJam(jam2);
		System.out.println("Object Jam2 has been added to the object CatalogOfJamsInBiojam.");
		
		CatalogOfJamsInBiojam.addJam(jam3);
		System.out.println("Object Jam3 has been added to the object CatalogOfJamsInBiojam.");
		
		CatalogOfJamsInBiojam.addJam(jam4);
		System.out.println("Object Jam4 has been added to the object CatalogOfJamsInBiojam.");


		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
		
		System.out.println("*---------------------------------*");
		System.out.println("*  ������ ��������� ���������� :  *");
		CatalogOfJamsInBiojam.printData();
		
		
		/*
		 * 2 ����������� ��� ������ �������(Customer) 
		 * �� ����� �� ������������ ���� �������� ������� 
		 * ��� �� �� �������������� �������� ����� ��� attributes ��� ������ eponimo, onoma, afm, doy
		 */
		
		
		System.out.println("\n\n- - - - - - - - - - - - - ���������� ������������ - - - - - - - - - - - - - ");
		
		
		Customer customer1 = new Customer("Patidou Olga","046208830","DOY B Peiraia");
		System.out.println("Object Customer1 has been created.");
		
		Customer customer2 = new Customer("Alexiou Nikolaos","180226310","DOY Ilioupolis");
		System.out.println("Object Customer2 has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		CustomersCatalog CatalogOfCustomersInBiojam = new CustomersCatalog();
		System.out.println("Object CatalogOfCustomersInBiojam has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		CatalogOfCustomersInBiojam.addCustomer(customer1);
		System.out.println("Object Customer1 has been added to the object CatalogOfCustomersInBiojam.");
		
		CatalogOfCustomersInBiojam.addCustomer(customer2);
		System.out.println("Object Customer2 has been added to the object CatalogOfCustomersInBiojam.");


		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		/*
		 * 4 ����������� ��� ������ ���������� 
		 * �� ����� �� ������ �� ����������� �� ���� 2 ������� ��� �� 4 �������� 
		 */
		
		
		JamOrderCatalog jamOrders = new JamOrderCatalog();
		System.out.println("Object JamOrders has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
		
		/* 
		 * ���������� 1
		 * (����������� ��� ��� customer1 
		 * ��� ������������ 50 ������� ��� ��������� ������� 
		 * ��� 14 ������� ��� ��������� ���������)
		 */
		Jam jam1o1 = new Jam("fraoula", 50);
		Jam jam2o1 = new Jam("portokali", 14);
		
		JamCatalog jamCatalogO1 = new JamCatalog();
		jamCatalogO1.addJam(jam1o1);
		jamCatalogO1.addJam(jam2o1);
		
		JamOrder order1 = new JamOrder(customer1, jamCatalogO1);
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		// ������� ������������� ��� ���������� �����������
		boolean reliableC1 = jamOrders.addJamOrder(order1);
		System.out.println("��������� ����������� 1:");
		
		if(reliableC1) {
			
			// ��������� ���������� ���������� ��� ���������� 1
			CatalogOfJamsInBiojam.updateJam(jam1o1);
			CatalogOfJamsInBiojam.updateJam(jam2o1);
			System.out.println("Object JamOrder1 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
			System.out.println("� ���������� ��� ���������� ����� � ������� ���� �� ���������.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		
		/* 
		 * ���������� 2
		 * (����������� ��� ��� customer1
		 * ��� ������������ 120 ������� ��� ��������� ��������� ���
		 * 45 ������� ��� ��������� ���������)
		 */
		Jam jam1o2 = new Jam("mantarini", 120);
		Jam jam2o2 = new Jam("portokali", 45);
		
		JamCatalog jamCatalogO2 = new JamCatalog();
		jamCatalogO2.addJam(jam1o2);
		jamCatalogO2.addJam(jam2o2);
		
		JamOrder order2 = new JamOrder(customer1, jamCatalogO2);
		
		// ������� ������������� ��� ���������� ����������� 
		/*
		 * � ������� ������������� �������� ��� ���� ��� ��� ������� 
		 * ���������� ��� ����� ������ (Order2, Customer1), ����� ��� 
		 * ���������� ��� ���� ��������� � ����������� � �� �������� ����
		 */
		reliableC1 = jamOrders.addJamOrder(order2);
		System.out.println("��������� ����������� 2:");
		
		if(reliableC1) {
			
			// ��������� ���������� ���������� ��� ���������� 2
			CatalogOfJamsInBiojam.updateJam(jam1o2);
			CatalogOfJamsInBiojam.updateJam(jam2o2);
			System.out.println("Object JamOrder2 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
			System.out.println("� ���������� ��� ���������� ����� � ������� ���� �� ���������.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		
	 
		/*
		 * ���������� 3
		 * (����������� ��� ��� customer2
		 * ��� ������������ 80 ������� ��� ��������� ������, 
		 * 35 ������� ��� ��������� ��������� ��� 28 ������� ��� ��������� �������)
		 */
		Jam jam1o3 = new Jam("kerasi", 80);
		Jam jam2o3 = new Jam("portokali", 35);
		Jam jam3o3 = new Jam("fraoula", 28);

		
		JamCatalog jamCatalogO3 = new JamCatalog();
		jamCatalogO3.addJam(jam1o3);
		jamCatalogO3.addJam(jam2o3);
		jamCatalogO3.addJam(jam3o3);
		
		JamOrder order3 = new JamOrder(customer2, jamCatalogO3);
		
		// ������� ������������� ��� ���������� �����������
		boolean reliableC2 = jamOrders.addJamOrder(order3);
		System.out.println("��������� ����������� 3:");
		
		if(reliableC2) {
			
			// ��������� ���������� ���������� ��� ���������� 3
			CatalogOfJamsInBiojam.updateJam(jam1o3);
			CatalogOfJamsInBiojam.updateJam(jam2o3);
			CatalogOfJamsInBiojam.updateJam(jam3o3);
			System.out.println("Object JamOrder3 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
			System.out.println("� ���������� ��� ���������� ����� � ������� ���� �� ���������.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}

		
		 
		/* 
		 * ���������� 4
		 * (����������� ��� ��� customer2 
		 * ��� ������������ 60 ������� ��� ��������� ���������)
		 */
		Jam jam1o4 = new Jam("mantarini", 60);
		
		JamCatalog jamCatalogO4 = new JamCatalog();
		jamCatalogO4.addJam(jam1o4);
		
		JamOrder order4 = new JamOrder(customer2, jamCatalogO4);
		
		// ������� ������������� ��� ���������� �����������
		reliableC2 = jamOrders.addJamOrder(order4);
		System.out.println("��������� ����������� 4:");
		
		if(reliableC2) {
			
			// ��������� ���������� ���������� ��� ���������� 4
			CatalogOfJamsInBiojam.updateJam(jam1o4);
			
			System.out.println("Object JamOrder4 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
			System.out.println("� ���������� ��� ���������� ����� � ������� ���� �� ���������.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		
		System.out.println("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		// �������� ������������ order2
		
		if(jamOrders.removeJamOrder(order2))
			System.out.println("Order2 was removed from the catalog.");
		else
			System.out.println("Order2 didn' t exist in the catalog.");
		
		/*
		 *         - - - �������� ��������� - - -
		 *  
		 * ��� ����� ��� main ������� ���� ���������� for loops 
		 * �� ������ printData() 
		 * ��� ����������� ��������� �������, 
		 * ��������� 
		 * ��� �����������.
		 *         - - - - - - - - - - - - - - - -   
		 * (�� for loops �������� ����� ��� �������� �����������)
		 */	
		
		System.out.println("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
		// �������� ��� ��������� �����������
		jamOrders.printData();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
		// �������� ��� ��������� �������
		CatalogOfCustomersInBiojam.printData();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
		// �������� ��� ���������� ����������
		System.out.println("*---------------------------------*");
		System.out.println("*   ��������� ���������� BioJam:  *");
		CatalogOfJamsInBiojam.printData();
		

	}

}
