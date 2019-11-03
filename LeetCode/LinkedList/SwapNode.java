/**
 * 上海大学
 * FileName: SwapNode
 * Author:   bill
 * Date:     2018/9/19 21:54
 * Description: 交换两个相邻节点
 * History:
 */
package LeetCode.LinkedList;

import java.util.List;

public class SwapNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode res = swapNode(l1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode swapNode(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = head;
        ListNode prev = dummyHead;
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r;
        }
        return dummyHead.next;
    }
}


