/*  1b.  Array List programs
    3. Write a java program for getting different colors through ArrayList interface and  sort them 
using Collections.sort( ArrayListObj)*/

package ArrayList;
import java.util.*;
public class SortColorsArrayList {
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

