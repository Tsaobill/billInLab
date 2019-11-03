package LeetCode;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-22 18:47
 **/
class Solution {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 1}, {11, 12, 13, 14, 1}};
        int[][] arr1 = new int[][]{{1, 2, 3, 4, 5}, {10, 9, 8, 7, 6}, {11, 12, 13, 14, 15}};
        System.out.println (new Solution ().longestIncreasingPath (arr));
        System.out.println (new Solution ().longestIncreasingPath (arr1));
        System.out.println (new Solution ().longestIncreasingPath (new int[4][4]));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        boolean[][] flag = new boolean[matrix.length][matrix[0].length];
        int longest = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!flag[i][j]) {
                    res[i][j] = getMax (i, j, matrix, res, flag);
                }
                longest = res[i][j] > longest ? res[i][j] : longest;
            }
        }
        Queue<TreeNode> s = new LinkedList<> ();
        s.offer (new TreeNode (1));
        s.remove ();

        return longest;
    }

    public void levelOrder(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<> ();
        queue.offer (root);
        while(!queue.isEmpty ()) {
            root = queue.poll ();
            System.out.println (root.val);
            if(root.left != null) queue.offer (root.left);
            if(root.right != null) queue.offer (root.right);
        }
    }

    public int getMax(int i, int j, int[][] matrix, int[][] res, boolean[][] flag) {
        if (flag[i][j]) return res[i][j];

        int up = 0, down = 0, left = 0, right = 0;
        if (i > 0 && matrix[i][j] > matrix[i - 1][j]) {
            up = getMax (i - 1, j, matrix, res, flag);
        }

        if (i < matrix.length - 1 && matrix[i][j] > matrix[i + 1][j]) {
            down = getMax (i + 1, j, matrix, res, flag);
        }

        if (j > 0 && matrix[i][j] > matrix[i][j - 1]) {
            left = getMax (i, j - 1, matrix, res, flag);
        }

        if (j < matrix[0].length - 1 && matrix[i][j] > matrix[i][j + 1]) {
            right = getMax (i, j + 1, matrix, res, flag);
        }
        res[i][j] = max (up, down, left, right) + 1;
        flag[i][j] = true;
        return res[i][j];
    }

    public int max(int a, int b, int c, int d) {
        a = Math.max (a, b);
        a = Math.max (a, c);
        a = Math.max (a, d);
        return a;
    }
}