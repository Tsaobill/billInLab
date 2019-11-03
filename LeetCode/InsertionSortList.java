/**
 * @author
 * @create 2018-12-03 12:30
 **/

package LeetCode;

public class InsertionSortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = new ListNode(5);
        n3.next.next = new ListNode(7);
        n3.next.next.next = new ListNode(9);
        n3.next.next.next.next = new ListNode(6);
        n3.next.next.next.next.next = new ListNode(8);

        head = insertionSortList(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }


    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int MIN = Integer.MIN_VALUE;
        ListNode dummyHead = new ListNode(MIN);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (head != null) {
            if (prev.val <= head.val) {
                prev = prev.next;
                head = head.next;
            } else {
                ListNode headNext = head.next;
                ListNode temp = dummyHead.next;
                ListNode tePrev = dummyHead;
                while (head.val > temp.val) {
                    temp = temp.next;
                    tePrev = tePrev.next;
                }
                tePrev.next = head;
                prev.next = headNext;
                head.next = temp;
                head = headNext;
            }
        }
        return dummyHead.next;
    }
}
