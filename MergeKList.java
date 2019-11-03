import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-24 22:43
 **/
class node implements Comparable<node> {
    int val;
    node next;

    public node(int val) {
        this.val = val;
    }

    @Override
    public int compareTo(node o) {
        return this.val - o.val;
    }
}

public class MergeKList {
    public static void main(String[] args) {
        node node11 = new node (1);
        node node12 = new node (4);
        node node13 = new node (7);
        node node14 = new node (10);
        node node21 = new node (2);
        node node22 = new node (5);
        node node23 = new node (8);
        node node24 = new node (11);
        node node31 = new node (3);
        node node32 = new node (6);
        node node33 = new node (9);
        node node34 = new node (12);
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node31.next = node32;
        node32.next = node33;
        node33.next = node34;
        node[] nodes = new node[]{node11, node21, node31};
        node head = func (nodes);
        while (head != null) {
            System.out.print (head.val + "->");
        }
    }

    static node func(node[] nodes) {
        PriorityQueue<node> heap = new PriorityQueue<node> ();
        for(node n:nodes) heap.add (n);
        node dummy = new node (-1);
        node head = dummy;
        while (!heap.isEmpty ()) {
            head.next = heap.poll ();
            if(head.next.next!=null)
                heap.offer (head.next.next);
            head = head.next;
        }
        return dummy.next;
    }
}
