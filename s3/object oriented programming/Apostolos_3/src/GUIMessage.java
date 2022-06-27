import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIMessage extends JFrame{
	private JPanel panel,centralPanel,northPanel;
	private JButton buttonOK;
	private JTextField message;
    private ImageIcon image;
    private JLabel imageLabel;
    
    private String suspect;
	
	public GUIMessage(String suspect) {
		super("Message");
		this.suspect = suspect;
		makeFrame();
	}
	
	public void makeFrame() {
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centralPanel = new JPanel();
		northPanel = new JPanel();
		
		Font serifFont = new Font("serif", Font.BOLD, 20);
		Font sansSerifFont = new Font("Sans Serif", Font.BOLD, 16);
		
        image = new ImageIcon("info_black.png");
        imageLabel = new JLabel(image);
        northPanel.add(imageLabel);
        
		message = new JTextField("Suspect " + suspect + " Not Found",30);
		message.setFont(sansSerifFont);
		northPanel.add(message);
		message.setEditable(false);
		
		buttonOK = new JButton("OK");
		buttonOK.setFont(serifFont);
		centralPanel.add(buttonOK);
		buttonOKListener OKlistener = new buttonOKListener();
		buttonOK.addActionListener(OKlistener);
		
		panel.add(northPanel);
		panel.add(centralPanel);
		setContentPane(panel);
		
		centralPanel.setBackground(Color.getHSBColor(166, 38, 31));
		northPanel.setBackground(Color.getHSBColor(19, 38, 31));
		panel.setBackground(Color.getHSBColor(19, 38, 31));
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(500,200);
	}
	
	class buttonOKListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			setVisible(false); 
			dispose(); 
		}
	}
}
