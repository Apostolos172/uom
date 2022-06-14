package main;


import java.util.ArrayList;

public class Table_having_the_SNRtodB {
	
	private ArrayList<Row_having_the_SNRtodB> table_having_the_SNRtodB;
	
	public Table_having_the_SNRtodB()
	{
		table_having_the_SNRtodB = new ArrayList<>();
	}
	
	public ArrayList<Row_having_the_SNRtodB> getTable_having_the_SNRtodB() {
		return table_having_the_SNRtodB;
	}

	public void addRow(Row_having_the_SNRtodB row)
	{
		table_having_the_SNRtodB.add(row);
	}
	
	public String getOrder()
	{
		String row;
		row = "SNRtodB, capacityPerBandwidth, SNRclearNumber";
		return row;
	}
	
}
