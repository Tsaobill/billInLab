package _2019秋招笔试题.tencent_0920;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-20 20:05
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt ();
        while (t-- > 0) {
            int n = sc.nextInt ();
            String str = sc.next ();
            if (n < 11) {
                System.out.println ("NO");
            } else {
                boolean flag = false;
                for (int i = 0; i < n - 10; i++) {
                    if ((str.charAt (i) - '0') == 8) {
                        flag = true;
                        break;
                    }
                }
                System.out.println (flag ? "YES" : "NO");
            }
        }
    }
}
