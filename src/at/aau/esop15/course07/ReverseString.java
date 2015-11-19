package at.aau.esop15.course07;

import java.util.Arrays;

/**
 * @author Dr. Mathias Lux, 16.11.2015.
 */
public class ReverseString {
    public static void main(String[] args) {
        // input String
        String myString = new String("lagerregal");
        System.out.println("myString.length() = " + myString.length());
        // data structures for reversing
        char[] tmpCharsIn = new char[myString.length()];
        char[] tmpCharsOut = new char[myString.length()];
        // getting the input data to an array:
        myString.getChars(0, myString.length(), tmpCharsIn, 0);
        // iterating output and setting chars:
        for (int i = 0; i < tmpCharsOut.length; i++) {
            tmpCharsOut[i] = tmpCharsIn[(myString.length()-1)-i];
        }
        // print result:
        System.out.println(new String(tmpCharsOut));
    }
}
