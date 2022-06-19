public class Vigenere {
	
	// This function generates the key in 
	// a cyclic manner until it's length isi'nt 
	// equal to the length of original text 
	public static String generateKey(String str, String key) 
	{ 
	    int x = str.length(); 
	  
	    for (int i = 0; ; i++) 
	    { 
	        if (x == i) 
	            i = 0; 
	        if (key.length() == str.length()) 
	            break; 
	        key+=(key.charAt(i)); 
	    } 
	    return key; 
	} 
	 
	// This function returns the encrypted text 
	// generated with the help of the key 
	public static String cipherText(String str, String key) 
	{ 
	    String cipher_text=""; 
	  
	    for (int i = 0; i < str.length(); i++) 
	    { 
	        // converting in range 0-25 
	        int x = (str.charAt(i) + key.charAt(i)) %26; 
	  
	        // convert into alphabets(ASCII) 
	        x += 'A'; 
	  
	        cipher_text+=(char)(x); 
	    } 
	    return cipher_text; 
	} 
	
	// This function decrypts the encrypted text 
	// and returns the original text 
	public static String originalText(String cipher_text, String key) 
	{ 
	    String orig_text=""; 
	  
	    for (int i = 0 ; i < cipher_text.length() &&  
	                            i < key.length(); i++) 
	    { 
	        // converting in range 0-25 
	        int x = (cipher_text.charAt(i) -  
	                    key.charAt(i) + 26) %26; 
	  
	        // convert into alphabets(ASCII) 
	        x += 'A'; 
	        orig_text+=(char)(x); 
	    } 
	    return orig_text; 
	}  
	
	// Αυτή η συνάρτηση δοκιμάζει αν πέτυχε το κλειδί, κρυπτανάλυση
	// και επιστρέφει αν ήταν πετυχημένη η κρυπτανάλυση
	public static boolean cryptanalysis(String keyword, String original_text, String cipher_text)
    {
    	// Εύρεση πλήρους κλειδιού, με το ίδιο μήκος του αρχικού κειμένου
		String key = Vigenere.generateKey(original_text, keyword); 
        //System.out.println(" "+key);
	  
        // Αποκρυπτογράφηση
        String orig = Vigenere.originalText(cipher_text, key);
	    //System.out.println("Original/Decrypted Text : " + orig);
	    
	    // Έλεγχος αν είναι το κείμενο που προέκυψε με το δεδομένο κλειδί ίδιο με το αρχικό κείμενο
	    boolean successful_cryptanalysis = orig.equals(original_text); 
	    //equals return true if the two strings are the same
	    return successful_cryptanalysis;
	    
    }
	
	 public static int printTheNextPossibleCombinationAndDoCryptanalysis(char[] values, int r, int[] output, int count, String str, String cipher_text)
     {
		 
		 //System.out.print(String.format("\n%2d", ++count) + ") ");
		 System.out.print(String.format("\n%2d", ++count));
         String temp = "";
         //System.out.print("keyword: ");
         while(r-- > 0)
         {
             //System.out.print(values[output[r]]);
             temp=temp+values[output[r]];
         }
         //System.out.print(",");
         
         String keyword = temp;
         boolean successful = Vigenere.cryptanalysis(temp, str, cipher_text);
         if(successful)
         {
 	    	// Terminate Programm
 	    	System.out.println("\n\n The cryptanalysis was " +
 	    			 "successful. \n The keyword is " +keyword+
 	    			 ". \n And there were necessary "+ count +" attempts."); 
            return -1; 
         }
 	    return count;
     }
	
}
