/**
 * 上海大学
 * FileName: MergeSortedList
 * Author:   bill
 * Date:     2018/8/4 16:42
 * Description:合并两个已排序链表
 * History:
 */
package LeetCode.LinkedList;

import LeetCode.LinkedList.ListNode;

public class MergeSortedList {
    public static void main(String[] args) {

    }

    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) p.next = l2;
        if (l2 == null) p.next = l1;
        return dummyHead.next;
    }
}