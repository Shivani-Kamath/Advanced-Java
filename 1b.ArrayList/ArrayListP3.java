/*  1b.  Array List programs
    3. Write a java program for getting different colors through ArrayList interface and  sort them 
using Collections.sort( ArrayListObj)*/

package AdvancedJava;
import java.util.*;
public class ArrayListP3 {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("Orange");
        colors.add("Green");
        colors.add("Pink");
        colors.add("Red");
        colors.add("Blue");

        System.out.println("Before sorting:");
        System.out.println(colors);

        Collections.sort(colors);

        System.out.println("After sorting:");
        System.out.println(colors);
    }
}

