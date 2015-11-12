package at.aau.esop15.course05;

/**
 * Created by mlux on 02.11.2015.
 */
public class Stack {
    int[] data;
    public int top;

    Stack(int size) {
        data = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top == data.length - 1)
            System.out.println("-- overflow");
        else
            data[++top] = x;
    }

    int pop() {
        if (top < 0) {
            System.out.println("-- underflow");
            return 0;
        } else
            return data[top--];
    }

    public static void main(String[] args) {
        Stack s = new Stack(10);
        s.push(3);
        s.push(5);
        int x = s.pop() - s.pop();
        System.out.println("x = " + x);
    }
}

