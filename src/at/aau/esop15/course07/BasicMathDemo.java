package at.aau.esop15.course07;

/**
 * Taken from the Java Tutorials: http://docs.oracle.com/javase/tutorial/java/data/beyondmath.html
 */
public class BasicMathDemo {
    public static void main(String[] args) {
        double a = -191.635;
        double b = 42.74;
        int c = 7, d = 42;

        System.out.printf("The absolute value " + "of %.3f is %.3f%n", a, Math.abs(a));

        System.out.printf("The ceiling of " + "%.2f is %.0f%n", b, Math.ceil(b));

        System.out.printf("The floor of " + "%.2f is %.0f%n", b, Math.floor(b));

        System.out.printf("The rounded value of %.2f " + "is %d%n", b, Math.round(b));

        System.out.printf("The max of %d and " + "%d is %d%n", c, d, Math.max(c, d));

        System.out.printf("The min of %d " + "and %d is %d%n", c, d, Math.min(c, d));
    }
}
