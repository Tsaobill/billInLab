package _2019秋招笔试题.xiaomi_0906;

import _2019秋招笔试题._DiDi.Main;

import java.util.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-11 19:46
 **/
public class Main3 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 7, 6};
        System.out.println (solution (arr));
    }

    static int solution(int[] arr) {
        int[] b = arr.clone ();
        Arrays.sort (b);
        int res1 = getMinSwaps (arr, b, b[b.length - 1]);
        reverse (b);
        int res2 = getMinSwaps (arr, b, b[0]);
        return (res1 > res2 ? res2 : res1);
    }

    static int getMinSwaps(int[] a, int[] b, int max) {
        int len = b.length;
        int[] m = new int[max + 1];
        for (int i = 0; i < len; i++) {
            m[b[i]] = i;
        }
        int loops = 0;
        boolean[] flag = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            if (!flag[i]) {
                int j = i;
                while (!flag[j]) {
                    flag[j] = true;
                    j = m[a[j]];
                }
                loops++;
            }
        }
        return len - loops;
    }

    static void reverse(int[] c) {
        int lo = 0, hi = c.length - 1;
        while (lo < hi) {
            int t = c[hi];
            c[hi] = c[lo];
            c[lo] = t;
            lo++;
            hi--;
        }
    }
}
