package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 13:04.
 */
public class PrimesSieve {
        public static void main(String[] args) {
            int maxPrime = 2000000;
            boolean[] sieve = new boolean[maxPrime];
            // init array
            for (int i = 0; i < sieve.length; i++) {
                sieve[i] = true;
            }

            // mark the non-primes
            for (int i = 2; i < Math.sqrt(sieve.length); i++) {
                if (sieve[i] == true) { // if it is a prime
                    int k = 2;
                    while (k*i < sieve.length) {
                        sieve[k*i] = false;
                        k++;
                    }
                }
            }

            // print results
            for (int i = 2; i < sieve.length; i++) {
                if (sieve[i]) System.out.println(i);
            }
        }
    }

