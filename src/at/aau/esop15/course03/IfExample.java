package at.aau.esop15.course03;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 15.10.2015 13:39.
 */
public class IfExample {
    public static void main(String[] args) {
        // find maximum
        int x = 12, y =42;
        int maximum = -1;
        if (x > y) {
            maximum = x;
        }
        if (y >= x) {
            maximum = y;
        }
        // output
        System.out.println("maximum = " + maximum);
    }
}
