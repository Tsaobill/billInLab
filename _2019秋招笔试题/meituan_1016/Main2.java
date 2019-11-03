package _2019秋招笔试题.meituan_1016;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-16 14:56
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while (true) {
            int P = sc.nextInt ();
            if (P == 0) break;
            int n = sc.nextInt ();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt ();
            }
            int[] dp = new int[P + 1];
            int INF = 0x3f3f3f3f;
            Arrays.fill (dp, INF);
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = arr[i]; j <= P; j++) {
                    dp[j] = Math.min (dp[j], dp[j - arr[i]] + 1);
                }
            }
            String res = dp[P] > INF / 2 ? "Impossible" : dp[P] + "";
            System.out.println (res);
        }
    }
}
