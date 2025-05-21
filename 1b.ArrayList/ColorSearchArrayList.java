/* 1b.  Array List programs
 1. Write a java program for getting different colors through ArrayList interface and search whether
 the color "Red" is available or not */

package ArrayList;
import java.util.*;

public class ColorSearchArrayList {
	public static void main(String[] args) {
		
		List<String> ls = new ArrayList<>();
		ls.add("Orange");
		ls.add("Green");
		ls.add("Blue");
		ls.add("Red");
		System.out.println(ls);
		if(ls.contains("Red")) {
			System.out.println("available");
		}else {
			System.out.println("not available");
		}
	}
}
