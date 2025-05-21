/* 1c. Linked List Programs
 *  3. Write a Java program to insert the specified element at the end of a linked list.( using 
l_listobj.offerLast("Pink"))*/

package AdvancedJava;
import java.util.*;
public class LinkedListP3 {
	public static void main(String[] args) {
        // Creating a LinkedList
        LinkedList<String> ls = new LinkedList<>();
        ls.add("Orange");
        ls.add("Green");  
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Before inserting at last: " + ls);

        // Insert element at the end using offerLast()
        ls.offerLast("Pink");

        System.out.println("After inserting 'Pink' at last: " + ls);
    }
}
