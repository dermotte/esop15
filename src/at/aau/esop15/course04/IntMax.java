package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 14:26.
 */
public class IntMax {
    public static void main(String[] args) {
        int i = 0;
        float f = 42E12f;
        i = (int) f;
        System.out.println(f);
        System.out.println(i);
        System.out.println(Integer.MAX_VALUE);
    }
}
