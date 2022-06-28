import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIFindSuspect extends JFrame{
	private JPanel panel,centralPanel,northPanel,subpanel;
	private JButton buttonFind,buttonClear,buttonRecovery,buttonVisualizeNetwork;
	private JTextField nameOfSuspect;
    private ImageIcon image;
    private JLabel imageLabel;
    
    private Registry registry;
    private GUIFindSuspect mainWindow;
	
	public GUIFindSuspect(Registry registry) {
		super("Find Suspect");
		this.registry = registry;
		this.mainWindow = this;
		makeFrame();
	}
	
	public void makeFrame() {
		panel = new JPanel(new BorderLayout());
		centralPanel = new JPanel();
		subpanel = new JPanel(new GridLayout(2,1,0,5));
		northPanel = new JPanel();
		
		Font serifFont = new Font("serif", Font.BOLD, 20);
		Font sansSerifFont = new Font("Sans Serif", Font.BOLD, 18);
		
        image = new ImageIcon("src/Suspect.png");
        imageLabel = new JLabel(image);
        northPanel.add(imageLabel);
		
		buttonClear = new JButton("Clear textField");
		buttonClear.setFont(serifFont);
		subpanel.add(buttonClear);
		buttonClearListener clearlistener = new buttonClearListener();
		buttonClear.addActionListener(clearlistener);
		
		buttonRecovery = new JButton("Recovery textField");
		buttonRecovery.setFont(serifFont);
		subpanel.add(buttonRecovery);
		buttonRecoveryListener recoverylistener = new buttonRecoveryListener();
		buttonRecovery.addActionListener(recoverylistener);
		
		centralPanel.add(subpanel);
        
		nameOfSuspect = new JTextField("Please enter suspect's name",40);
		nameOfSuspect.setFont(sansSerifFont);
		centralPanel.add(nameOfSuspect);
		
		buttonFind = new JButton("Find");
		buttonFind.setFont(serifFont);
		centralPanel.add(buttonFind);
		buttonFindSuspectListener findSuspectlistener = new buttonFindSuspectListener();
		buttonFind.addActionListener(findSuspectlistener);
		
		buttonVisualizeNetwork = new JButton("Visualize network");
		buttonVisualizeNetwork.setFont(serifFont);
		centralPanel.add(buttonVisualizeNetwork);
		buttonVisualizeNetworkListener visualizeNetworklistener = new buttonVisualizeNetworkListener();
		buttonVisualizeNetwork.addActionListener(visualizeNetworklistener);
		
		panel.add(centralPanel,BorderLayout.CENTER);
		panel.add(northPanel,BorderLayout.NORTH);
		setContentPane(panel);
		
		centralPanel.setBackground(Color.getHSBColor(19, 38, 31));
		subpanel.setBackground(Color.getHSBColor(19, 38, 31));
		northPanel.setBackground(Color.getHSBColor(214, 27, 53));
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class buttonClearListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			nameOfSuspect.setText("");
		}
	}
	
	class buttonRecoveryListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			nameOfSuspect.setText("Please enter suspect's name");
		}
	}
	
	class buttonFindSuspectListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String nameSuspect = nameOfSuspect.getText();
			Suspect suspect = null;
			for(Suspect s : registry.getSuspects()) {
				if((s.getName()).compareToIgnoreCase(nameSuspect)==0)
					suspect=s;
			}

			if(suspect==null)
			{
				GUIMessage message = new GUIMessage(nameSuspect);
				message.setLocation(400, 500);
			}
			else
			{
				GUISuspectPage suspectPage = new GUISuspectPage(suspect,registry,mainWindow);
				suspectPage.setLocation(885, 10);
			}
		}
	}
	
	class buttonVisualizeNetworkListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			GUIVisualizeNetwork visualizationPage = new GUIVisualizeNetwork(registry);
			visualizationPage.setLocation(1000, 50);
		}
		
	}
}
