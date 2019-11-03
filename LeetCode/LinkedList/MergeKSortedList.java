/**
 * 上海大学
 * FileName: MergeKSortedList
 * Author:   bill
 * Date:     2018/9/29 20:07
 * Description: 合并K个有序链表
 * History:
 */
package LeetCode.LinkedList;

import java.util.*;

public class MergeKSortedList {


    private static final Comparator<ListNode> listComparator =
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode x, ListNode y) {
                    return x.val - y.val;
                }
            };

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(8);
        l1.next = l2;
        l2.next = l3;

        ListNode m1 = new ListNode(3);
        ListNode m2 = new ListNode(6);
        ListNode m3 = new ListNode(9);
        m1.next = m2;
        m2.next = m3;

        List<ListNode> lists = new ArrayList<>();
        lists.add(n1);
        lists.add(l1);
        lists.add(m1);

        ListNode head = mergeKLists(lists);
        while (head != null) {
            System.out.print(head.val + ",");
            head = head.next;
        }
    }

    //基于最小堆的优先队列实现
    ///O(nklog k) runtime, O(k) space – Heap:
    /*
     * We could use a min heap of size k. The heap is first initialized with
     * the smallest element from each list. Then as we extract the nodes out
     * from the heap, we must remember to insert its AllPermutation node into the heap.
     * As each insert operation into the heap costs log(k) and there are a
     * total of nk elements, the total runtime complexity is O(nk log k).
     * Ignoring the extra space that is used to store the output list,
     * we only use extra space of O(k) due to the heap.
     * */
    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty()) return null;
        Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listComparator);
        for (ListNode node : lists
                ) {
            if (node != null) queue.add(node);
        }
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        ListNode node;

        while (!queue.isEmpty()) {
            node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummyNode.next;
    }


    /// O(nk log k) runtime, O(1) space – Divide and conquer using two way merge:
    // 重点： 两个嵌套的 while循环 实现了将 n 个数 两两合并 直到为1  类似从底部开始 创建一棵树
    public static ListNode mergeKLists(List<ListNode> lists, int flag) {
        if (lists.isEmpty()) return null;
        int end = lists.size() - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists.set(begin, merge2Lists(lists.get(begin),
                        lists.get(end)));
                begin++;
                end--;
            }
        }
        return lists.get(0);
    }

    //辅助函数 合并两个有序链表
    private static ListNode merge2Lists(ListNode l1, ListNode l2) {
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
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
    }

}