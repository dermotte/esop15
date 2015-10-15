package at.aau.esop15.course03;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 15.10.2015 14:40.
 */
public class FunWithWhile {
    public static void main(String[] args) {
        short x = 10;
        while (x-- > 0) {
            byte y = 0;
            while (y++<x) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}
