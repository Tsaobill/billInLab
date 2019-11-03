package LeetCode;

/**
 * 合并k个有序链表
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-12 20:28
 **/
public class MergeKSortedList {

    public static void main(String[] args) {
        ListNode a1 = new ListNode (1);
        ListNode a2 = new ListNode (4);
        ListNode a3 = new ListNode (5);

        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode (1);
        ListNode b2 = new ListNode (3);
        ListNode b3 = new ListNode (4);

        b1.next = b2;
        b2.next = b3;

        ListNode c1 = new ListNode (2);
        ListNode c2 = new ListNode (6);
        ListNode c3 = new ListNode (8);
        c1.next = c2;
        c2.next = c3;

        ListNode d1 = new ListNode (10);

        ListNode[] lists = new ListNode[4];
        lists[0] = a1;
        lists[1] = b1;
        lists[2] = c1;
        lists[3] = d1;


        ListNode res = mergeKLists (lists);
        while (res != null) {
            System.out.print (res.val + "->");
            res = res.next;
        }
        System.out.println ();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        buildHeap (lists);
        ListNode dummy = new ListNode (-1), cur = dummy;
        while (k > 1) {
            cur.next = lists[0];
            lists[0] = lists[0].next;
            if (lists[0] == null) {
                lists[0] = lists[k - 1];
                k--;
            }
            heapfy (lists, 0, k);
            cur = cur.next;
        }
        cur.next = lists[0];
        return dummy.next;
    }

    public static void buildHeap(ListNode[] lists) {
        for (int i = lists.length / 2 - 1; i >= 0; i--) {
            heapfy (lists, i, lists.length);
        }
    }

    public static void heapfy(ListNode[] lists, int idx, int size) {
        if (idx >= size - 1) return;
        int min = idx;
        int left = 2 * idx + 1, right = 2 * idx + 2;

        if (left < size && lists[idx].val > lists[left].val) {
            min = left;
        }
        if (right < size && lists[min].val > lists[right].val) {
            min = right;
        }
        if (min != idx) {
            ListNode temp = lists[min];
            lists[min] = lists[idx];
            lists[idx] = temp;
            heapfy (lists, min, lists.length);
        }
    }
}
