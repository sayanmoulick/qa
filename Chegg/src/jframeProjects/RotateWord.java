package jframeProjects;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

import javax.swing.BoxLayout;
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  

public class RotateWord extends Frame{
	Button buttons[];  
	  
	 public RotateWord() {  
	   buttons = new Button [5];  
	    
	   for (int i = 0;i<5;i++) {  
	      buttons[i] = new Button ("Button " + (i + 1)); 
	      buttons[i].setBackground(Color.green);
	      add (buttons[i]);  
	    }  
	  
	setLayout (new BoxLayout(this, BoxLayout.X_AXIS));  
	setSize(400,400);  
	setVisible(true);  
	}  
	public static void main(String args[]) {  
		RotateWord b=new RotateWord(); 
    } 
}
