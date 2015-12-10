package at.aau.esop15.course10;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class ThreadExample implements Runnable {
    String text;
    int count = 5000;

    public ThreadExample(String text) {
        this.text = text;
    }

    @Override
    public void run() {
        while (count-- > 0) System.out.print(text);
    }


    public static void main(String[] args) {
        new Thread(new ThreadExample("-")).start();
        new Thread(new ThreadExample("O")).start();
        new Thread(new ThreadExample("/")).start();
        new Thread(new ThreadExample("|")).run();
    }


}