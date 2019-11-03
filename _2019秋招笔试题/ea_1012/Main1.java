package _2019秋招笔试题.ea_1012;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-12 20:54
 **/
public class Main1 {
    public static void main(String[] args) {
        int n = new Scanner (System.in).nextInt ();
        if (n == 0) System.out.println (1);
        else if (n <= 2) System.out.println (n);
        else {
            BigInteger res = catelan (n);
            System.out.println (res.toString ());
        }
    }

    static BigInteger catelan(int n) {
        BigInteger bi = new BigInteger ("1");
        int i = 2;
        while (i <= n) {
            bi = bi.multiply (BigInteger.valueOf (4 * i - 2)).divide (BigInteger.valueOf (i + 1));
            i++;
        }
        return bi;
    }

    static long catelanLong(long n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        int res = 1;
        int i = 2;
        while (i <= n) {
            res = res * (4 * i - 2) / (i + 1);
            i++;
        }
        return res;
    }
}
