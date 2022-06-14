package main;


public class Math_of_communication {

		public static double getdBmtoWatt(double dBm)
		{
			double watt = Math.pow(10, dBm/10-3);
			
			return watt;

		}
		
		public static double getSNRclearNumberHavingSNRtodB(double SNRtodB)
		{
			double SNRclearNumber;
			
			SNRclearNumber = Math.pow(10, SNRtodB/10.0);
			
			return SNRclearNumber;
		}
		
		public static double getCapacityPerbandwidthHavingSNRclearNumber(double SNR)
		{
			double capacityPerbandwidth;
			
			capacityPerbandwidth = Math.log10(1+SNR)/Math.log10(2);
			
			return capacityPerbandwidth;
		}

		public static double getCapacityPerbandwidthHavingSNRtodB(double SNRtodB)
		{
			double capacityPerbandwidth;
			
			capacityPerbandwidth = Math.log10(1+Math.pow(10, SNRtodB/10.0))/Math.log10(2);
			
			return capacityPerbandwidth;
		}
		
		
		public static double getSNRclearNumberHavingCapacityPerBandwidth(double CapacityPerBandwidth)
		{
			double SNRclearNumber;
			
			SNRclearNumber = Math.pow(2, CapacityPerBandwidth)-1;
			
			return SNRclearNumber;
		}
		
		public static double getSNRtodBHavingCapacityPerBandwidth(double CapacityPerBandwidth)
		{
			double SNRtodB;
			
			SNRtodB = 10*Math.log10(Math.pow(2, CapacityPerBandwidth)-1);
			
			return SNRtodB;
		}
	
}
