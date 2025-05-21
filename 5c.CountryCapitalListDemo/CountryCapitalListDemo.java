/*5c. Develop a Swing program in Java to add the countries  USA,  India,  Vietnam,  Canada,  
Denmark, France,   Great Britain, Japan,   Africa, Greenland,  Singapore into a JList  and 
display the capital of the countries on console  whenever the countries are selected on the list. */

package SwingAdvanced;

import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CountryCapitalListDemo extends JFrame {

    private JList<String> countryList;
    private Map<String, String> countryCapitalMap;

    public CountryCapitalListDemo() {

        // Map countries to their capitals
        countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("USA", "Washington, D.C.");
        countryCapitalMap.put("India", "New Delhi");
        countryCapitalMap.put("Vietnam", "Hanoi");
        countryCapitalMap.put("Canada", "Ottawa");
        countryCapitalMap.put("Denmark", "Copenhagen");
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Great Britain", "London");
        countryCapitalMap.put("Japan", "Tokyo");
        countryCapitalMap.put("Africa", "Pretoria"); 
        countryCapitalMap.put("Greenland", "Nuuk");
        countryCapitalMap.put("Singapore", "Singapore");

        // Create the model and add country names
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String country : countryCapitalMap.keySet()) {
            listModel.addElement(country);
        }

        // Create JList with countries
        countryList = new JList<>(listModel);

        // Add selection listener to display capital on console
        countryList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String selectedCountry = countryList.getSelectedValue();
                    if (selectedCountry != null) {
                        String capital = countryCapitalMap.get(selectedCountry);
                        System.out.println("Capital of " + selectedCountry + " is " + capital);
                    }
                }
            }
        });

        // Add list in scroll pane
        add(new JScrollPane(countryList));

        // Frame settings
        setTitle("Country-Capital JList");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryCapitalListDemo();
    }
}
