package _2019秋招笔试题.xiaomi_0906;

import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-06 19:01
 **/
public class Main1 {
    public static void main(String[] args) {
        // 1(2(3,4(,5)),6(7,))
        String s = "1(2(3,4(,5)),6(7,))";
        TreeNode root = getTreeRoot (s);
        String res = print (root);
        System.out.println (res);
    }

    static TreeNode getTreeRoot(String s) {
        if (s.length () < 1) return null;
        if (s.length () == 1) {
            if (s.charAt (0) != ',') return new TreeNode (s.charAt (0) - '0');
            else return null;
        }
        if (s.charAt (1) != '(') return new TreeNode (s.charAt (0) - '0');
        TreeNode root = new TreeNode (s.charAt (0) - '0');
        s = s.substring (2, s.length () - 1);
        int mid = getMid (s);
        root.left = getTreeRoot (s.substring (0, mid));
        root.right = getTreeRoot (s.substring (mid + 1));
        return root;
    }

    static int getMid(String s) {
        if (s.charAt (0) == ',') return 0;
        if (s.charAt (1) != '(') return 1;
        int idx = 1;
        int sum = 1;
        while (sum != 0) {
            idx++;
            if (s.charAt (idx) == '(') sum++;
            if (s.charAt (idx) == ')') sum--;
        }
        return idx + 1;
    }


    static String print(TreeNode root) {
        String res = "";
        if (root == null) return "";
        String left = print (root.left);
        res = left + root.val;
        String right = print (root.right);
        res = res + right;
        return res;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
