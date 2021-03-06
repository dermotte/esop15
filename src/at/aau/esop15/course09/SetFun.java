package at.aau.esop15.course09;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 02.12.2015.
 */
public class SetFun {
    public static void main(String[] args) {
        HashSet setOne, setTwo;

        setOne = new HashSet();
        setTwo = new HashSet();

        setOne.add("apples");
        setOne.add("peaches");
        setOne.add("strawberries");

        setTwo.add("strawberries");
        setTwo.add("pears");
        setTwo.add("mangos");

        // union of sets:
        Set union = (Set) setOne.clone(); // clone the set, so that setOne can be re-used later on ...
        union.addAll(setTwo);
        // print results:
        System.out.print("union = { ");
        for (Object elem : union) {
            System.out.print((String) elem + " ");
        }
        System.out.print("}\n");

        // intersection
        Set intersection = (Set) setOne.clone(); // clone the set, so that setOne can be re-used later on ...
        setOne.removeAll(setTwo);
        intersection.removeAll(setOne);
        // print results:
        System.out.print("intersection = { ");
        for (Object elem : intersection) {
            System.out.print((String) elem + " ");
        }
        System.out.print("}\n");
    }
}
