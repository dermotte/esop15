package at.aau.esop15.course07;

/**
 * @author Dr. Mathias Lux, 16.11.2015.
 */
public class MathTrigonometricDemo {
    public static void main(String[] args) {
        // ASCII sine wave
        for (double d = 0d; d < 4*Math.PI; d+=0.15) {
            double x = 40*(Math.sin(d) + 1);
            x = Math.round(x);
            for (int i = 0; i< x; i++) System.out.print(' ');
            System.out.println('*');
        }

        // angle of a vector
        double ang = Math.atan2(1,1);
        System.out.println("Angle of the vector (1,1) in radians: " + ang); // radians
        System.out.println("Angle of the vector (1,1) in degrees: " + Math.toDegrees(ang)); // 45°
    }
}
