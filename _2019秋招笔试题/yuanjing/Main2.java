package _2019秋招笔试题.yuanjing;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-29 19:44
 **/
public class Main2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        String V = sc.nextLine ();
        String W = sc.nextLine ();
        String[] strv = V.split (" ");
        String[] strw = W.split (" ");
        int n = strv.length;
        int[] v = new int[n + 1];
        int[] w = new int[n + 1];
        for (int i = 0; i < n; i++) {
            v[i + 1] = Integer.valueOf (strv[i]);
            w[i + 1] = Integer.valueOf (strw[i]);
        }
        int m = sc.nextInt ();
//        int[] f = new int[m + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = m; j >= v[i]; j--) {
//                f[j] = Math.max (f[j], f[j - v[i]] + w[i]);
//            }
//        }
//        System.out.println (f[m]);

    }

}
