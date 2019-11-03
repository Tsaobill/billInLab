package _2019秋招笔试题.qianxin;

import java.security.interfaces.RSAKey;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-12 19:38
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
        }
        int q = sc.nextInt ();
        for (int j = 0; j < q; j++) {
            int l = sc.nextInt ();
            int r = sc.nextInt ();
            int k = sc.nextInt ();
            int res = 0;
            for (int i = l; i <= r; i++) {
                if (arr[i] == k) res++;
            }
            System.out.println (res);
        }

    }
}
