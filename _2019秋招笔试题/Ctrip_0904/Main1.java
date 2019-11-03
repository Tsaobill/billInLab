package _2019秋招笔试题.Ctrip_0904;

import java.util.List;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-04 19:28
 **/
public class Main1 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    static ListNode partition(ListNode head, int m) {
        if (head == null || head.next == null) return head;

        ListNode bigHead = new ListNode (-1);
        ListNode big = bigHead;
        ListNode lessHead = new ListNode (-1);
        ListNode less = lessHead;
        while (head != null) {
            if (head.val < m) {
                less.next = head;
                less = less.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        less.next = null;
        return lessHead.next;
    }
}
