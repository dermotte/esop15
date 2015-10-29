package at.aau.esop15.course04;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 29.10.2015 15:19.
 */
public class CommandLineExample {
    public static void main(String[] args) {
        for (String arg: args) {
            System.out.println("arg = " + arg);
        }
    }
}
