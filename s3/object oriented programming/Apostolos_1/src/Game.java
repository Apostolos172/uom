/*
 	Game:Σε αυτή την κλάση θεωρήθηκαν ως οντότητα οι φορές που παίζει ο χρήστης το παιχνίδι-οι παρτίδες και σαν ιδιότητες-πεδία
		 οι νίκες, οι ήττες και ο αριθμός των φορών που παίζει, τα οποία μεταβάλλονται και ανακτώνται αντίστοιχα στη διάρκεια του
  		 παιχνιδιού μέσα από setters(που απλά αυξάνουν τον αριθμό των πεδίων κατά 1 άμμεσα) και getters όπου είναι απαραίτητο.
*/

public class Game 
{
	private int times;
	private int wins;
	private int losses;
	
	public Game()
	{
		times=0;
		wins=0;
		losses=0;
	}
	
	public int getTimes()
	{
		return times;
	}
	
	public int getWins()
	{
		return wins;
	}
	
	public int getLosses()
	{
		return losses;
	}
	
	public void setTimes()
	{
		times+=1;
	}
	
	public void setWins()
	{
		wins+=1;
	}
	
	public void setLosses()
	{
		losses+=1;
	}
	
}
