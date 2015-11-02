package at.aau.esop15.course05;

/**
 * @author Dr. Mathias Lux, 02.11.2015.
 */
public class Queue {
    int[] data;
    int head, tail, length;

    Queue(int size) {
        data = new int[size];
        head = 0;
        tail = 0;
        length = 0;
    }

    void put(int x) {
        if (length == data.length)  System.out.println("-- overflow");
        else {
            data[tail] = x;
            length++;
            tail = (tail + 1) % data.length;
        }
    }

    int get() {
        int x;
        if (length <= 0) {
            System.out.println("-- underflow");
            return 0;
        } else  x = data[head];
        length--;
        head = (head + 1) % data.length;
        return x;
    }

    public static void main(String[] args) {
        Queue q = new Queue(10);
        q.put(3);
        q.put(6);
        int x = q.get(); // x == 3
        int y = q.get(); // y == 6
    }
}
