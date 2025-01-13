package jframeProjects;

import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
  
class Example extends JFrame { 
    // Declaration of objects of JLabel class. 
    JLabel l1, l2, l3, l4, l5; 
  
    // Constructor of Example class. 
    public Example() 
    { 
        // Creating Object of "FlowLayout" class 
        FlowLayout layout = new FlowLayout(); 
  
        // this Keyword refers to current object. 
        // Function to set Layout of JFrame. 
        this.setLayout(layout); 
  
        // Initialization of object "l1" of JLabel class. 
        l1 = new JLabel("Label 1  "); 
        l1.setOpaque(true);
        l1.setBackground(Color.green);
  
        // Initialization of object "l2" of JLabel class. 
        l2 = new JLabel("Label 2  "); 
        l2.setOpaque(true);
        l2.setBackground(Color.green);
  
        // Initialization of object "l3" of JLabel class. 
        l3 = new JLabel("Label 3  "); 
        l3.setOpaque(true);
        l3.setBackground(Color.green);
  
        // Initialization of object "l4" of JLabel class. 
        l4 = new JLabel("Label 4  "); 
        l4.setOpaque(true);
        l4.setBackground(Color.green);
  
        // this Keyword refers to current object. 
        // Adding Jlabel "l1" on JFrame. 
        this.add(l1); 
  
        // Adding Jlabel "l2" on JFrame. 
        this.add(l2); 
  
        // Adding Jlabel "l3" on JFrame. 
        this.add(l3); 
  
        // Adding Jlabel "l4" on JFrame. 
        this.add(l4); 
        
        String[] items = new String[]{"Rock", "Paper", "Scissors"};
        JComboBox<String> comboBox = new JComboBox<>(items);
        
        this.add(comboBox);
 
    } 
} 
  
class WordRotation { 
    // Driver code 
    public static void main(String[] args) 
    { 
        // Creating Object of Example class. 
        Example f = new Example(); 
  
        // Function to set title of JFrame. 
        f.setTitle("Example of FlowLayout"); 
  
        // Function to set Bounds of JFrame. 
        f.setBounds(200, 100, 600, 400); 
  
        // Function to set visible status of JFrame. 
        f.setVisible(true); 
    } 
} 

