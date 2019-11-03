package ProblemSolving;

/**
 * 判断一棵树是否是另一个树的子树
 *
 * @version 1.0
 * @created by bill
 * @on 2019-06-22 12:51
 **/
public class IsSubTree {
    public static void main(String[] args) {

    }
    private static boolean isSubtree(TreeNode s, TreeNode t) {
        boolean result = false;
        if (s != null && t != null) {
            result = isTrue (s, t);
            if (!result) {
                result = isSubtree (s.left, t);
            }
            if (!result) {
                result = isSubtree (s.right, t);
            }
        }
        return result;
    }

    private static boolean isTrue(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isTrue (s.left, t.left) && isTrue (s.right, t.right);
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}