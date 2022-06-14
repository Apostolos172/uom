package main;


public class Row_having_the_SNRtodB implements Comparable<Row_having_the_SNRtodB>{
	
	private double SNRtodB;
	private double capacityPerBandwidth;
	private double SNRclearNumber;
	
	@Override
	public int compareTo(Row_having_the_SNRtodB other) {
		if(this.SNRtodB < other.SNRtodB)
			return -1;
		else if(this.SNRtodB > other.SNRtodB)
			return 1;
		else
			return 0;
	}
	
	public Row_having_the_SNRtodB(double SNRtodB)
	{
		this.SNRtodB = SNRtodB;
		this.calculatecapacityPerBandwidth();
		this.calculateSNRclearNumber();
	}

	//setters
	public void setcapacityPerBandwidth(double capacityPerBandwidth) {
		this.capacityPerBandwidth = capacityPerBandwidth;
	}

	public double getSNRtodB() {
		return SNRtodB;
	}

	public double getCapacityPerBandwidth() {
		return capacityPerBandwidth;
	}

	public double getSNRclearNumber() {
		return SNRclearNumber;
	}

	public void setSNRclearNumber(double sNRclearNumber) {
		this.SNRclearNumber = sNRclearNumber;
	}
	
	//other methods
	public void calculatecapacityPerBandwidth()
	{
		double capacityPerBandwidth;
		capacityPerBandwidth = Math_of_communication.getCapacityPerbandwidthHavingSNRtodB(this.SNRtodB);
		capacityPerBandwidth = Math.round(capacityPerBandwidth * 1000.0) / 1000.0;
		this.setcapacityPerBandwidth(capacityPerBandwidth);
	}
	
	public void calculateSNRclearNumber()
	{
		double SNRclearNumber;
		SNRclearNumber = Math_of_communication.getSNRclearNumberHavingSNRtodB(this.SNRtodB);
		SNRclearNumber = Math.round(SNRclearNumber * 1000.0) / 1000.0;
		this.setSNRclearNumber(SNRclearNumber);
	}
	
	public String getRowData()
	{
		String row;
		row = "" + this.SNRtodB + ", " + this.capacityPerBandwidth + ", " + this.SNRclearNumber + "\n";
		return row;
	}
}
