/**
 * 上海大学
 * FileName: LongestCommonSubsequence
 * Author:   bill
 * Date:     2018/11/17 13:19
 * Description: 最长公共子序列
 * History:
 */
package DynamicProgramming;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(getLCS(new int[]{1, 2, 4, 5, 6, 7, 8}, new int[]{5, 4, 2, 1, 6, 7, 8}));
    }

    public static int getLCS(int[] a, int[] b) {
        if (a.length == 0 || b.length == 0) {
            return 0;
        }
        int[][] dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                dp[i][j] = a[i - 1] == b[j - 1]  ? dp[i - 1][j - 1] + 1: Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        return dp[a.length][b.length];
    }
}