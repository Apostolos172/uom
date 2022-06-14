package main;

import java.util.ArrayList;

public class Table_having_the_capacityPerBandwidth {
	
	private ArrayList<Row_having_the_capacityPerBandwidth> table_having_the_capacityPerBandwidth;
	
	public Table_having_the_capacityPerBandwidth()
	{
		table_having_the_capacityPerBandwidth = new ArrayList<>();
	}
	
	public ArrayList<Row_having_the_capacityPerBandwidth> getTable_having_the_capacityPerBandwidth() {
		return table_having_the_capacityPerBandwidth;
	}

	//
	public void addRow(Row_having_the_capacityPerBandwidth row)
	{
		table_having_the_capacityPerBandwidth.add(row);
	}
	
	public String getOrder()
	{
		String row;
		row = "capacityPerBandwidth, SNRtodB, SNRclearNumber";
		return row;
	}
	
}
