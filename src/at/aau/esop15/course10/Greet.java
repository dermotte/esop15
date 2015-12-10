package at.aau.esop15.course10;


/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class Greet {
    // define an interface
    interface HelloThere {
        public void greet(String name);
    }

    public static void main(String[] args) {
        class GreetEnglish implements HelloThere {
            @Override
            public void greet(String name) {
                System.out.printf("Hello %s!\n", name);
            }
        }

        HelloThere h = new GreetEnglish();

        h.greet("Mathias");
    }
}
