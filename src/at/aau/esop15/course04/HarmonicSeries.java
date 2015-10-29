package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 12:52.
 */
public class HarmonicSeries {
    public static void main (String[] arg) {
        double sum = 0;
        int n = 10; // maximum
        for (int i = n; i > 0; i--) // n bis 0
            sum += 1.0 / (double) i;
        System.out.println("sum = " + sum);
    }
}

