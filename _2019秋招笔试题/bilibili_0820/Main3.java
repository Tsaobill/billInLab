package _2019秋招笔试题.bilibili_0820;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-20 19:22
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int[] c = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = sc.nextInt ();
        }
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt ();
        }

        int[] f = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= c[i]; j--) {
                f[j] = Math.max (f[j], f[j - c[i]] + w[i]);
            }
        }
        System.out.println (f[m]);
    }
}
