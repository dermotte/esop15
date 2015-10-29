package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 12:58.
 */
public class PrimesWithMethod {
    public static void main(String[] args) {
        int maxPrime = 1000;
        // iterate candidates
        for (int candidate = 3; candidate <= maxPrime; candidate++) {
            if (isPrime(candidate)) // print if number is prime.
                System.out.println("prime = " + candidate);
        }
    }

    /**
     * Method for checking if a single number is a prime number.
     * @param candidate
     * @return
     */
    public static boolean isPrime(int candidate) {
        boolean isPrime = true;
        // iterate potential dividers
        for (int divider = 2; divider < candidate; divider++) {
            // check for division without rest
            if (candidate % divider == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}

