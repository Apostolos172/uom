package diagramms_1_bar;
import javax.swing.JFrame;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

import main.*;

public class Diagramm1_2 extends JFrame {
	
	public Diagramm1_2(Table_having_the_capacityPerBandwidth table_having_the_capacityPerBandwidth) {	
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(Row_having_the_capacityPerBandwidth r : table_having_the_capacityPerBandwidth.getTable_having_the_capacityPerBandwidth())
		{
			dataset.addValue(r.getSNRclearNumber(), "Classes", "" + r.getCapacityPerBandwidth());
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Φασματική με SNR (καθαρός αριθμός)", "Φασματική", "SNR (καθαρός αριθμός)", 
				dataset, PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(chart);
		
		this.setContentPane(chartPanel);
		this.setTitle("Diagramm1_2");
		this.setVisible(true);
		this.setSize(500, 500);
	}
	

}