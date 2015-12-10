package at.aau.esop15.course10;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Dr. Mathias Lux, mlux@itec.aau.at, 10.12.2015.
 */
public class ThreadsWithInnerClasses {
    static int sum = 0;

    public static void main(String[] args)  {
        LinkedList<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread t;
            if (threads.size()%2==0) {
                t = new Thread(new Runnable() {
                    int count = 1000;

                    @Override
                    public void run() {
                        while (count-- > 0)
                            ThreadsWithInnerClasses.sum++;
                    }
                });
            } else {
                t = new Thread(new Runnable() {
                    int count = 1000;

                    @Override
                    public void run() {
                        while (count-- > 0)
                            ThreadsWithInnerClasses.sum--;
                    }
                });
            }
            threads.add(t);
        }
        // starting:
        for (Iterator<Thread> iterator = threads.iterator(); iterator.hasNext(); ) {
            iterator.next().start();
        }
        // waiting to be finished:
        for (Iterator<Thread> iterator = threads.iterator(); iterator.hasNext(); ) {
            try {
                iterator.next().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // print result
        System.out.println("sum = " + ThreadsWithInnerClasses.sum);
    }
}
