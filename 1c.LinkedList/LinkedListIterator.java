/*1c. Linked List Programs
  1. Write a Java program to iterate through all elements in a linked list starting at the 
specified position ( 2nd) using iterator ( hint : Iterator iteratorobj = listobj.listIterator(1))*/

package LinkedList;
import java.util.*;
public class LinkedListIterator {
	public static void main(String[] args) {
        List<String> ls = new LinkedList<>();
        ls.add("Orange");
        ls.add("Green"); 
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Iterating from 2nd position (index 1):");

        Iterator<String> iterator = ls.listIterator(1);  
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
