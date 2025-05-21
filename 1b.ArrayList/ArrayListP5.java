/* 1b.  Array List programs
    5. Write a java program for getting different colors through ArrayList interface and delete nth  
    element from the ArrayList object  by  using remove by index*/

package AdvancedJava;
import java.util.*;
public class ArrayListP5 {
	public static void main(String[] args) {
        List<String> ls = new ArrayList<>();
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Original List: " + ls);

        int n = 2;

        if (n >= 0 && n < ls.size()) {
            String removedColor = ls.remove(n);
            System.out.println("Removed element at index " + n + ": " + removedColor);
        } else {
            System.out.println("Invalid index: " + n);
        }

        System.out.println("Updated List: " + ls);
    }
}