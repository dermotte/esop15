package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 02.11.2015.
 */
public class ExtendedFraction {
    int n;  // numerator
    int d;  // denominator

    /**
     * Constructor for the fraction class.
     * @param n
     * @param d
     */
    public ExtendedFraction(int n, int d) {
        this.n = n;
        this.d = d;
    }

    public ExtendedFraction() {
        n = 0;
        d = 1; // make sure denominator is not 0.
    }

    /**
     * Multiply this fraction with another one.
     *
     * @param f the second factor
     */
    void mult(ExtendedFraction f) {
        n = f.n * n;
        d = f.d * d;
    }

    /**
     * Add a fraction to this one.
     *
     * @param f the fraction to add to this one.
     */
    void add(ExtendedFraction f) {
        d = f.d * d;  // bring to the same denominator
        n = f.n * d + n * f.d;
    }

    /**
     * Reduces the fraction by the gcd of the numerator and the denominator.
     */
    void reduce() {
        int r = gcd(n, d);
        n = n / r;
        d = d / r;
    }


    /**
     * Euclidean algorithm
     * @param a an integer
     * @param b an integer
     * @return the greatest common denominator.
     */
    int gcd(int a, int b) {
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        return a;
    }

    public static void main(String[] args) {
        ExtendedFraction f1 = new ExtendedFraction(2, 3);
        ExtendedFraction f2 = new ExtendedFraction(3, 2);

        f1.mult(f2);
        System.out.printf("Result is %d / %d\n", f1.n, f1.d);
        f1.add(f2);
        System.out.printf("Result is %d / %d\n", f1.n, f1.d);
        f1.reduce();
        System.out.printf("Result is %d / %d\n", f1.n, f1.d);
    }
}
