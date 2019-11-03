package LinkedList;

/**
 * 插入排序一个链表
 *
 * @version 1.0
 * @created by bill
 * @on 2018-12-03 上午11:09
 **/
public class InsertionSortList {
    public static void main(String[] args) {
//        ListNode x1 = new ListNode (4);
//        ListNode x2 = new ListNode (2);
//        ListNode x3 = new ListNode (1);
//        ListNode x4 = new ListNode (3);
//        x1.AllPermutation = x2;
//        x2.AllPermutation = x3;
//        x3.AllPermutation = x4;
       // ListNode sum = insertionSortList (x1);
//        while (sum != null) {
//            System.out.print (sum.val + " ");
//            sum = sum.AllPermutation;
//        }


    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode (0);
        dummyHead.next = head;
        head = head.next;
        while (head != null) {
            ListNode curr = head.next;
            ListNode temp = dummyHead;
            while (head.val > temp.next.val) {
                temp = temp.next;
            }
            head.next = temp.next;
            temp.next = head;

            head = curr;
        }
        return dummyHead.next;
    }
}
