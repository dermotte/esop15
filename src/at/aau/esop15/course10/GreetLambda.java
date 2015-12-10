package at.aau.esop15.course10;


/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class GreetLambda {
    // define an interface
    interface HelloThere {
        public void greet(String name);
    }

    public static void main(String[] args) {
        HelloThere en = name -> System.out.printf("Hello %s!\n", name);
        HelloThere es = name -> System.out.printf("¡Hola, %s!\n", name);
        HelloThere de = name -> System.out.printf("Hallo %s!\n", name);
        en.greet("Mathias");
        es.greet("Mathias");
        de.greet("Mathias");
    }
}
