package at.aau.esop15.course03;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 15.10.2015 14:56.
 */
public class DoubleFor {
    public static void main(String[] args) {
        for (int i = 1; true ; i++) {
            for (int j = 1; j < 25; j++) {
                int result = i * j;
                System.out.print(result + "\t");
            }
            System.out.print("\n");
        }
    }
}
