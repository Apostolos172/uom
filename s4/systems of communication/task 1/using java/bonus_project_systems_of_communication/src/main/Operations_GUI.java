package main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

import diagramms_1_bar.*;
import diagramms_1_line.*;
import diagramms_2_bar.*;
import diagramms_2_line.*;

public class Operations_GUI extends JFrame{
	
	private JPanel mainPanel, northPanel, northPanel0, northPanel1, southPanel, centralPanel;
	//northPanel
	//northPanel0
	private JLabel instruction;
	private JTextField value;
	private JButton calcHavingCPerB, calcHavingSNRtodB, sortbtn;
	//northPanel1
	private JLabel instruction1;
	private JTextField value1_1,value1_2,value1_3;
	private JButton calcHavingCPerB1, calcHavingSNRtodB1;
	//centralPanel
	private JTextArea calcHavingCPerBResults, calcHavingSNRtodBresults;
	private JScrollPane calcHavingCPerBResultsPane, calcHavingSNRtodBresultsPane;
	//southPanel
	private JButton calcHavingCPerBResultsVisualize0, calcHavingCPerBResultsVisualize, calcHavingSNRtodBresultsVisualize, calcHavingSNRtodBresultsVisualize0;
	
	private Table_having_the_capacityPerBandwidth table_having_the_capacityPerBandwidth;
	private Table_having_the_SNRtodB table_having_the_SNRtodB;
	
	public Operations_GUI()
	{
		super("Συστήματα επικοινωνιών");
		table_having_the_capacityPerBandwidth = new Table_having_the_capacityPerBandwidth();
		table_having_the_SNRtodB = new Table_having_the_SNRtodB();
		makeFrame();
	}
	
	public void makeFrame()
	{
		mainPanel = new JPanel(new BorderLayout());
		
		makenorthPanel();
		makenorthPanel0();
		makenorthPanel1();
		makeCentralPanel();
		makeSouthPanel();
        
		this.setContentPane(mainPanel);
		
        GUI.setPadding(mainPanel);
		GUI.setSizeOfTheWindow(this);
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void makenorthPanel()
	{
		northPanel = new JPanel(new GridLayout(2,1,5,5));
		northPanel.setBackground(Color.gray);
		GUI.setPadding(northPanel);
		
		mainPanel.add(northPanel,BorderLayout.NORTH);
	}
	
	public void makenorthPanel0()
	{
		northPanel0 = new JPanel();
		northPanel0.setBackground(Color.cyan);
		GUI.setPadding(northPanel0);
		
		instruction = new JLabel("Δώσε την φασματική ή το SNR σε dB και πάρε αποτελέσματα");
		instruction.setFont(GUI.getFont());
		value = new JTextField(5);
		value.setFont(GUI.getFont());
		
		calcHavingCPerB = new JButton("Έδωσα φασματική");
		calcHavingCPerB.setFont(GUI.getFont());
		calcHavingCPerBListener calcHavingCPerBlistener = new calcHavingCPerBListener();
		calcHavingCPerB.addActionListener(calcHavingCPerBlistener);
		
		calcHavingSNRtodB = new JButton("Έδωσα SNR σε dB");
		calcHavingSNRtodB.setFont(GUI.getFont());
		calcHavingSNRtodBListener calcHavingSNRtodBlistener = new calcHavingSNRtodBListener();
		calcHavingSNRtodB.addActionListener(calcHavingSNRtodBlistener);
		
		sortbtn = new JButton("’υξουσα ταξινόμηση αποτελεσμάτων");
		sortbtn.setFont(GUI.getFont());
		sortbtnListener sortbtnlistener = new sortbtnListener();
		sortbtn.addActionListener(sortbtnlistener);
		
		northPanel0.add(instruction);
		northPanel0.add(value);
		northPanel0.add(calcHavingCPerB);
		northPanel0.add(calcHavingSNRtodB);
		northPanel0.add(sortbtn);
		
		northPanel.add(northPanel0);
		
	}
	
	public void makenorthPanel1()
	{
		northPanel1 = new JPanel();
		northPanel1.setBackground(Color.cyan);
		GUI.setPadding(northPanel1);
		
		instruction1 = new JLabel("Δώσε διάστημα υπολογισμού: από-έως-βήμα");
		instruction1.setFont(GUI.getFont());
		value1_1 = new JTextField(5);
		value1_1.setText("1");
		value1_1.setFont(GUI.getFont());
		value1_2 = new JTextField(5);
		value1_2.setText("20");
		value1_2.setFont(GUI.getFont());
		value1_3 = new JTextField(5);
		value1_3.setText("1");
		value1_3.setFont(GUI.getFont());
		
		calcHavingCPerB1 = new JButton("Έδωσα φασματική");
		calcHavingCPerB1.setFont(GUI.getFont());
		calcHavingCPerB1Listener calcHavingCPerB1listener = new calcHavingCPerB1Listener();
		calcHavingCPerB1.addActionListener(calcHavingCPerB1listener);
		
		calcHavingSNRtodB1 = new JButton("Έδωσα SNR σε dB");
		calcHavingSNRtodB1.setFont(GUI.getFont());
		calcHavingSNRtodB1Listener calcHavingSNRtodB1listener = new calcHavingSNRtodB1Listener();
		calcHavingSNRtodB1.addActionListener(calcHavingSNRtodB1listener);
		
		northPanel1.add(instruction1);
		northPanel1.add(value1_1);
		northPanel1.add(value1_2);
		northPanel1.add(value1_3);
		northPanel1.add(calcHavingCPerB1);
		northPanel1.add(calcHavingSNRtodB1);
		
		northPanel.add(northPanel1);
	}
	
	public void makeCentralPanel()
	{
		centralPanel = new JPanel(new GridLayout(1,2,10,10));
		GUI.setPadding(centralPanel);
		centralPanel.setBackground(Color.DARK_GRAY);
		
		calcHavingCPerBResults = new JTextArea();
		calcHavingCPerBResults.append(this.table_having_the_capacityPerBandwidth.getOrder() + "\n");
		calcHavingCPerBResults.setFont(GUI.getFont());
		GUI.setPaddingAtJTextArea(calcHavingCPerBResults);
		calcHavingCPerBResultsPane = new JScrollPane(calcHavingCPerBResults);
		
		calcHavingSNRtodBresults = new JTextArea();
		calcHavingSNRtodBresults.append(this.table_having_the_SNRtodB.getOrder() + "\n");
		calcHavingSNRtodBresults.setFont(GUI.getFont());
		GUI.setPaddingAtJTextArea(calcHavingSNRtodBresults);
		calcHavingSNRtodBresultsPane = new JScrollPane(calcHavingSNRtodBresults);
		
		centralPanel.add(calcHavingCPerBResultsPane);
		centralPanel.add(calcHavingSNRtodBresultsPane);
		
		mainPanel.add(centralPanel,BorderLayout.CENTER);
	}
	
	public void makeSouthPanel()
	{
		southPanel = new JPanel();
		southPanel.setBackground(Color.red);
		GUI.setPadding(southPanel);
		
		calcHavingCPerBResultsVisualize0 = new JButton("Διαγράμματα");
		calcHavingCPerBResultsVisualize0.setFont(GUI.getFont());
		calcHavingCPerBResultsVisualize0Listener calcHavingCPerBResultsVisualize0listener = new calcHavingCPerBResultsVisualize0Listener();
		calcHavingCPerBResultsVisualize0.addActionListener(calcHavingCPerBResultsVisualize0listener);
		
		calcHavingCPerBResultsVisualize = new JButton("Ιστογράμματα έχοντας φασματική");
		calcHavingCPerBResultsVisualize.setFont(GUI.getFont());
		calcHavingCPerBResultsVisualizeListener calcHavingCPerBResultsVisualizelistener = new calcHavingCPerBResultsVisualizeListener();
		calcHavingCPerBResultsVisualize.addActionListener(calcHavingCPerBResultsVisualizelistener);
		
		calcHavingSNRtodBresultsVisualize = new JButton("Ιστογράμματα έχοντας SNR σε dB");
		calcHavingSNRtodBresultsVisualize.setFont(GUI.getFont());
		calcHavingSNRtodBresultsVisualizeListener calcHavingSNRtodBresultsVisualizelistener = new calcHavingSNRtodBresultsVisualizeListener();
		calcHavingSNRtodBresultsVisualize.addActionListener(calcHavingSNRtodBresultsVisualizelistener);
		
		calcHavingSNRtodBresultsVisualize0 = new JButton("Διαγράμματα");
		calcHavingSNRtodBresultsVisualize0.setFont(GUI.getFont());
		calcHavingSNRtodBresultsVisualize0Listener calcHavingSNRtodBresultsVisualize0listener = new calcHavingSNRtodBresultsVisualize0Listener();
		calcHavingSNRtodBresultsVisualize0.addActionListener(calcHavingSNRtodBresultsVisualize0listener);
		
		southPanel.add(calcHavingCPerBResultsVisualize0);
		southPanel.add(calcHavingCPerBResultsVisualize);
		southPanel.add(calcHavingSNRtodBresultsVisualize);
		southPanel.add(calcHavingSNRtodBresultsVisualize0);
		
		mainPanel.add(southPanel,BorderLayout.SOUTH);
	}
	
	class calcHavingCPerB1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			int initialCPerB = Integer.parseInt(value1_1.getText());
			int finalCPerB = Integer.parseInt(value1_2.getText());
			int step = Integer.parseInt(value1_3.getText());
			int currentCPerB=initialCPerB;
			while(currentCPerB<=finalCPerB)
			{
				Row_having_the_capacityPerBandwidth row = new Row_having_the_capacityPerBandwidth(currentCPerB);
				table_having_the_capacityPerBandwidth.addRow(row);
				String rowData = row.getRowData();
				calcHavingCPerBResults.append(rowData);
				
				currentCPerB+=step;
			}
		}		
	}
	
	class calcHavingSNRtodB1Listener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			int initialSNRtodB = Integer.parseInt(value1_1.getText());
			int finalSNRtodB = Integer.parseInt(value1_2.getText());
			int step = Integer.parseInt(value1_3.getText());
			int currentSNRtodB=initialSNRtodB;
			while(currentSNRtodB<=finalSNRtodB)
			{
				Row_having_the_SNRtodB row = new Row_having_the_SNRtodB(currentSNRtodB);
				table_having_the_SNRtodB.addRow(row);
				String rowData = row.getRowData();
				calcHavingSNRtodBresults.append(rowData);
				
				currentSNRtodB+=step;
			}
		}	
	}
	
	class calcHavingSNRtodBresultsVisualizeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			//new LineChartExample("Line Chart Example");  
			(new Diagramm2_1(table_having_the_SNRtodB)).setLocation(30, 350);
			(new Diagramm2_2(table_having_the_SNRtodB)).setLocation(540, 350);
			(new Diagramm2_3(table_having_the_SNRtodB)).setLocation(1050, 350);
			
			(new Diagramm2_1_(table_having_the_SNRtodB)).setLocation(30, 300);
			(new Diagramm2_2_(table_having_the_SNRtodB)).setLocation(540, 300);
			(new Diagramm2_3_(table_having_the_SNRtodB)).setLocation(1050, 300);
		}		
	}
	
	class calcHavingCPerBResultsVisualizeListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			//new Diagramm_test();
			(new Diagramm1_1(table_having_the_capacityPerBandwidth)).setLocation(20, 300);
			(new Diagramm1_2(table_having_the_capacityPerBandwidth)).setLocation(530, 300);
			(new Diagramm1_3(table_having_the_capacityPerBandwidth)).setLocation(1040, 300);
			
			(new Diagramm1_1_(table_having_the_capacityPerBandwidth)).setLocation(20, 350);
			(new Diagramm1_2_(table_having_the_capacityPerBandwidth)).setLocation(530, 350);
			(new Diagramm1_3_(table_having_the_capacityPerBandwidth)).setLocation(1040, 350);
		}		
	}
	
	class calcHavingSNRtodBresultsVisualize0Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			(new Diagramm2_1line(table_having_the_SNRtodB)).setLocation(30, 350);
			(new Diagramm2_2line(table_having_the_SNRtodB)).setLocation(540, 350);
			(new Diagramm2_3line(table_having_the_SNRtodB)).setLocation(1050, 350);
			(new Diagramm2_1_line(table_having_the_SNRtodB)).setLocation(30, 300);
			(new Diagramm2_2_line(table_having_the_SNRtodB)).setLocation(540, 300);
			(new Diagramm2_3_line(table_having_the_SNRtodB)).setLocation(1050, 300);
		}		
	}
	
	class calcHavingCPerBResultsVisualize0Listener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {

			(new Diagramm1_1line(table_having_the_capacityPerBandwidth)).setLocation(20, 300);
			(new Diagramm1_2line(table_having_the_capacityPerBandwidth)).setLocation(530, 300);
			(new Diagramm1_3line(table_having_the_capacityPerBandwidth)).setLocation(1040, 300);
			
			(new Diagramm1_1_line(table_having_the_capacityPerBandwidth)).setLocation(20, 350);;
			(new Diagramm1_2_line(table_having_the_capacityPerBandwidth)).setLocation(530, 350);
			(new Diagramm1_3_line(table_having_the_capacityPerBandwidth)).setLocation(1040, 350);
		}		
	}
	
	class calcHavingCPerBListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			double CPerB = Double.parseDouble(value.getText());
			Row_having_the_capacityPerBandwidth row = new Row_having_the_capacityPerBandwidth(CPerB);
			table_having_the_capacityPerBandwidth.addRow(row);
			String rowData = row.getRowData();
			calcHavingCPerBResults.append(rowData);
		}	
	}

	class calcHavingSNRtodBListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			double SNRtodB = Double.parseDouble(value.getText());
			Row_having_the_SNRtodB row = new Row_having_the_SNRtodB(SNRtodB);
			table_having_the_SNRtodB.addRow(row);
			String rowData = row.getRowData();
			calcHavingSNRtodBresults.append(rowData);
		}	
	}
	
	class sortbtnListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			Collection<Row_having_the_capacityPerBandwidth> set = new TreeSet<Row_having_the_capacityPerBandwidth>();
			
			ArrayList<Row_having_the_capacityPerBandwidth> list1 = table_having_the_capacityPerBandwidth.getTable_having_the_capacityPerBandwidth();
			Collections.sort(list1);
			calcHavingCPerBResults.setText("");
			calcHavingCPerBResults.append(table_having_the_capacityPerBandwidth.getOrder() + "\n");
			for(Row_having_the_capacityPerBandwidth r : list1)
			{
				calcHavingCPerBResults.append(r.getRowData());
			}
		
			ArrayList<Row_having_the_SNRtodB> list2 = table_having_the_SNRtodB.getTable_having_the_SNRtodB();
			Collections.sort(list2);
			calcHavingSNRtodBresults.setText("");
			calcHavingSNRtodBresults.append(table_having_the_SNRtodB.getOrder() + "\n");
			for(Row_having_the_SNRtodB r : list2)
			{
				calcHavingSNRtodBresults.append(r.getRowData());
			}
		}	
	}
}
