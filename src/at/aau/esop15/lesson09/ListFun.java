package at.aau.esop15.lesson09;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 02.12.2015.
 */
public class ListFun {
    public static void main(String[] args) {
        LinkedList<String> myNames = new LinkedList<String>();

        // adding random names to a list:
        FirstNameListBuilder f = new FirstNameListBuilder(new File("data\\yob2000.txt"));
        f.read();
        String[] names = f.getNames();
        for (int i = 0; i < 10 ; i++) {
            myNames.add(names[(int) Math.floor(Math.random() * names.length)]);
        }

        // getting the List printed
        System.out.println("** as is");
        printElements(myNames.iterator());


        // now sort the list:
        Collections.sort(myNames);
        System.out.println("** sorted");
        printElements(myNames.iterator());

        // now with a custom Comparator:
        Collections.sort(myNames, new MyComparator());
        System.out.println("** custom comparator");
        printElements(myNames.iterator());

        // now shuffle it
        Collections.shuffle(myNames);
        System.out.println("** shuffled");
        printElements(myNames.iterator());

        // remove Justin Bieber if he slipped in ...
        myNames.remove("Justin");
        System.out.println("** Justin removed");
        printElements(myNames.iterator());
    }

    public static void printElements(Iterator<String> iterator) {
        System.out.print("Contents of the List: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext()) System.out.print(", ");
        }
        System.out.println();
    }

    private static class MyComparator implements java.util.Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return -((String) o1).compareTo((String) o2);
        }
    }
}
