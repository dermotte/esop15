package at.aau.esop15.course09;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 03.12.2015 15:08.
 */
public class HashMapExample {
    public static void main(String[] args) {
        HashMap<String, LinkedList<String>> data;
        data = new HashMap<>(30);

        LinkedList<String> justinCourses = new LinkedList<>();
        data.put("Justin", justinCourses);
        justinCourses.add("ESOP");
        justinCourses.add("Einführung in die Informatik");
        justinCourses.add("Dance 101");

        justinCourses = new LinkedList<>();
        justinCourses.add("ESOP");
        data.put("Selena", justinCourses);

        System.out.println();
    }
}
