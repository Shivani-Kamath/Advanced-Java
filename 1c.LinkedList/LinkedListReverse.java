/* 1c. Linked List Programs
 *  2. Write a Java program to iterate a linked list in reverse order (using 
objlist.descendingIterator())*/

package LinkedList;
import java.util.*;
public class LinkedListReverse {
	    public static void main(String[] args) {
	        // Creating a LinkedList with color names
	        LinkedList<String> ls = new LinkedList<>();
	        ls.add("Orange");
	        ls.add("Green");  
	        ls.add("Pink");
	        ls.add("Red");
	        ls.add("Blue");

	        System.out.println("Iterating in reverse order:");

	        // Using descendingIterator() to iterate in reverse
	        Iterator<String> iterator = ls.descendingIterator();
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	        }
	    }
	}
