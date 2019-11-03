package _2019秋招笔试题.baidu_0917;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-17 18:11
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int k = sc.nextInt ();
        int res = m + n;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                int sum = (n - i) * (m - j);
                if (sum <= k) {
                    res = Math.min (res, i + j);
                }
            }
        }
        System.out.println (res);
    }
}
