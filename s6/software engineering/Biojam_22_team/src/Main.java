
public class Main {

	public static void main(String[] args) {

		
		System.out.println("- - - - - - - - - - - - - Δημιουργία Αντικειμένων - - - - - - - - - - - - - ");
		
		
		/* 
		 * 4 αντικείμενα της κλάσης Προϊόν(Jam) 
		 * τα οποία θα τοποθετήσετε στον Κατάλογο Προϊόντων (διαθέσιμες ποσότητες μαρμελάδων) 
		 * και θα τα αρχικοποιήσετε δίνοντας τιμές στα attributes της κλάσης eidos και posotita
		 */
		
		//Δημιουργία Αντικειμένων Jam
		Jam jam1 = new Jam("fraoula", 600);
		System.out.println("Object Jam1 has been created.");
		Jam jam2 = new Jam("kerasi", 420);
		System.out.println("Object Jam2 has been created.");
		Jam jam3 = new Jam("portokali", 480);
		System.out.println("Object Jam3 has been created.");
		Jam jam4 = new Jam("mantarini", 360);
		System.out.println("Object Jam4 has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
		// Δημιουργία αντικειμένου Jam Catalog
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
		System.out.println("*  Αρχικά αποθέματα Μαρμελάδας :  *");
		CatalogOfJamsInBiojam.printData();
		
		
        /*
         * 2 αντικείμενα της κλάσης Πελάτης(Customer) 
         * τα οποία θα τοποθετήσετε στον Κατάλογο Πελατών 
         * και θα τα αρχικοποιήσετε δίνοντας τιμές στα attributes της κλάσης eponimo, onoma, afm, doy
         */
		
		
        System.out.println("\n\n- - - - - - - - - - - - - Δημιουργία Αντικειμένων - - - - - - - - - - - - - ");
		
		
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
         * 4 αντικείμενα της κλάσης Παραγγελία 
         * τα οποία θα πρέπει να συσχετίσετε με τους 2 Πελάτες και τα 4 Προϊόντα 
         */
		
		
		JamOrderCatalog jamOrders = new JamOrderCatalog();
		System.out.println("Object JamOrders has been created.");
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
		
        /* 
         * Παραγγελία 1
         * (υποβάλλεται από τον customer1 
         * και περιλαμβάνει 50 τεμάχια από μαρμελάδα φράουλα 
         * και 14 τεμάχια από μαρμελάδα πορτοκάλι)
         */
		Jam jam1o1 = new Jam("fraoula", 50);
		Jam jam2o1 = new Jam("portokali", 14);
		
		JamCatalog jamCatalogO1 = new JamCatalog();
		jamCatalogO1.addJam(jam1o1);
		jamCatalogO1.addJam(jam2o1);
		
		JamOrder order1 = new JamOrder(customer1, jamCatalogO1);
		
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		
		
        // Έλεγχος φερεγγυότητας και καταχώρηση παραγγελίας
		boolean reliableC1 = jamOrders.addJamOrder(order1);
        System.out.println("Κατάσταση Παραγγελίας 1:");
		
		if(reliableC1) {
			
            // Ενημέρωση αποθεμάτων μαρμελάδας για Παραγγελία 1
			CatalogOfJamsInBiojam.updateJam(jam1o1);
			CatalogOfJamsInBiojam.updateJam(jam2o1);
			System.out.println("Object JamOrder1 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
            System.out.println("Η παραγγελία δεν προστέθηκε γιατί ο πελάτης ήταν μη φερέγγυος.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		
        /* 
         * Παραγγελία 2
         * (υποβάλλεται από τον customer1
         * και περιλαμβάνει 120 τεμάχια από μαρμελάδα μανταρίνι και
         * 45 τεμάχια από μαρμελάδα πορτοκάλι)
         */
		Jam jam1o2 = new Jam("mantarini", 120);
		Jam jam2o2 = new Jam("portokali", 45);
		
		JamCatalog jamCatalogO2 = new JamCatalog();
		jamCatalogO2.addJam(jam1o2);
		jamCatalogO2.addJam(jam2o2);
		
		JamOrder order2 = new JamOrder(customer1, jamCatalogO2);
		
        // Έλεγχος φερεγγυότητας και καταχώρηση παραγγελίας 
        /*
         * Ο έλεγχος φερεγγυότητας καλείται και πάλι για την επόμενη 
         * παραγγελία του ίδιου πελάτη (Order2, Customer1), γιατί δεν 
         * γνωρίζουμε εάν έχει εξοφληθεί η προηγούμενη ή αν υπάρχουν χρέη
         */
		reliableC1 = jamOrders.addJamOrder(order2);
        System.out.println("Κατάσταση Παραγγελίας 2:");
		
		if(reliableC1) {
			
            // Ενημέρωση αποθεμάτων μαρμελάδας για Παραγγελία 2
			CatalogOfJamsInBiojam.updateJam(jam1o2);
			CatalogOfJamsInBiojam.updateJam(jam2o2);
			System.out.println("Object JamOrder2 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
            System.out.println("Η παραγγελία δεν προστέθηκε γιατί ο πελάτης ήταν μη φερέγγυος.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		
	 
        /*
         * Παραγγελία 3
         * (υποβάλλεται από τον customer2
         * και περιλαμβάνει 80 τεμάχια από μαρμελάδα κεράσι, 
         * 35 τεμάχια από μαρμελάδα πορτοκάλι και 28 τεμάχια από μαρμελάδα φράουλα)
         */
		Jam jam1o3 = new Jam("kerasi", 80);
		Jam jam2o3 = new Jam("portokali", 35);
		Jam jam3o3 = new Jam("fraoula", 28);

		
		JamCatalog jamCatalogO3 = new JamCatalog();
		jamCatalogO3.addJam(jam1o3);
		jamCatalogO3.addJam(jam2o3);
		jamCatalogO3.addJam(jam3o3);
		
		JamOrder order3 = new JamOrder(customer2, jamCatalogO3);
		
        // Έλεγχος φερεγγυότητας και καταχώρηση παραγγελίας
		boolean reliableC2 = jamOrders.addJamOrder(order3);
        System.out.println("Κατάσταση Παραγγελίας 3:");
		
		if(reliableC2) {
			
            // Ενημέρωση αποθεμάτων μαρμελάδας για Παραγγελία 3
			CatalogOfJamsInBiojam.updateJam(jam1o3);
			CatalogOfJamsInBiojam.updateJam(jam2o3);
			CatalogOfJamsInBiojam.updateJam(jam3o3);
			System.out.println("Object JamOrder3 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
            System.out.println("Η παραγγελία δεν προστέθηκε γιατί ο πελάτης ήταν μη φερέγγυος.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}

		
        
       /* 
        * Παραγγελία 4
        * (υποβάλλεται από τον customer2 
        * και περιλαμβάνει 60 τεμάχια από μαρμελάδα μανταρίνι)
        */
		Jam jam1o4 = new Jam("mantarini", 60);
		
		JamCatalog jamCatalogO4 = new JamCatalog();
		jamCatalogO4.addJam(jam1o4);
		
		JamOrder order4 = new JamOrder(customer2, jamCatalogO4);
		
        // Έλεγχος φερεγγυότητας και καταχώρηση παραγγελίας
		reliableC2 = jamOrders.addJamOrder(order4);
        System.out.println("Κατάσταση Παραγγελίας 4:");
		
		if(reliableC2) {
			
            // Ενημέρωση αποθεμάτων μαρμελάδας για Παραγγελία 4
			CatalogOfJamsInBiojam.updateJam(jam1o4);
			
			System.out.println("Object JamOrder4 has been created and added to the object JamOrders.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
			
		}else {
            System.out.println("Η παραγγελία δεν προστέθηκε γιατί ο πελάτης ήταν μη φερέγγυος.");
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		}
		
		System.out.println("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
        // Διαγραφή αντικειμένου order2
		
		if(jamOrders.removeJamOrder(order2))
			System.out.println("Order2 was removed from the catalog.");
		else
			System.out.println("Order2 didn' t exist in the catalog.");
		
        /*
         *         - - - συνέχεια εκφώνησης - - -
         *  
         * Στο τέλος της main καλέστε μέσω κατάλληλων for loops 
         * τη μέθοδο printData() 
         * στα αντικείμενα Κατάλογος Πελατών, 
         * Προϊόντων 
         * και Παραγγελιών.
         *         - - - - - - - - - - - - - - - -   
         * (τα for loops υπάρχουν εντός των παρακάτω συναρτήσεων)
         */ 
		
		System.out.println("\n\n- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
        // Εκτύπωση του Καταλόγου Παραγγελιών
		jamOrders.printData();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
        // Εκτύπωση του Καταλόγου Πελατών
		CatalogOfCustomersInBiojam.printData();
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n\n");
		
        // Εκτύπωση των Αποθεμάτων Μαρμελάδας
		System.out.println("*---------------------------------*");
        System.out.println("*   Αποθέματα Μαρμελάδας BioJam:  *");
		CatalogOfJamsInBiojam.printData();
		

	}

}
