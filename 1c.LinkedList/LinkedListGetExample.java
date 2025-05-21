/* 1c. Linked List Programs
 * 4. Write a Java program to display elements and their positions in a linked list ( using 
l_listobj.get(p) )*/

package LinkedListGet;
import java.util.*;
public class LinkedListGetExample {
	public static void main(String[] args) {
        LinkedList<String> ls = new LinkedList<>();
        ls.add("Orange");
        ls.add("Green");
        ls.add("Pink");
        ls.add("Red");
        ls.add("Blue");

        System.out.println("Elements and their positions in the LinkedList:");
        for (int i = 0; i < ls.size(); i++) {
            System.out.println("Index: " + i + " | Value: " + ls.get(i));
        }
    }
}

