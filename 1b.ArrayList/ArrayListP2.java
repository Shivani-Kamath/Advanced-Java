/* 1b.  Array List programs  
   2. Write a java program for getting different colors through ArrayList interface and remove the 
   2nd element and color "Blue" from the ArrayList */
package AdvancedJava;
import java.util.*;
public class ArrayListP2 {
	public static void main(String[] args) {
		List<String> ls = new ArrayList<>();
		ls.add("Orange");
		ls.add("Green");
		ls.add("Pink");
		ls.add("Red");
		ls.add("Blue");
		System.out.println(ls);
		ls.remove(2);
		System.out.println(ls);
		ls.remove("Blue");
		System.out.println(ls);
		}

	}
