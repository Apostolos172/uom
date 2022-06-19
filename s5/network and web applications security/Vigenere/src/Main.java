import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
    	int count=0;
    	   
        int length_of_keyword = 6;
    	
        char[] values = new char[26];
        
        for(int letter=65; letter<=90; letter++)
        {
        	int index;
        	index = letter-65;
        	char c = (char)(letter);
        	values[index] = c;
        }
    	
    	String original_text = "CONGRATULATIONSYOUSUCEEDINDECRYPTINGTHISMESSAGEITWASNOTTOOHARDAFTERA" + 
    			"LLKEEPUPTHEGOODWORKANDSPENDMORETIMEWITHCRYPTOOLANDSTUDYCAREFULLYTHEA" + 
    			"VAILABLEBOOKSANDDONOTFORGETTHATHEBIGGESTBOOKISINTHEINTERNET";
    	String cipher_text = "VIEOEGMOCIGOHHJGBALOTMRJBHUMPXRJKQAMMBZAZKLMROROMQRAAUMNFWUGKXRNG" + 
    			"KKUCTXKXJLXGNXAFWQCHLBIAJLJVVQSHLVBVSXQZBUIKSGBBUEUELFZNXPKNXXZLT" + 
    			"YEMBVIIGBFRJYKUIFSFGGXUWAUMZFZTKMNYIGNXVZOTKLNSWBQBMZVGNXCEBRXGYK";
		
    	long startTime = System.currentTimeMillis();
        dothejob(values,length_of_keyword,count,original_text,cipher_text);
    	long stopTime = System.currentTimeMillis();
    	long requiredTime = stopTime - startTime;
    	System.out.println("\n Time required in milliseconds: " + requiredTime + " milliseconds");
    	long minutes = TimeUnit.MILLISECONDS.toMinutes(requiredTime);
    	System.out.println(" Time required in minutes: " + minutes + " minutes");
	}
	
	private static void dothejob(char[] values, int r, int count, String original_text, String cipher_text)
	{

        int output[] = new int[r];
        int n = values.length;
 
        for(int numIterations=0; numIterations<Math.pow(n,r); numIterations++)
        {
            count = Vigenere.printTheNextPossibleCombinationAndDoCryptanalysis(values, r, output, count, original_text, cipher_text);
            if(count==-1)
            {
            	return;
            }
            int index = 0;
            while(index < r)
            {
                if(output[index] < n-1)
                {
                    output[index]++;
                    break;
                }
                else
                {
                    output[index]=0;
                }
                index++;
            }
        }
	}

}
