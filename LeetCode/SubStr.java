package LeetCode;


import java.security.DrbgParameters;
import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-03 01:04
 **/
public class SubStr {
    public static void main(String[] args) {
        SubStr ss = new SubStr ();
        String hay = "baaa";
        String ned = "aaa";
        System.out.println (ss.matcherKMP (hay, ned));


    }

    // kmp 主算法
    private int matcherKMP(String haystack, String needle) {
        char[] s = haystack.toCharArray ();
        char[] p = needle.toCharArray ();
        int[] next = getNextArray (p);
        int i = 0, j = 0;

        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == p.length ? i - j : -1;
    }


    // AllPermutation 数组求解方法
    private int[] getNextArray(char[] p) {
        int pLen = p.length;
        int[] next = new int[pLen];
        next[0] = -1;// 重要！！！！
        int i = 0, j = -1;

        while (i < pLen - 1) {
            if (j == -1 || p[i] == p[j]) {
                i++;
                j++;
                next[i] = p[i] == p[j] ? next[j] : j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
}
