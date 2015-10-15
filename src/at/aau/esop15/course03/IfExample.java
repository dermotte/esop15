package at.aau.esop15.course03;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 15.10.2015 13:39.
 */
public class IfExample {
    public static void main(String[] args) {
        // find maximum
        int x = 12, y = 7;
        int maximum = -1;
        int minimum = -1;
        if (x > y)
            maximum = x;
        else
            maximum = y;

        // output
        System.out.println("maximum = " + maximum);

        // dangling else
        int a=0, b=1;
        if (a > b) {
            if (a != 0)
                a++;
            else
                b++;
        }
    }
}
