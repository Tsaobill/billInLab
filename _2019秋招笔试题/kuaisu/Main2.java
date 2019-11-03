package _2019秋招笔试题.kuaisu;

import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-28 19:29
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int k = sc.nextInt ();
        String str = sc.next ();
        int len = str.length ();
        char[] c = str.toCharArray ();
        int res = 0;
        for (int i = k; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                int cnt = 0;
                for (int l = j; l < j+i; l++) {
                    if (c[l] == '1') cnt++;
//                    System.out.print (c[l]);
                    if (cnt > k) break;
                }
//                System.out.print (",");
                if(cnt == k) res++;
            }
//            System.out.println ();
        }
        System.out.println (res);
    }
}
