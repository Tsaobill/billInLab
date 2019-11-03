package _2019秋招笔试题._DiDi;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-27 19:31
 **/
public class Main {
    public static void main(String[] args) {
        int n = 10;
        String exp = "3 + 2 + 1 + -4 * -5 + 3 + 1 * 7 * 6 + 2";
        String[] strs = exp.split (" ");
        String[] back = strs.clone ();
        int j = 0;
        int[] nums = new int[n];
        for (int i = 0; i < back.length; i++) {
            if (back[i].equals ("-")) {
                back[i] = "+";
            }
            if (back[i].equals ("/")) {
                back[i] = "*";
            }
            if (i % 2 == 0) {
                nums[j++] = Integer.valueOf (back[i]);
            }
        }
        int idx = 1;
        int lo = 0;
        String cop = strs[1];
        boolean f = true;
        while (idx < back.length) {
            while (idx < back.length && cop.equals (back[idx])) {
                idx += 2;
            }
            int h = idx / 2;
            if (f || cop.equals ("*")) {
                h = (idx - 2) / 2;
                f = false;
            }
            sort (nums, lo, h);
            if (idx >= back.length) break;
            lo = h + 1;
            cop = back[idx];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print (nums[i] + " " + strs[2 * i + 1] + " ");
        }
        System.out.println (nums[nums.length - 1]);
    }

    static void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int m = par (arr, lo, hi);
            sort (arr, lo, m - 1);
            sort (arr, m + 1, hi);
        }
    }

    static int par(int[] arr, int lo, int hi) {
        int m = lo, i;
        for (i = lo + 1; i <= hi; i++) {
            if (arr[i] < arr[lo]) {
                swap (arr, i, ++m);
            }
        }
        swap (arr, lo, m);
        return m;
    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
