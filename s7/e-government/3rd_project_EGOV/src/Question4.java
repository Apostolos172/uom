
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

/*
 * Χρήση της βιβλιοθήκης JSON.simple που επιτρέπει parse, generate, transform, and query JSON
 * Download json-simple-1.1 jar from http://www.java2s.com/Code/Jar/j/Downloadjsonsimple11jar.htm 
 * and insert the library to the project before compiling and running the below example codes.
 */
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Question4 {

	static int decisionsWithPrivateData = 0;
	static int n1, n2, n3, n4;
	static String customizedUrl = "org=";
	static String org = "99206919";
	static String middleUrl = "&from_issue_date=";
	static String issueDate = "2019-01-01";
	static String tailUrl = "&size=500&page=";
	
	public static void main(String args[]) throws InterruptedException {  
			
		/*
		 * 9920691:uid 
		 * https://diavgeia.gov.gr/opendata/search.json?org=99206919&from_issue_date=2019-01-01&size=500&page=...
		 * 6753 σύνολο -> 14 pages -> αποτέλεσμα: 2502
		 */
		
		String base = "https://diavgeia.gov.gr/opendata/search.json?";
		customizedUrl = customizedUrl + org + middleUrl + issueDate + tailUrl;
		
		//Χρήση 4 νημάτων για ταχύτερη επεξεργασία των δεδομένων
		
		Thread t1=new Thread(){  
           public void run(){  
             System.out.println("task one");  
             
             int pageMin = 0;
             int pageMax = 3;
             n1=(job(base, customizedUrl, pageMin,pageMax));
           }
         };  
         Thread t2=new Thread(){  
           public void run(){  
             System.out.println("task two");  
             
             int pageMin = 4;
             int pageMax = 7;
             n2=(job(base, customizedUrl, pageMin,pageMax));  
           }  
         };  
         
         Thread t3=new Thread(){  
             public void run(){  
               System.out.println("task third");  
               
               int pageMin = 8;
               int pageMax = 11;
               n3=(job(base, customizedUrl, pageMin,pageMax));
             }  
           };
     
           Thread t4=new Thread(){  
               public void run(){  
                 System.out.println("task fourth");  

                 int pageMin = 12;
                 int pageMax = 13;
                 n4=(job(base, customizedUrl, pageMin,pageMax));
               }  
             };
           
         t1.start();  
         t2.start();  
         t3.start();  
         t4.start();  
         
         t1.join();
         t2.join();
         t3.join();
         t4.join();
         
         decisionsWithPrivateData=n1+n2+n3+n4;
         System.out.println("\nζητούμενο πλήθος "+decisionsWithPrivateData);
    }  
	
       
	public static int job(String base, String customizedUrl, int pageMin, int pageMax) {
		/* 
	   	 * Η συνάρτηση αυτή δέχεται ως παράμετρο το βασικό και ένα προσαρμοσμένο url, καθώς και 
	   	 * το διάστημα σελίδων αποτελεσμάτων και με βάση αυτά κάνει κλήση στο api της διαύγειας για 
	   	 * να καταμετρήσει στο σύνολο αυτό των δεδομένων, για ένα συγκεκριμένο χρονικό διάστημα, 
	   	 * πόσες πράξεις με προσωπικά δεδομένα υπάρχουν επιστρέφοντας το πλήθος αυτό
	   	 */
		
		try {
           	int count = 0;
           	System.out.println("...connecting, wait..");
           	for(int pages=pageMin; pages<=pageMax; pages++)
           	{
           		
           		URL url = new URL(base+customizedUrl+pages);

           		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           		conn.setRequestMethod("GET");
           		conn.connect();
           		
           		//	Check if connect is made
           		int responseCode = conn.getResponseCode();
           		
           		System.out.println("...αρχή ανάγνωσης.."+pages);
           		// 200 OK
          		if (responseCode != 200) {
           			throw new RuntimeException("HttpResponseCode: " + responseCode);
           		} else {
           			
           			Scanner scanner = new Scanner(url.openStream());
          			String inline = "";
          			while (scanner.hasNext()) {
          				inline+=scanner.nextLine();
           			}
           			//	Close the scanner
           			scanner.close();
           			
           			JSONParser parse = new JSONParser(); 
           			JSONObject jobj = (JSONObject)parse.parse(inline); 
           			count+=(readDecisions(jobj));
           			System.out.println("...τέλος.."+pages);
           		}
          		
            }
            return count;
        } catch (Exception e) {
        	e.printStackTrace();
            return 0;
        }  
            
	}
		
	public static int readDecisions(JSONObject jobj)
	{
	 	/* 
	  	 * Η συνάρτηση αυτή δέχεται ως παράμετρο ένα αντικείμενο json με δομή συγκεκριμένη 
	  	 * που είναι ένα array από json objects, που αντιστοιχούν σε πράξεις και επιστρέφει 
	  	 * τον αριθμό των πράξεων του array που περιείχαν προσωπικά δεδομένα
	  	 */
	
		int countPrivateData = 0;

	    // getting decisions
	    JSONArray ja = (JSONArray) jobj.get("decisions");
	          
        // iterating array of objects inside decisions, the decisions
        Iterator itr = ja.iterator();
	          
        while (itr.hasNext()) 
        {
        	JSONObject decision = (JSONObject) itr.next();
        	
        	boolean privateData = (boolean) decision.get("privateData");
        	if(privateData)
        		countPrivateData++;	
        }
        
        return countPrivateData;
    }
}
