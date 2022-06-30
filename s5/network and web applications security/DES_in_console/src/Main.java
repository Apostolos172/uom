
public class Main {

	public static void main(String args[]) 
	{ 
		
		String text = "VADRAHAN"; // original plain text 
		text = (DES.toHex(text)).toUpperCase(); // convert plain text to hexadecimal
		
		String key = "133457799BBCDFF1"; // key hexadecimal
		
		System.out.println("Encryption of text:" + text + 
				" with the key:" + key); 
		
		DES cipher = new DES(); 
		System.out.println("\nEncryption:\n"); 
		text = cipher.encrypt(text, key); 
		System.out.println( 
			"\nCipher Text: " + text.toUpperCase() + "\n"); 
		
	} 

}
