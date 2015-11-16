package at.aau.esop15.course07;

import java.io.Serializable;

/**
 * @author Dr. Mathias Lux, 16.11.2015.
 */
public class StringChangeFileSuffix {
    public static void main(String[] args) {
        // input
        String myFileName = "paper.pdf";
        // find the position of the last dot
        int dotIndex = myFileName.lastIndexOf('.');
        // take substring and add new suffix
        String newFileName = myFileName.substring(0, dotIndex) + ".doc";
        // print result:
        System.out.println("newFileName = " + newFileName);
    }
}
