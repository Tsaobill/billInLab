/**
 * 上海大学
 * FileName: AddTwoNumbers
 * Author:   bill
 * Date:     2018/8/4 17:56
 * Description:
 * History:
 */
package LeetCode.LinkedList;

import java.util.List;
import java.util.Random;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode x1 = new ListNode(2);
        ListNode x2 = new ListNode(4);
        ListNode x3 = new ListNode(3);
        ListNode x4 = new ListNode(9);
        ListNode y1 = new ListNode(5);
        ListNode y2 = new ListNode(6);
        ListNode y3 = new ListNode(4);
        ListNode y4 = new ListNode(0);
        x1.next = x2;
        x2.next = x3;
//        x3.AllPermutation = x4;
        y1.next = y2;
        y2.next = y3;
//        y3.AllPermutation = y4;
        ListNode sum = addTwoNumPro(x1, y1);
        while (sum != null) {
            System.out.print(sum.val + " ");
            sum = sum.next;
        }

    }

    // 方法一:
    private static ListNode addTwoNum(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int flag = 0;
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + flag <= 9) {
                p.next = l1;
                p.next.val = l1.val + l2.val + flag;
                flag = 0;
                p = p.next;
            } else {
                p.next = l1;
                p.next.val = (l1.val + l2.val + flag) % 10;
                flag = 1;
                p = p.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            carry(l1, p, flag);
            return dummyHead.next;
        }
        if (l2 != null) {
            carry(l2, p, flag);
            return dummyHead.next;
        }

        if (flag != 0) p.next = new ListNode(flag);
        return dummyHead.next;
    }

    private static void carry(ListNode l, ListNode p, int flag) {
        while (l != null) {
            p.next = l;
            if (flag + l.val <= 9) {
                p.next.val = flag + l.val;
                break;
            } else {
                p.next.val = 0;
                flag = 1;
            }
            l = l.next;
            p = p.next;
        }

        if (flag != 0) {
            p.next = new ListNode(flag);
        }
    }
//end 方法一


    //    方法二：
    private static ListNode addTwoNumPro(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int flag = 0;
        while (l1 != null || l2 != null) {
            p.next = new ListNode(0);
            if (l1 != null & l2 != null) {
                p.next.val = l1.val + l2.val + flag > 9 ? (l1.val + l2.val + flag) % 10 : l1.val + l2.val + flag;
                flag = l1.val + l2.val + flag > 9 ? 1 : 0;
                if (l1.next == null && l2.next == null & flag == 1) {
                    p = p.next;
                    p.next = new ListNode(1);
                    break;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                if (l2.val + flag <= 9) {
                    p.next.val = l2.val + flag;
                    break;
                } else {
                    p.next.val = 0;
                    flag = 1;
                    l2 = l2.next;
                }
            } else {
                if (l1.val + flag <= 9) {
                    p.next.val = l1.val + flag;
                    break;
                } else {
                    p.next.val = 0;
                    flag = 1;
                    l1 = l1.next;
                }
            }
            p = p.next;
        }
        return dummyHead.next;
    }
//end 方法二

    //方法三 标准版
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int digit = x + y + carry;
            carry = digit / 10;
            curr.next = new ListNode(digit % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return dummyHead.next;
    
    }
}