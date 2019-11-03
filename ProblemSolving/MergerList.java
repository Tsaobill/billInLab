/**
 * @author
 * @create 2018-08-03 17:00
 **/

package ProblemSolving;

import LeetCode.ListNode;

public class MergerList {
    public static void main(String[] args) {
        //ListNode
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        head.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        head = rotateList(head, 2);
        while (head != null) {
            System.out.print(head.val + "=>");
            head = head.next;
        }
    }

    public static ListNode rotateList(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
