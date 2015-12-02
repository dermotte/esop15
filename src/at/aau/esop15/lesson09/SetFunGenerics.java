package at.aau.esop15.lesson09;

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

        setOne = new TreeSet<String>();
        setTwo = new HashSet<String>();

        setOne.add("apples");
        setOne.add("peaches");
        setOne.add("strawberries");

        setTwo.add("strawberries");
        setTwo.add("pears");
        setTwo.add("mango");

        // union of sets:
        Set<String> union = (Set<String>) ((TreeSet) setOne).clone(); // clone the set, so that setOne can be re-used later on ...
        union.addAll(setTwo);
        // print results:
        System.out.print("union = { ");
        for (String anUnion : (Iterable<String>) union) {
            System.out.print(anUnion + " ");
        }
        System.out.print("}\n");

        // intersection
        Set<String> intersection = (Set<String>) ((TreeSet) setOne).clone(); // clone the set, so that setOne can be re-used later on ...
        setOne.removeAll(setTwo);
        intersection.removeAll(setOne);
        // print results:
        System.out.print("intersection = { ");
        for (String elem : intersection) {
            System.out.print(elem + " ");
        }
        System.out.print("}\n");
    }
}
