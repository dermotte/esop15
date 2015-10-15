package at.aau.esop15.course03;

import at.aau.esop15.book.In;
import at.aau.esop15.book.Out;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 15.10.2015 13:34.
 */
public class WhileInExample {
    public static void main(String[] args) {
        int sum=0, x = 0;
        while (In.done()) {
            sum = sum + x;
            if (sum > 1000) {
                Out.println("zu gross");
                break;
            }
            x = In.readInt();
        }

    }
}
