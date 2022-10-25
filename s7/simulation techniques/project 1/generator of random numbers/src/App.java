public class App {

    public static void main(String[] args) {
		
		int numberRandomNumbers = 1000000;
		long m = (long) Math.pow(2,31);
		int Zo = 4534;
		System.out.println(m);
		
		long Z1 = RandomNumberGenerator(m, Zo);
		System.out.println(Z1);
		long Zi = Z1;
		double Ui = (double) Zi/m;
		System.out.println("number 1: " + Ui);
		
		// Test Περιοχών
		int region01, region02, region03, region04, region05, region06, region07, 
		region08, region09, region10;
		region01 = region02 = region03 = region04 = region05 = region06 = region07 = 
				region08 = region09 = region10 = 0;
	
		if(Ui<0.1)
			region01++;
		else if(Ui<0.2)
			region02++;
		else if(Ui<0.3)
			region03++;
		else if(Ui<0.4)
			region04++;
		else if(Ui<0.5)
			region05++;
		else if(Ui<0.6)
			region06++;
		else if(Ui<0.7)
			region07++;
		else if(Ui<0.8)
			region08++;
		else if(Ui<0.9)
			region09++;
		else
			region10++;
		
		// έλεγχοι ροών
		int[] runs = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
/*
		int run1, run2, run3, run4, run5, run6, run7, 
		run8, run9, run10;
		run1 = run2 = run3 = run4 = run5 = run6 = run7 = 
				run8 = run9 = run10 = 0;
*/
		
		int index = 0;
		runs[index]++;
		
		// true -> up VS false -> down, half = 0,5
		boolean flag = true;
		if(Ui<0.5)
			flag = false;
				
		
		double sum = Ui;
		double sum2 = Ui;
		
		int number = 0;
		
		for(number=2; number<=numberRandomNumbers; number++) {
			Zi = RandomNumberGenerator(m, Zi);
			Ui = (double) Zi/m;
			sum+= Ui;
			if(numberRandomNumbers==100)
				System.out.println("number " + number + ": " + Ui);
		}
		
		double mean = sum/number;
		//double mean = 0.5;
		System.out.println("Mean: " + mean);
			
		
		Zi = Z1;
		for(number=2; number<=numberRandomNumbers; number++) {
			Zi = RandomNumberGenerator(m, Zi);
			Ui = (double) Zi/m;
			sum2+= Math.pow(Ui - mean, 2);
			
			if(flag==true) // > 0.5
			{
				if(Ui<0.5)
				{
					flag=false;
					index=0;
					runs[index]++;
				}
				else
				{
					runs[index]--;
					index++;
					if(index<10)
						runs[index]++;
					else
					{
						runs[index-1]--;
						index = 0;
					}
				}
			}
			else
			{
				if(Ui>0.5)
				{
					flag=true;
					index=0;
					runs[index]++;
				}
				else
				{
					runs[index]--;
					index++;
					if(index<10)
						runs[index]++;
					else
					{
						runs[index-1]--;
						index = 0;
					}
				}
			}
				
			
			
			if(Ui<0.1)
				region01++;
			else if(Ui<0.2)
				region02++;
			else if(Ui<0.3)
				region03++;
			else if(Ui<0.4)
				region04++;
			else if(Ui<0.5)
				region05++;
			else if(Ui<0.6)
				region06++;
			else if(Ui<0.7)
				region07++;
			else if(Ui<0.8)
				region08++;
			else if(Ui<0.9)
				region09++;
			else
				region10++;
				
		}
		
		double variance  = sum2/number;
		double necessaryVariance = Math.round(1/12.0*10000)/10000.0;
		System.out.println("Variance (1/12): " + necessaryVariance + "=?" + variance);
		
		System.out.println("region01 " + region01);
		System.out.println("region02 " + region02);
		System.out.println("region03 " + region03);
		System.out.println("region04 " + region04);
		System.out.println("region05 " + region05);
		System.out.println("region06 " + region06);
		System.out.println("region07 " + region07);
		System.out.println("region08 " + region08);
		System.out.println("region09 " + region09);
		System.out.println("region10 " + region10);
		
		
		System.out.println("runtest1 " + runs[0]);
		System.out.println("runtest2 " + runs[1]);
		System.out.println("runtest3 " + runs[2]);
		System.out.println("runtest4 " + runs[3]);
		System.out.println("runtest5 " + runs[4]);
		System.out.println("runtest6 " + runs[5]);
		System.out.println("runtest7 " + runs[6]);
		System.out.println("runtest8 " + runs[7]);
		System.out.println("runtest9 " + runs[8]);
		System.out.println("runtest10 " + runs[9]);
	
		
	}
	
	public static long RandomNumberGenerator(long m, long Zi_1) {
		int a = 1103515245; //31 bits
		int c = 12345;
		
		long Zi = (a*Zi_1+c)%m;
		
		return Zi;
	}
}
