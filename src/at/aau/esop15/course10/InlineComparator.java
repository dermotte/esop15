package at.aau.esop15.course10;

import at.aau.esop15.course09.FirstNameListBuilder;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class InlineComparator {
    public static void main(String[] args) {
        LinkedList<String> myNames = new LinkedList<String>();

        // adding random names to a list:
        FirstNameListBuilder f = new FirstNameListBuilder(new File("data\\yob2000.txt"));
        f.read();
        String[] names = f.getNames();
        for (int i = 0; i < 10 ; i++) {
            myNames.add(names[(int) Math.floor(Math.random() * names.length)]);
        }

        // todo: change to lambda
        Collections.sort(myNames, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        // todo: change to lamda
        myNames.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }

}
