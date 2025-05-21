/* 5a. Develop a Swing program in Java to add the countries  USA,  India,  Vietnam,  Canada,
 Denmark, France,   Great Britain, Japan,   Africa, Greenland,  Singapore into a JList  and
 display them on console  whenever the countries are selected on the list. */

package SwingAdvanced;

import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;

public class JListExample extends JFrame {

    private final JList<String> countryList;

    public JListExample() {

        // Create the model and add elements
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("USA");
        listModel.addElement("India");
        listModel.addElement("Vietnam");
        listModel.addElement("Canada");
        listModel.addElement("Denmark");
        listModel.addElement("France");
        listModel.addElement("Great Britain");
        listModel.addElement("Japan");
        listModel.addElement("Africa");
        listModel.addElement("Greenland");
        listModel.addElement("Singapore");

        // Create the list and register a selection listener
        countryList = new JList<>(listModel);
        countryList.addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                List<String> selected = countryList.getSelectedValuesList();
                System.out.println(selected);
            }
        });

        add(new JScrollPane(countryList));

        // Frame setup
        setTitle("Country Selector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 240);          
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public static void main(String[] args) {
        new JListExample();
    }
}