package diagramms_2_bar;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import main.*;

public class Diagramm2_1 extends JFrame{
	
	public Diagramm2_1(Table_having_the_SNRtodB table_having_the_SNRtodB)
	{
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		for(Row_having_the_SNRtodB r : table_having_the_SNRtodB.getTable_having_the_SNRtodB())
		{
			//dataset.addValue(r.getCapacityPerBandwidth(), "Classes", "" + r.getSNRtodB());
			dataset.addValue(r.getSNRtodB(), "Classes", "" + r.getCapacityPerBandwidth());
		}
		
		//JFreeChart chart = ChartFactory.createBarChart3D("SNR σε dB με Φασματική", "SNR (dB) ", "Φασματική απόδοση", 
		JFreeChart chart = ChartFactory.createBarChart3D("SNR σε dB με Φασματική", "Φασματική απόδοση", "SNR (dB) ",  
				dataset, PlotOrientation.VERTICAL, false, true, false);

		ChartPanel chartPanel = new ChartPanel(chart);
		
		this.setContentPane(chartPanel);
		this.setTitle("Diagramm2_1");
		this.setVisible(true);
		this.setSize(500, 500);
	}
}
