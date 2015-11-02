package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 02.11.2015.
 */
public class Fraction {
    int n;  // numerator
    int d;  // denominator

    /**
     * Multiply this fraction with another one.
     *
     * @param f the second factor
     */
    void mult(Fraction f) {
        n = f.n * n;
        d = f.d * d;
    }

    /**
     * Add a fraction to this one.
     *
     * @param f the fraction to add to this one.
     */
    void add(Fraction f) {
        d = f.d * d;  // bring to the same denominator
        n = f.n * d + n * f.d;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        f1.n = 2;
        f1.d = 3;
        Fraction f2 = new Fraction();
        f2.n = 3;
        f2.d = 2;

        f1.mult(f2);
        System.out.printf("Result is %d / %d\n", f1.n, f1.d);
        f1.add(f2);
        System.out.printf("Result is %d / %d\n", f1.n, f1.d);
    }
}
