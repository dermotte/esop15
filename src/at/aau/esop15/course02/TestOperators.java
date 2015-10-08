package at.aau.esop15.course02;

/**
 * A simple class for showing types and operators.
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 08.10.2015.
 */
public class TestOperators {
    public static void main(String[] args) {

        int i, j = 5;
        short s = 4;
        byte b;

        i = j; 		// ok: derselbe Typ
        i = 300; 	// ok (Zahlkonstanten sind int)
        b = 122;	// falsch: 300 passt nicht in byte
        i = s; 		// ok
        // s = i; 		// falsch

    }
}
