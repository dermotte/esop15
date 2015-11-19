package at.aau.esop15.course07;

import java.io.Serializable;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 19.11.2015 14:18.
 */
public class Fibonacci {
    static int countCalls = 0;

    public static int get(int number) {
        countCalls++;
        if (number <= 2)
            return 1;
        return get(number-1) + get(number-2);
    }

    public static void main(String[] args) {
        System.out.println(get(42));
        System.out.println("# of calls = " + countCalls);
    }

}
