package at.aau.esop15.course10;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class ThreadConcurrencyExampleSynchronized implements Runnable {
    boolean up;           // increment or decrement
    int count = 1000;   // each runs # times
    static int sum;       // shared variable
    static Object monitor = new Object();

    public ThreadConcurrencyExampleSynchronized(boolean up) {
        this.up = up;
    }

    public void run() {
        synchronized (monitor) {
            while (count-- > 0)
                if (up)
                    sum++;
                else
                    sum--;
        }
    }

    public static void main(String[] args) {
        boolean upMe = true;
        LinkedList<Thread> t = new LinkedList<Thread>();
        for (int i = 0; i < 10; i++) { // creating 10 threads
            Thread thread = new Thread(new ThreadConcurrencyExampleSynchronized(upMe));
            upMe = !upMe;
            thread.start();
            t.add(thread);
        }
        // making sure to wait for them to end:
        for (Iterator<Thread> iterator = t.iterator(); iterator.hasNext(); ) {
            try {
                iterator.next().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("sum = " + sum);
    }
}
