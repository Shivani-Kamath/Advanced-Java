/* 4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour
 Glass  is pressed” depending upon the Jbutton with image  either  Digital Clock or  Hour Glass is
 pressed by implementing the event handling mechanism with addActionListener( ).
 */

package Swings;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonExampleWithImages {
    JLabel l1;

    ButtonExampleWithImages() {
        JFrame f = new JFrame("Button Example");

        l1 = new JLabel();
        l1.setBounds(50, 50, 700, 100);
        l1.setFont(new Font("Lucida Calligraphy", Font.BOLD, 40));

        // Load images from disk
        ImageIcon digitalClockIconOriginal = new ImageIcon("C:\\Users\\shiva\\OneDrive\\Desktop\\digital_clock.png");
        ImageIcon hourGlassIconOriginal = new ImageIcon("C:\\Users\\shiva\\OneDrive\\Desktop\\hour_glass.png");

        // Resize images to fit the button size (say 80x80)
        Image digitalClockImg = digitalClockIconOriginal.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        Image hourGlassImg = hourGlassIconOriginal.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);

        // Create new ImageIcons with the resized images
        ImageIcon digitalClockIcon = new ImageIcon(digitalClockImg);
        ImageIcon hourGlassIcon = new ImageIcon(hourGlassImg);

        JButton b1 = new JButton("Digital Clock", digitalClockIcon);
        JButton b2 = new JButton("Hour Glass", hourGlassIcon);

        b1.setBounds(100, 200, 250, 100);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        b2.setBounds(400, 200, 250, 100);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        f.add(b1);
        f.add(b2);
        f.add(l1);

        f.setSize(800, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ButtonExampleWithImages();
    }
}
