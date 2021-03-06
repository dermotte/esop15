package at.aau.esop15.course10;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class ThreadConcurrencyExample implements Runnable {
    boolean up;           // increment or decrement
    int count = 100000000;   // each runs # times
    static int sum;       // shared variable

    public ThreadConcurrencyExample(boolean up) {
        this.up = up;
    }

    public void run() {
        while (count-- > 0)
            if (up)
                sum++;
            else
                sum--;
    }

    public static void main(String[] args) {
        LinkedList<Thread> t = new LinkedList<Thread>();
        boolean upMe = true;
        for (int i = 0; i < 10000; i++) { // creating 10 threads
            Thread thread = new Thread(new ThreadConcurrencyExample(upMe));
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
