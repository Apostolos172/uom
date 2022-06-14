
package diagramms_2_line;

import javax.swing.JFrame;  
      
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.DefaultCategoryDataset;  

import main.*;

public class Diagramm2_2_line extends JFrame {  
      
    private static final long serialVersionUID = 1L;  
      
    private Table_having_the_SNRtodB table_having_the_SNRtodB;
      
    public Diagramm2_2_line(Table_having_the_SNRtodB table_having_the_SNRtodB ) {  
    	    	  
    	this.table_having_the_SNRtodB = table_having_the_SNRtodB;
    	  
        // Create dataset  
        DefaultCategoryDataset dataset = createDataset();  
        // Create chart  
        JFreeChart chart = ChartFactory.createLineChart(  
            "SNR σε dB με SNR (καθαρός αριθμός)", // Chart title  
            "SNR (dB)", // X-Axis Label  
            "SNR (καθαρός αριθμός)", // Y-Axis Label  
            dataset 
            );  
        //x,y names
      
        ChartPanel panel = new ChartPanel(chart);  
        
        setContentPane(panel);
        
        this.setTitle("Diagramm2_2_line");
        this.setSize(400, 500);  
        this.setVisible(true); 
    }  
      
    private DefaultCategoryDataset createDataset() { 
      
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        
        for(Row_having_the_SNRtodB r : this.table_having_the_SNRtodB.getTable_having_the_SNRtodB())
		{
			dataset.addValue(r.getSNRclearNumber(), "", "" + r.getSNRtodB());
		}
        
        //dataset y,x
        
        return dataset;  
    }  
      
}  
