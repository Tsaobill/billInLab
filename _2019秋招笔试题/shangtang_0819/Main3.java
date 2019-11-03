package _2019秋招笔试题.shangtang_0819;

import java.math.BigInteger;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-19 19:50
 **/
public class Main3 {
    public static void main(String[] args) {
        int n = 10;
        int a = 2, b = 3, c = 4, init = 100;
        BigInteger A = BigInteger.valueOf (a);
        BigInteger B = BigInteger.valueOf (b);
        BigInteger C = BigInteger.valueOf (c);
        BigInteger cost = BigInteger.valueOf (32767);
        int MOD = 1000000007;
        BigInteger l1 = BigInteger.valueOf (init), l2 = BigInteger.valueOf (0L), l3 = BigInteger.valueOf (0L);
        BigInteger res = BigInteger.valueOf (0L);
        for (int i = 1; i <= n; i++) {
            BigInteger part = BigInteger.valueOf (i).multiply (BigInteger.valueOf (i)).multiply (BigInteger.valueOf (2)).min (BigInteger.valueOf (i));
            res = l1.multiply (A).add (l2.multiply (B)).add (l3.multiply (C)).add (part).add (cost);
            l3 = l2;
            l2 = l1;
            l1 = res;
        }
        System.out.println (res.mod (BigInteger.valueOf (MOD)).intValue ());
    }
}
