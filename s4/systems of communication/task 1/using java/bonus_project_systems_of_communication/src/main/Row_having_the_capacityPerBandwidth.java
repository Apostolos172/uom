package main;


public class Row_having_the_capacityPerBandwidth implements Comparable<Row_having_the_capacityPerBandwidth> {
	
	private double capacityPerBandwidth;
	private double SNRtodB;
	private double SNRclearNumber;
	
	@Override
	public int compareTo(Row_having_the_capacityPerBandwidth other) {
		if(this.capacityPerBandwidth < other.capacityPerBandwidth)
			return -1;
		else if(this.capacityPerBandwidth > other.capacityPerBandwidth)
			return 1;
		else
			return 0;
	}
	
	public Row_having_the_capacityPerBandwidth(double capacityPerBandwidth)
	{
		this.capacityPerBandwidth = capacityPerBandwidth;
		this.calculateSNRtodB();
		this.calculateSNRclearNumber();
	}
	
	//getters and setters
	public void setSNRtodB(double sNRtodB) {
		SNRtodB = sNRtodB;
	}

	public double getCapacityPerBandwidth() {
		return capacityPerBandwidth;
	}

	public double getSNRtodB() {
		return SNRtodB;
	}

	public double getSNRclearNumber() {
		return SNRclearNumber;
	}

	public void setSNRclearNumber(double sNRclearNumber) {
		SNRclearNumber = sNRclearNumber;
	}
	
	//other methods
	public void calculateSNRtodB()
	{
		double SNRtodB;
		SNRtodB = Math_of_communication.getSNRtodBHavingCapacityPerBandwidth(this.capacityPerBandwidth);
		SNRtodB = Math.round(SNRtodB * 100.0) / 100.0;
		this.setSNRtodB(SNRtodB);
	}
	
	public void calculateSNRclearNumber()
	{
		double SNRclearNumber;
		SNRclearNumber = Math_of_communication.getSNRclearNumberHavingCapacityPerBandwidth(this.capacityPerBandwidth);
		SNRclearNumber = Math.round(SNRclearNumber * 1000.0) / 1000.0;
		this.setSNRclearNumber(SNRclearNumber);
	}
	
	public String getRowData()
	{
		String row;
		row = "" + this.capacityPerBandwidth + ", " + this.SNRtodB + ", " + this.SNRclearNumber + "\n";
		return row;
	}
}
