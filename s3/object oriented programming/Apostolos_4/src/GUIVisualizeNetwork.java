
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.algorithms.shortestpath.DistanceStatistics;
import org.apache.commons.collections15.Transformer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;

public class GUIVisualizeNetwork extends JFrame{
	private JPanel panel,centralPanel,northPanel,southPanel;
	private JButton buttonReturn;
    private ImageIcon image;
    private JLabel imageLabel;
    private JTextField diameterField;
	
	private Registry registry;
	
	public GUIVisualizeNetwork(Registry registry)
	{
		super("SurveillanceNet");
		this.registry = registry;
		makeFrame();
	}
	
	public void makeFrame()
	{
		panel = new JPanel(new BorderLayout());
		centralPanel = new JPanel(new BorderLayout());
		centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); 
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		Font serifFont = new Font("serif", Font.BOLD, 20);
		Font sansSerifFont = new Font("Sans Serif", Font.BOLD, 16);
		
        image = new ImageIcon("src/Suspect.png");
        imageLabel = new JLabel(image);
        northPanel.add(imageLabel);
		
		Graph<String, String> graph = new SparseMultigraph<String, String>();
		for(Suspect s : registry.getSuspects())
		{
			graph.addVertex(s.getCodeName());			
		}
		
		/*
		graph.addEdge("partners1", "Frozen Bear", "Quick knife");
		graph.addEdge("partners2", "Frozen Bear", "Sleepy Dog");
		graph.addEdge("partners3", "Sleepy Dog", "Rusty Knife");
		graph.addEdge("partners4", "Rusty Knife", "Frozen Bear");
		*/
		
		ArrayList<String> edges = new ArrayList<>();
		for(Suspect s : registry.getSuspects())
		{
			for(Suspect sp : s.getPartners())
			{
				String edge = "partners"+sp.getCodeName()+s.getCodeName();
				String edge_other = "partners"+s.getCodeName()+sp.getCodeName();
				if((!(edges.contains(edge))&&(!(edges.contains(edge_other)))))
				{
					graph.addEdge(edge, sp.getCodeName(), s.getCodeName());
					edges.add(edge);
				}
			}
		}
		
		/*
		for(Suspect s : registry.getSuspects())
		{
			for(Suspect sp : s.getPartners())
			{
				{
					System.out.println(graph.findEdge(s.getCodeName(), sp.getCodeName()) + "\n");
				}
			}
		}
		*/
		System.out.println(graph.toString());
		
		Layout<String, String> layout = new CircleLayout<>(graph);
		layout.setSize(new Dimension(300,300)); 
		BasicVisualizationServer<String,String> vv = new BasicVisualizationServer<String,String>(layout);
		vv.setPreferredSize(new Dimension(400,350));
		centralPanel.add(vv,BorderLayout.CENTER);
		
		Transformer<String,Paint> vertexPaint = new Transformer<String,Paint>() {
			public Paint transform(String s) {
			return Color.CYAN;
			}
			};
			
		Transformer<String,Font> vertexFont = new Transformer<String,Font>() {
			public Font transform(String s) {
			return sansSerifFont;
			}
			};
			
		vv.getRenderContext().setVertexFillPaintTransformer(vertexPaint);
		vv.getRenderContext().setVertexFontTransformer(vertexFont);
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
		vv.getRenderer().getVertexLabelRenderer().setPosition(Position.SE);
		
		//http://jung.sourceforge.net/doc/api/edu/uci/ics/jung/algorithms/shortestpath/DistanceStatistics.html
		double diameter = 0;
		diameter = DistanceStatistics.diameter(graph);
		System.out.println("diameter" + diameter);
		
		//diameter' s field
		diameterField = new JTextField("Diameter = " + diameter, 10);
		diameterField.setEditable(false);
		diameterField.setFont(sansSerifFont);
		centralPanel.add(diameterField,BorderLayout.SOUTH);
		
		//return
		buttonReturn = new JButton("Return to Search Screen");
		buttonReturn.setFont(serifFont);
		southPanel.add(buttonReturn);
		buttonReturnListener returnlistener = new buttonReturnListener();
		buttonReturn.addActionListener(returnlistener);
		
		panel.add(centralPanel,BorderLayout.CENTER);
		panel.add(northPanel,BorderLayout.NORTH);
		panel.add(southPanel,BorderLayout.SOUTH);
		setContentPane(panel);
		
		centralPanel.setBackground(Color.getHSBColor(19, 38, 31));
		centralPanel.setBackground(Color.getHSBColor(0, 100, 50));		
		northPanel.setBackground(Color.getHSBColor(19, 38, 31));
		southPanel.setBackground(Color.getHSBColor(19, 38, 31));
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(450,650);

	}
	
	class buttonReturnListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose(); 
		}
		
	}
}
