package at.aau.esop15.course06;
/**
 * Created by mlux_2 on 20.11.2014.
 */
public class Stack {
    Node bottom;

    Stack() {
        bottom = null;
    }

    void push(int x) {
        Node newNode = new Node(x);
        if (bottom == null)
            bottom = newNode;
        else // es ist bereits was im stack
        {
            topNode().nextNode = newNode;
        }
    }

    int pop() {
        Node p = bottom;
        Node prev = null;
        while (p.nextNode != null) {
            prev = p;
            p = p.nextNode;
        }
        if (prev == null)
            bottom = null;
        else
            prev.nextNode = null;
        return p.value;
    }

    int top() {
        return topNode().value;
    }

    private Node topNode() {
        Node p = bottom;
        while (p.nextNode != null) {
            p = p.nextNode;
        }
        return p;
    }

}
