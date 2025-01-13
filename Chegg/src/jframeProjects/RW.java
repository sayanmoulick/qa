package jframeProjects;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RW {
	private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JLabel msglabel;

	   public RW(){
	      prepareGUI();
	   }
	   public static void main(String[] args){
	      RW swingLayoutDemo = new RW();  
	      swingLayoutDemo.showFlowLayoutDemo();       
	   }
	   private void prepareGUI(){
	      mainFrame = new JFrame("Rotate Words");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      statusLabel = new JLabel("",JLabel.CENTER);        
	      statusLabel.setSize(350,450);
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());
	      
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	   private void showFlowLayoutDemo(){
	      JPanel panel = new JPanel();
	      JPanel panel1 = new JPanel();
	      panel.setBackground(Color.green);
	      panel.setSize(200,200);
	      FlowLayout layout = new FlowLayout();
//	      layout.setHgap(10);              
//	      layout.setVgap(30);
	      JLabel l1 =  new JLabel("W");
	      l1.setBackground(Color.green);
	      JLabel l2 =  new JLabel("O");
	      l2.setBackground(Color.green);
	      JLabel l3 =  new JLabel("R");
	      l3.setBackground(Color.green);
	      JLabel l4 =  new JLabel("D");
	      l4.setBackground(Color.green);
	      panel.setLayout(layout); 
	      panel.setPreferredSize(new Dimension(600, 50));
	      panel.add(l1);
	      panel.add(l2); 
	      panel.add(l3);
	      panel.add(l4);
	      controlPanel.add(panel);
	      panel1.setLayout(layout);
//	      panel1.setPreferredSize(new Dimension(700, 100));
	      String[] items = new String[]{"WORD", "STOP", "HELP", "JAVA", "IOWA"};
          JComboBox<String> comboBox = new JComboBox<>(items);
	      panel1.add(comboBox);
	      panel1.add(new JCheckBox("Left"));
	      panel1.add(new JCheckBox("Right"));
	      panel1.add(new JButton("Rotate"));
	      controlPanel.add(panel1);
	      mainFrame.setVisible(true);  
	   }
}
