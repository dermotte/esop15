package at.aau.esop15.course05;

/**
 * Created by mlux on 14.01.2016.
 */
public class CallReferenceValue {
    public static void main(String[] args) {
        int x = 0;
        foo(x);
        System.out.println("x = " + x);
        int[] y = {0};
        bar(y);
        System.out.println("y = " + y[0]);
    }

    public static void foo(int i) {
        i = 10;
    }

    public static void bar(int[] i) {
        i[0] = 10;
    }
}
