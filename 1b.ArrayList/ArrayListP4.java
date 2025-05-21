/* 1b. Array List programs
   4.Write a java program for getting different colors through ArrayList interface and extract the 
elements 1st and 2nd from the ArrayList object  by  using SubList() */

package AdvancedJava;
import java.util.*;

public class ArrayListP4 {
	public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Orange");
        colors.add("Green");
        colors.add("Pink");
        colors.add("Red");
        colors.add("Blue");

        System.out.println("Full color list:");
        System.out.println(colors);

        System.out.println("Extracting 1st and 2nd elements using subList():");
        System.out.println(colors.subList(0, 2));
    }
}
