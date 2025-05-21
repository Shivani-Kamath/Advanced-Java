/* 4a. Basic hello program of Swing displaying the message Hello! VI C , Welcome to Swing 
Programming in Blue color plain font with font size of  32  using Jframe and Jlabel*/

package Swings;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

class SwingExample {
    SwingExample() {
    	//Create a new JFrame container.
        JFrame jfrm = new JFrame("Swing Example");
        jfrm.setSize(800, 150);                    
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setLayout(null);                      

        //Create a text-based label.
        JLabel jlab = new JLabel("Hello! VI C, Welcome to Swing Programming");
        jlab.setFont(new Font("Verdana", Font.PLAIN, 32));
        jlab.setForeground(Color.BLUE);
        jlab.setBounds(20, 30, 760, 60);           
        jlab.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Add the label to the content pane.
        jfrm.add(jlab);
        jfrm.setLocationRelativeTo(null); 
        
        //Display the frame.
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {
    	//Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingExample();
            }
        });
    }
}
