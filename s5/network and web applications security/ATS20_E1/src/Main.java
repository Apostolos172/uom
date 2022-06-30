
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//https://www.geeksforgeeks.org/vigenere-cipher/
		
		String str = "VADRAHAN"; 
	    String keyword = "SOLO"; 
	    
	    //str = "GEEKSFORGEEKS"; 
	    //keyword = "AYUSH"; 
	  
	    String key = Vigenere.generateKey(str, keyword); 
	    System.out.println("key=" + key);
	    String cipher_text = Vigenere.cipherText(str, key); 
	  
	    System.out.println("Ciphertext : " + cipher_text + "\n"); 
	  
	    System.out.println("Original/Decrypted Text : " + Vigenere.originalText(cipher_text, key));

	}

}
