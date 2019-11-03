package _2019秋招笔试题.bytedance_0825;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-25 19:03
 **/
public class Main2 {
    public static void main(String[] args) {
        int n1 = 6;
        int n2 = 10;
        int res = catelan (125);
        System.out.println (res);
    }

    static int catelan(int n) {
        if (n == 0) return 1;
        if (n <= 2) return n;
        BigInteger bi = new BigInteger ("1");
        int i = 2;
        while (i <= n) {
            bi = bi.multiply (BigInteger.valueOf (4 * i - 2)).divide (BigInteger.valueOf (i + 1));
            i++;
        }
        return bi.mod (BigInteger.valueOf (1000000007L)).intValue ();
    }
}
