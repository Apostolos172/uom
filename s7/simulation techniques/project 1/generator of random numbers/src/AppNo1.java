
public class AppNo1 {

	public static void main(String[] args) {
		
		int numberRandomNumbers = 100; // ή 1000000
		double m = Math.pow(2,31);
		double Zo = 75391;
		
		double Z1 = RandomNumberGenerator(m, Zo);
		double Zi = Z1;
		double Ui = Zi/m;
		System.out.println("number 1: " + Ui);
		
		double sum = Ui;
		double sum2 = Ui;
		
		int number = 0;
		
		for(number=2; number<=numberRandomNumbers; number++) {
			Zi = RandomNumberGenerator(m, Zi);
			Ui = Zi/m;
			sum+= Ui;
			if(numberRandomNumbers==100)
				System.out.println("number " + number + ": " + Ui);
		}
		
		double mean = sum/number;
		System.out.println("Mean: " + mean);
			
		Zi = Z1;
		for(number=2; number<=100; number++) {
			Zi = RandomNumberGenerator(m, Zi);
			Ui = Zi/m;
			sum2+= Math.pow(Ui - mean, 2);
		}
		
		double variance  = sum2/number;
		double necessaryVariance = Math.round(1/12.0*10000)/10000.0;
		System.out.println("Variance (1/12): " + necessaryVariance + "=?" + variance);
		
	}
	
	public static double RandomNumberGenerator(double m, double Zi_1) {
		double a = 1103515245; //31 bits
		double c = 12345;
		
		double Zi = (a*Zi_1+c)%m;
		
		return Zi;
	}

}
