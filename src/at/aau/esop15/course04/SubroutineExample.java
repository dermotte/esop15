package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 12:55.
 */
public class SubroutineExample {
    private static void printRule() { 	        // head
        System.out.println("-------------"); 	// body
    }

    public static void main(String[] args) {
        printRule(); 			                // method call
        System.out.println("Header 1");
        printRule();
    }

}

