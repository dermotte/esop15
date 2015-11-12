package at.aau.esop15.course06;

/**
 * @author Dr. Mathias Lux, 12.11.2015.
 */
public class ListTest {
    public static void main(String[] args) {
        List l = new List();
        l.append(3);
        l.append(5);
        for (int i = 0; i < 100; i++) {
            l.append(100 + i);
        }
        System.out.println("l.indexOf(100) = " + l.indexOf(100));
        System.out.println("l.size() = " + l.size());
    }
}
