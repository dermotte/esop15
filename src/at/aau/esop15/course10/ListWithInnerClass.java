package at.aau.esop15.course10;

/**
 * @author Dr. Mathias Lux, 12.11.2015.
 */
public class ListWithInnerClass {
    private ListNode head, tail;

    public void append(int value) {
        ListNode p = new ListNode(value);
        if (head == null)
            head = p;
        else
            tail.nextNode = p;
        tail = p;
    }

    public void prepend(int val) {
        ListNode p = new ListNode(val);
        p.nextNode = head;
        head = p;
    }

    /**
     * Method for determining if a value is inside the list.
     *
     * @param val the value to search for.
     * @return true if the value is found, false otherwise.
     */
    public boolean contains(int val) {
        ListNode p = head;
        boolean result = false;
        while (p != null) {
            if (p.value == val)
                result = true;
            p = p.nextNode;
        }
        return result;
    }

    /*
    public boolean betterContains(int val) {

        ListNode p = head;
        while (p!=null && p.value!=val) {
            p = p.nextNode;
        }
        return p != null;

    }
    */

    public void delete(int val) {
        ListNode p = head, prev = null;
        while (p != null && p.value != val) {
            prev = p;
            p = p.nextNode;
        }
        if (p != null) {
            if (p == head)
                head = p.nextNode;
            else
                prev.nextNode = p.nextNode;
            if (tail == p)
                tail = prev;
        }
    }

    /**
     * Method for finding the index of the first element
     * with a given value.
     *
     * @param val
     * @return index of first element with val or -1 if not found.
     */
    public int indexOf(int val) {
        ListNode p = head;
        int count = 0;
        int result = -1;
        while (p != null && result < 0) {
            if (p.value == val) {
                result = count;
            }
            p = p.nextNode;
            count++;
        }
        return result;
    }

    public long size() {
        long count =0;
        ListNode p = head;
        while (p!=null){
            count++;
            p = p.nextNode;
        }
        return count;
    }

    public static void main(String[] args) {
        ListWithInnerClass l = new ListWithInnerClass();
        l.append(3);
        l.append(14);
        l.append(42);
        l.append(-1);

        l.delete(-1);

        System.out.println(l.indexOf(42));
        System.out.println("l.size() = " + l.size());

        while (true) {
            l.append(42);
        }
    }

    class ListNode {
        int value;
        ListNode nextNode;

        public ListNode(int value) {
            this.value = value;
        }
    }
}
