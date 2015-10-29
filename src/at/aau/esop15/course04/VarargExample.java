package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 13:00.
 */
public class VarargExample {
    public static void main(String[] args) {
        printList("one", "two", "three");
    }

    public static void printList(String... list) {
        System.out.println("list[0] = " + list[0]);
        System.out.println("list[1] = " + list[1]);
        System.out.println("list[2] = " + list[2]);
    }
}

