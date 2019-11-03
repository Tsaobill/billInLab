/**
 * 上海大学
 * FileName: BTNTraversal
 * Author:   bill
 * Date:     2018/11/30 20:08
 * Description: 包含二叉树遍历方法的类
 * History:
 */
package Tree.BinaryTreeTraversal;

import Tree.BTN;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BTNTraversal {

    //先序遍历 递归
    public static void preOrderTraInRec(BTN root) {
        if (root == null) return;
        System.out.print(root.val + "  ");
        preOrderTraInRec(root.left);
        preOrderTraInRec(root.right);
    }

    //非递归先序遍历 1
    public static void preOrderTraNoRec1(BTN root) {
        BTN p = root;
        Stack<BTN> s = new Stack<>();
        while (!s.isEmpty() || p != null) {
            while (p != null) {
                System.out.print(p.val + "  ");
                s.push(p);
                p = p.left;
            }
            if (!s.isEmpty()) {
                p = s.pop();
                p = p.right;
            }
        }
    }

    //非递归先序遍历 2
    public static void preOrderTraNoRec2(BTN root) {
        BTN p = root;
        Stack<BTN> s = new Stack<>();
        s.push(p);
        while (!s.isEmpty()) {
            p = s.pop();
            System.out.print(p.val + "  ");
            if (p.right != null) s.push(p.right);
            if (p.left != null) s.push(p.left);
        }
    }

    //===============================================
    //中序遍历 递归
    public static void inOrderTraInRec(BTN root) {
        if (root == null) return;
        inOrderTraInRec(root.left);
        System.out.print(root.val + "  ");
        inOrderTraInRec(root.right);
    }
    //非递归中序遍历 1

    public static void inOrderTraNoRec1(BTN root) {
        BTN p = root;
        BTN[] stack = new BTN[100];
        int i = -1;
        while (p != null || i != -1) {
            while (p != null) {
                stack[++i] = p;
                p = p.left;
            }
            p = stack[i--];
            System.out.print(p.val + "  ");
            p = p.right;
        }
    }

    //非递归中序遍历 2
//这种在LeetCode上 Invert Binary Tree AC 且Online Judge 0 ms
// 不过 由于中序遍历 根反转后原本的右节点称为了左节点，因此 p=p.right 应改为 p=p.left
    //用数组简单实现更高效
    public static void inOrderTraNoRec2(BTN root) {
        BTN p = root;
        BTN[] stack = new BTN[100];
        int i = -1;
        while (p != null || i != -1) {
            while (p != null) {
                stack[++i] = p;
                p = p.left;
            }
            if (i != -1) {
                p = stack[i--];
                System.out.print(p.val + "  ");
                p = p.right;
            }
        }
    }


    //===============================================

    //后序遍历 递归
    public static void postOrderTraInRec(BTN root) {
        if (root == null) return;
        postOrderTraInRec(root.left);
        postOrderTraInRec(root.right);
        System.out.print(root.val + "  ");
    }

    //非递归后序遍历 1
    public static void postOrderTraNoRec1(BTN root) {//双栈
        Stack<BTN> s1 = new Stack<>();
        Stack<BTN> s2 = new Stack<>();
        BTN p = root;
        s1.push(root);
        while (!s1.isEmpty()) {
            p = s1.pop();
            s2.push(p);
            if (p.left != null) s1.push(p.left);
            if (p.right != null) s1.push(p.right);
        }
        while (!s2.isEmpty()) {
            p = s2.pop();
            System.out.print(p.val + "  ");
        }
    }

    //层序遍历
    //1.利用队列，所有节点依次入队出队。
    public static void lvOrderTra(BTN root) {
        if (root == null) return;
        Queue<BTN> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            BTN temp = q.poll();
            System.out.print(temp.val + "  ");
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }
    }

    //2.不用队列，利用链表，每次输出一层节点时候，按顺序存储下一层的节点，
    public static void lvOrderTra2(BTN root) {
        if (root == null) return;
        ArrayList<BTN> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            ArrayList<BTN> temp = new ArrayList<>();
            for (BTN node :
                    list) {
                System.out.print(node.val + "  ");
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            list = temp;
        }
    }
}