package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求两个字符串的最长公共子系列
 * Longest Common Subsequence
 * 子序列不要求连续
 * 子串要求连续 最长连续公共子串 Longest Common Substring
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-12 下午1:23
 **/
public class LCS {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner (System.in);
//        String str1 = sc.nextLine ();
//        String str2 = sc.nextLine ();
        String str1 = "acbadab";
        String str2 = "abdab";
        System.out.println (getLCSLength (str1,str2));
    }

    static int getLCSLength(String str1, String str2) {
        int n = str1.length ();
        int m = str2.length ();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt (i-1) == str2.charAt (j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = max (dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int a[] = new int[]{1,2,3};
        System.out.println (Arrays.toString (a));
        return dp[n][m];


    }

    static int max(int n, int m) {
        return n > m ? n : m;
    }
}
