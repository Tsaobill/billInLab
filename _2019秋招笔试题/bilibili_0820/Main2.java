package _2019秋招笔试题.bilibili_0820;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-20 19:28
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String string = sc.nextLine ();

        String[] nums = string.split (",");
        StringBuilder sb = new StringBuilder ();
        for (String str : nums) {
            sb.append (str);
        }

        res = new BigInteger (sb.toString ());
        helper (nums, 0);
        System.out.println (res.toString ());

    }

    static BigInteger res = new BigInteger ("0");

    static void helper(String[] nums, int cur) {
        if (cur == nums.length) {
            StringBuilder sb = new StringBuilder ();
            for (String str : nums) {
                sb.append (str);
            }
            BigInteger bi = new BigInteger (sb.toString ());
            res = bi.min (res);
            return;
        }
        for (int i = cur; i < nums.length; i++) {
            swapArr (nums, i, cur);
            helper (nums, i + 1);
            swapArr (nums, i, cur);
        }
    }

    static void swapArr(String[] arr, int m, int n) {
        String temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
