import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.util.ArrayList;

public class GUISuspectPage extends JFrame{
	//panel το κεντρικό panel του παραθύρου
	private JPanel panel;
    private ImageIcon image;
    private JLabel imageLabel;
    //centralPanel υποπάνελ του panel
    private JPanel centralPanel;
	//panel1 υποπάνελ του centralPanel
	private JPanel panel1;
	private JTextField suspectName,suspectCodeName;
	private JList<String> suspectTelephones;
	//panel2 υποπάνελ του centralPanel
	private JPanel panel2;
	private JPanel subpanel;
	private JButton buttonClear;
	private JButton buttonRecovery;
	private JTextField telephone;
	private JTextArea messages;
	private JScrollPane ScrollPaneMessages;
	private JButton buttonFindSMS;
	//panel3 υποπάνελ του centralPanel
	private JPanel panel3;
	private JLabel partners;
	private JTextArea names;
	//panel4 υποπάνελ του centralPanel
	private JPanel panel4;
	private JTextField suggestedPartners;
	private JTextArea namesOnly;
	//panel5 υποπάνελ του centralPanel
	private JPanel panel5;
	private JTextArea compatriots;
	//southPanel υποπάνελ του panel
	private JPanel southPanel;
	private JButton buttonReturn;
    
	private Suspect suspect;
    private Registry registry;
    private GUIFindSuspect mainWindow;
	
	public GUISuspectPage(Suspect suspect, Registry registry, GUIFindSuspect mainWindow) {
		super("Suspect Page");
		this.suspect = suspect;
		this.registry = registry;
		this.mainWindow = mainWindow;
		mainWindow.setVisible(false);
		makeFrame();
	}
	
	public void makeFrame() {
		panel = new JPanel(new BorderLayout());
		
		centralPanel = new JPanel();
	    GridLayout layout = new GridLayout(6,1);
	    layout.setVgap(25);
	    centralPanel.setLayout(layout);
	    centralPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		
		Font serifFont = new Font("serif", Font.BOLD, 20);
		Font serifFontSmall = new Font("serif", Font.BOLD, 16);
		Font sansSerifFontSmall = new Font("Sans Serif", Font.ITALIC|Font.BOLD, 17);
		
		Border blackline = BorderFactory.createLineBorder(Color.black);
		
		panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel1.setBorder(blackline);
		panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel2.setBorder(blackline);
		panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel3.setBorder(blackline);
		subpanel = new JPanel(new GridLayout(2,1,0,5));
		panel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel4.setBorder(blackline);
		panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel5.setBorder(blackline);
		
		image = new ImageIcon("src/Suspect.png");
        imageLabel = new JLabel(image);
        centralPanel.add(imageLabel);
        
        //panel1
		suspectName = new JTextField("Suspect: " + suspect.getName(), 15);
		suspectName.setFont(serifFont);
		panel1.add(suspectName);
		suspectName.setEditable(false);
		    
		suspectCodeName = new JTextField("Code name: " + suspect.getCodeName(), 15);
		suspectCodeName.setFont(serifFont);
		panel1.add(suspectCodeName);
		suspectCodeName.setEditable(false);
		
		suspectTelephones = new JList<String>();
		suspectTelephones.setFont(serifFont);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for(String t: this.suspect.getTelephoneNumbers()) {
			listModel.addElement(t);
		}		
		suspectTelephones.setModel(listModel);				
		panel1.add(suspectTelephones);
		
		//panel2
		buttonClear = new JButton("Clear textField");
		buttonClear.setFont(serifFontSmall);
		subpanel.add(buttonClear);
		buttonClearListener clearlistener = new buttonClearListener();
		buttonClear.addActionListener(clearlistener);
		
		buttonRecovery = new JButton("Recovery textField");
		buttonRecovery.setFont(serifFontSmall);
		subpanel.add(buttonRecovery);
		buttonRecoveryListener recoverylistener = new buttonRecoveryListener();
		buttonRecovery.addActionListener(recoverylistener);
		
		panel2.add(subpanel);
		
		telephone = new JTextField("Give the telephone number", 15);
		telephone.setFont(sansSerifFontSmall);
		panel2.add(telephone);
		telephone.setEditable(true);
		
		messages = new JTextArea(7,20);
		ScrollPaneMessages = new JScrollPane(messages);
		panel2.add(ScrollPaneMessages);
		messages.setEditable(false);
		
		buttonFindSMS = new JButton("Find SMS");
		buttonFindSMS.setFont(serifFontSmall);
		panel2.add(buttonFindSMS);
		buttonFindSMSListener findSMSlistener = new buttonFindSMSListener();
		buttonFindSMS.addActionListener(findSMSlistener);
		
		//panel3
		partners = new JLabel("Partners", 10);
		partners.setFont(serifFont);
		panel3.add(partners);
		
		names = new JTextArea(7, 10);
		for(Suspect s : suspect.getPartners())
		{
			names.append(s.getName());
			names.append(" ");
			names.append(s.getCodeName());
			names.append("\n");
		}
		panel3.add(names);
		names.setEditable(false);
		
		//panel4
		suggestedPartners = new JTextField("Suggested Partners------->", 15);
		suggestedPartners.setFont(serifFont);
		panel4.add(suggestedPartners);
		suggestedPartners.setEditable(false);
		
		namesOnly = new JTextArea(5, 10);
		for(Suspect s : suspect.getSuggestedPartners())
		{
			namesOnly.append(s.getName());
			namesOnly.append("\n");
		}
		panel4.add(namesOnly);
		namesOnly.setEditable(false);
		
		//panel5
		compatriots = new JTextArea(5, 10);
		compatriots.append("Suspects coming from " + suspect.getOriginCountry() + "\n");
		compatriots.append(suspect.getName() + "\n");
		for(String s : suspect.getCompatriotsPartners())
		{
			compatriots.append(s);
			compatriots.append("\n");
		}
		panel5.add(compatriots);
		compatriots.setEditable(false);
		
		//return
		buttonReturn = new JButton("Return to Search Screen");
		buttonReturn.setFont(serifFont);
		southPanel.add(buttonReturn);
		buttonReturnListener returnlistener = new buttonReturnListener();
		buttonReturn.addActionListener(returnlistener);
		
		//put "sub-panels" to the centralPanel
		centralPanel.add(panel1);
		centralPanel.add(panel2);
		centralPanel.add(panel3);
		centralPanel.add(panel4);
		centralPanel.add(panel5);
		
		//put "sub-panels" to the panel
		panel.add(southPanel,BorderLayout.SOUTH);
		panel.add(centralPanel,BorderLayout.CENTER);
		setContentPane(panel);
		
		panel1.setBackground(Color.getHSBColor(269, 38, 31));
		panel2.setBackground(Color.getHSBColor(269, 38, 31));
		panel3.setBackground(Color.getHSBColor(269, 38, 31));
		panel4.setBackground(Color.getHSBColor(269, 38, 31));
		panel5.setBackground(Color.getHSBColor(269, 38, 31));
		subpanel.setBackground(Color.getHSBColor(269, 38, 31));
		
		//adjustment of panel
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(800,1000);
	}
	
	class buttonClearListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			telephone.setText("");
		}
	}
	
	class buttonRecoveryListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			telephone.setText("Give the telephone number");
		}
	}
	
	class buttonReturnListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			dispose(); 
			mainWindow.setVisible(true);
		}
	}
	
	class buttonFindSMSListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			String number = telephone.getText();
			ArrayList<String> content_of_smses = new ArrayList<>();
			
			content_of_smses = registry.getMessagesWith(number, suspect);
			for(String s : content_of_smses) {
				messages.append(s + "\n");
			}
		}
	}
}
