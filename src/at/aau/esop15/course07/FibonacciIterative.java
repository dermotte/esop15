package at.aau.esop15.course07;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 19.11.2015 14:18.
 */
public class FibonacciIterative {
    static int countCalls = 0;

    public static void main(String[] args) {
        int max = 42;
        int f1, f2, tmp;
        f1 = 1;
        f2 = 1;
        for (int i=3; i <= max; i++ ) {
            tmp = f1 + f2;
            f1 = f2;
            f2 = tmp;
        }
        System.out.println("f2 = " + f2);
    }
}
