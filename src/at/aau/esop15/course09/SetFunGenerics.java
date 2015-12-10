package at.aau.esop15.course09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 02.12.2015.
 */
public class SetFunGenerics {
    public static void main(String[] args) {
        Set<String> setOne, setTwo;

        setOne = new TreeSet<>();
        setTwo = new HashSet<String>();

        setOne.add("apples");
        setOne.add("peaches");
        setOne.add("strawberries");

        setTwo.add("strawberries");
        setTwo.add("pears");
        setTwo.add("mango");

        // union of sets:
        Set<String> union = new TreeSet<>();
        union.addAll(setOne);
        union.addAll(setTwo);
        // print results:
        System.out.print("union = { ");
        for (String element : union) {
            System.out.print(element + " ");
        }
        System.out.print("}\n");

        // intersection
        Set<String> intersection = new TreeSet<>(); // clone the set, so that setOne can be re-used later on ...
        intersection.addAll(setOne);
        setOne.removeAll(setTwo);
        intersection.removeAll(setOne);
        // print results:
        System.out.print("intersection = { ");
        Iterator<String> it = intersection.iterator();
        while (it.hasNext())
            System.out.println(it.next() + " ");
        System.out.print("}\n");
    }
}
