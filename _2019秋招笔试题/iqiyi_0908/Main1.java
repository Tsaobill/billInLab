package _2019秋招笔试题.iqiyi_0908;

import _2018秋招笔试题.拼多多.Main;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个长度为N-1且只包含0和1的序列A1到AN-1，
 * 如果一个1到N的排列P1到PN满足对于1≤i<N，当Ai=0时Pi<Pi+1，当Ai=1时Pi>Pi+1，
 * 则称该排列符合要求，那么有多少个符合要求的排列？
 *
 * @version 1.0
 * @created by bill
 * @on 2019-09-08 15:24
 **/
public class Main1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        int n = 4;
//        int[] arr = new int[]{1, 1, 0};
//        permu (new int[n], new boolean[n + 1], arr, 0, n);

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = sc.nextInt ();
        }

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (arr[i - 1] == 0) {
                    for (int k = j; k < i; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                } else {
                    for (int k = 0; k < j; k++) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res += dp[n - 1][i];
            res %= mod;
        }
        System.out.println (res);
    }

    static int res = 0;
    static int mod = 1000000007;

    static void permu(int[] path, boolean[] st, int[] arr, int k, int n) {
        if (k == n) {
            System.out.println (Arrays.toString (path));
            res += 1;
            if (res > mod) res %= mod;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (k > 0) {
                if (!st[i] && ((arr[k - 1] == 0 && path[k - 1] < i) || (arr[k - 1] == 1 && path[k - 1] > i))) {
                    st[i] = true;
                    path[k] = i;
                    permu (path, st, arr, k + 1, n);
                    st[i] = false;
                }
            } else {
                st[i] = true;
                path[k] = i;
                permu (path, st, arr, k + 1, n);
                st[i] = false;
            }
        }
    }

}
