package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 12:56.
 */
public class BinomialCoefficient {
    static int n = 5, k = 3;

    public static void main(String[] args) {
        int result = factorial(n) /
                (factorial(k) * factorial(n - k));
        System.out.println("result = " + result);
    }

    /**
     * Function for computing the factorial.
     * @param k
     * @return the actual value
     */
    public static int factorial(int k) {
        int result = 1;
        for (int i = 2; i <= k; i++) {
            result *= i;
        }
        return result;
    }
}
