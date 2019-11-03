package LinkedList;

/**
 * 两个链表表示的数相加，结果用链表表示
 *
 * @version 1.0
 * @created by bill
 * @on 2018-08-06 下午11:12
 **/
public class AddTwoSum {

    public static void main(String[] args) {
        ListNode x1 = new ListNode (2);
        ListNode x2 = new ListNode (4);
        ListNode x3 = new ListNode (3);
        ListNode y1 = new ListNode (5);
        ListNode y2 = new ListNode (6);
        ListNode y3 = new ListNode (4);
        x1.next = x2;
        x2.next = x3;
        y1.next = y2;
        y2.next = y3;
        ListNode sum = addTwoSum (x1, x2);
        while (sum != null) {
            System.out.print (sum.val + " ");
            sum = sum.next;
        }

    }

    private static ListNode addTwoSum(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode (0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int digit = x + y + carry;
            carry = digit / 10;
            curr.next = new ListNode (digit % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) curr.next = new ListNode (carry);
        return dummyHead.next;
    }
}
