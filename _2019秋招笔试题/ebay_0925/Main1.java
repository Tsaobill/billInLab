package _2019秋招笔试题.ebay_0925;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-25 19:47
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        int n = str.length ();
        for (int i = 1; i <= n; i++) {
            String s = str.substring (0, i);
            boolean res = match (str, s);
            if (!res) System.out.print (0);
            else System.out.print (1);
        }
    }

    static boolean match(String str, String tar) {
        int tlen = tar.length ();
        int slen = str.length ();
        int rount = 1;
        int idx = 0;
        while (rount < slen / tlen) {
            if (tar.charAt (idx) != str.charAt (idx + rount * tlen)) return false;
            idx++;
            if (idx == tlen) {
                rount++;
                idx = 0;
            }
        }
        for (int i = 0; i < slen - rount * tlen; i++) {
            if (tar.charAt (i) != str.charAt (i+rount*tlen)) return false;
        }
        return true;
    }
}
