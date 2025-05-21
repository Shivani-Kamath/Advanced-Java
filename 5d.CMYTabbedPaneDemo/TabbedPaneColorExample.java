/*5d.  Develop a Swing program in Java to create a  Tabbed Pan of Cyan, Magenta and Yellow and 
display the concerned color  whenever the specific tab is selected in the Pan*/

package SwingAdvanced;

import java.awt.Color;
import javax.swing.*;

public class TabbedPaneColorExample {

    JFrame f;

    TabbedPaneColorExample() {
        f = new JFrame();

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        p1.setBackground(Color.CYAN);
        p2.setBackground(Color.MAGENTA);
        p3.setBackground(Color.YELLOW);

        // Create a tabbed pane and add tabs
        JTabbedPane tp = new JTabbedPane();
        tp.setBounds(50, 50, 300, 300);

        tp.add("Cyan", p1);
        tp.add("Magenta", p2);
        tp.add("Yellow", p3);

        // Add the tabbed pane to the frame
        f.add(tp);

        // Frame settings
        f.setSize(400, 400);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new TabbedPaneColorExample();
    }
}