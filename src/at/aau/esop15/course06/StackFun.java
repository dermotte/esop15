package at.aau.esop15.course06;

/**
 * Created by mlux_2 on 20.11.2014.
 */
public class StackFun {
    public static void main(String[] args) {
        Stack s = new Stack();
        for (int i = 0; i<100 ; i++) {
            s.push(100+i);
        }
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
    }
}
