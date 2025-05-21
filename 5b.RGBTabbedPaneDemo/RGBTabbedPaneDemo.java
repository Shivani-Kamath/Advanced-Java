/*5b.  Develop a Swing program in Java to create a  Tabbed Pan of RED, BLUE and GREEN and 
display the concerned color  whenever the specific tab is selected in the Pan. */

package SwingAdvanced;

import java.awt.Color;
import javax.swing.*;

public class RGBTabbedPaneDemo {

    public RGBTabbedPaneDemo() {

        JFrame frame = new JFrame("Color Tabs");

        // Create three panels, each with a different background color
        JPanel bluePanel  = new JPanel();
        JPanel redPanel   = new JPanel();
        JPanel greenPanel = new JPanel();

        bluePanel.setBackground(Color.BLUE);
        redPanel.setBackground(Color.RED);
        greenPanel.setBackground(Color.GREEN);

        // Create tabbed pane and add panels as tabs
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(20, 20, 300, 250);  

        tabbedPane.addTab("BLUE",  bluePanel);
        tabbedPane.addTab("RED",   redPanel);
        tabbedPane.addTab("GREEN", greenPanel);

        // Frame setup
        frame.add(tabbedPane);
        frame.setSize(350, 320);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new RGBTabbedPaneDemo();
    }
}
