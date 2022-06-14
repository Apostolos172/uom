package diagramms_1_line;

import javax.swing.JFrame;  
      
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  
      
import main.*;

public class Diagramm1_1_line extends JFrame {  
      
    private static final long serialVersionUID = 1L;  
      
    private Table_having_the_capacityPerBandwidth table_having_the_capacityPerBandwidth;
      
    public Diagramm1_1_line(Table_having_the_capacityPerBandwidth table_having_the_capacityPerBandwidth ) {  
    	    	  
    	this.table_having_the_capacityPerBandwidth = table_having_the_capacityPerBandwidth;
    	  
        // Create dataset  
        DefaultCategoryDataset dataset = createDataset();  
        // Create chart  
        JFreeChart chart = ChartFactory.createLineChart(  
            "��������� �� SNR �� dB", // Chart title  
            "���������", // X-Axis Label  
            "SNR �� dB", // Y-Axis Label  
            dataset  
            );  
      
        ChartPanel panel = new ChartPanel(chart);  
        
        setContentPane(panel);
        
        this.setTitle("Diagramm1_1_line");
        this.setSize(400, 500);  
        this.setVisible(true); 
    }  
      
    private DefaultCategoryDataset createDataset() { 
      
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        
        for(Row_having_the_capacityPerBandwidth r : this.table_having_the_capacityPerBandwidth.getTable_having_the_capacityPerBandwidth())
		{
			//dataset.addValue(r.getCapacityPerBandwidth(), "Classes", "" + r.getSNRtodB());
			dataset.addValue(r.getSNRtodB(), "SNR �� dB", "" + r.getCapacityPerBandwidth());
		}
        
        //dataset y,x
        
        return dataset;  
    }  
      
}  
