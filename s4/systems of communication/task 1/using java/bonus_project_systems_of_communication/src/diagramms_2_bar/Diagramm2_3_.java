package diagramms_2_bar;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import main.*;

public class Diagramm2_3_ extends JFrame{
	
	public Diagramm2_3_(Table_having_the_SNRtodB table_having_the_SNRtodB)
	{
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(Row_having_the_SNRtodB r : table_having_the_SNRtodB.getTable_having_the_SNRtodB())
		{
			dataset.addValue(r.getSNRclearNumber(), "Classes", "" + r.getCapacityPerBandwidth());
			//dataset.addValue(r.getCapacityPerBandwidth(), "Classes", "" + r.getSNRclearNumber());
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D("Φασματική με SNR (καθαρός αριθμός)", "Φασματική", "SNR (καθαρός αριθμός)", 
		//JFreeChart chart = ChartFactory.createBarChart3D("Φασματική με SNR (καθαρός αριθμός)", "SNR (καθαρός αριθμός)", "Φασματική",  
				dataset, PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(chart);
		
		this.setContentPane(chartPanel);
		this.setTitle("Diagramm2_3_");
		this.setVisible(true);
		this.setSize(400, 500);
	}
}
