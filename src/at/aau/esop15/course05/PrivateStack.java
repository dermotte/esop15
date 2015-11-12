package at.aau.esop15.course05;

import at.aau.esop15.course06.*;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 12.11.2015 14:42.
 */
public class PrivateStack {
    public static void main(String[] args) {
        Stack s = new Stack(10);
        s.push(3);
        s.push(5);
        s.top = -42;
        int x = s.pop() - s.pop();
        System.out.println("x = " + x);
    }
}
