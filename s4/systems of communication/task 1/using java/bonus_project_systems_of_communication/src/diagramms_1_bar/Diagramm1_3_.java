package diagramms_1_bar;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import main.*;
public class Diagramm1_3_ extends JFrame {
	
	public Diagramm1_3_(Table_having_the_capacityPerBandwidth table_having_the_capacityPerBandwidth) {	
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(Row_having_the_capacityPerBandwidth r : table_having_the_capacityPerBandwidth.getTable_having_the_capacityPerBandwidth())
		{
			//dataset.addValue(r.getSNRclearNumber(), "Classes", "" + r.getSNRtodB());
			dataset.addValue(r.getSNRtodB(), "Classes", "" + r.getSNRclearNumber());
		}
		
		//JFreeChart chart = ChartFactory.createBarChart3D("SNR to dB με SNR (καθαρός αριθμός)", "SNR to dB ", "SNR (καθαρός αριθμός)", 
		JFreeChart chart = ChartFactory.createBarChart3D("SNR to dB με SNR (καθαρός αριθμός)", "SNR (καθαρός αριθμός)", "SNR to dB ",  
				dataset, PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(chart);
		
		this.setContentPane(chartPanel);
		this.setTitle("Diagramm1_3_");
		this.setVisible(true);
		this.setSize(400, 500);
	}
	
}
