package at.aau.esop15.course10;


/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class GreetAnon {
    // define an interface
    interface HelloThere {
        public void greet(String name);
    }

    public static void main(String[] args) {
        HelloThere en = new HelloThere() {
            @Override
            public void greet(String name) {
                System.out.printf("Hello %s!\n", name);
            }
        };
        HelloThere de = new HelloThere() {
            public void greet(String foo) {
                System.out.println("Servus " + foo + "!");
            }
        };


        en.greet("Mathias");
        en.greet("World");

        de.greet("Mathias");
    }
}
