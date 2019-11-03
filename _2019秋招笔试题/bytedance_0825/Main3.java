package _2019秋招笔试题.bytedance_0825;

import java.util.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-25 20:04
 **/
class Main3 {
    public static void main(String[] args) {
        String[] D = new String[]{"1", "3", "5", "7"};
        int N = 100000;
        int res = atMostNGivenDigitSet (D, N);
        System.out.println ();
        System.out.println (res);
    }

    private static HashSet<Integer> set = new HashSet<> ();

    static int atMostNGivenDigitSet(String[] D, int N) {
        int n = N;
        int max = 0;
        while (n != 0) {
            max++;
            n /= 10;
        }
        String s = "asdf";
        s.indexOf ('Q');
        Queue<Integer> q = new LinkedList<> ();
        dfs (0, max, "", N, D);
        return res;
    }

    static int res = 0;

    static void dfs(int len, int max, String cur, int N, String[] D) {
        if (len == max) {
            long a = Long.valueOf (cur);

            if (a <= (long) N) {
//                set.add (Integer.valueOf (cur));
                System.out.println (cur + " ");
                res++;
            }
            return;
        }
        if (cur.length () > 0) {
            System.out.print (cur + " ");
//            set.add (Integer.valueOf (cur));
            res++;
        }
        for (int i = 0; i < D.length; i++) {
            cur = cur + D[i];
            dfs (len + 1, max, cur, N, D);
            cur = cur.substring (0, cur.length () - 1);
            // dfs (len, max, cur, N, D);
        }
    }
}