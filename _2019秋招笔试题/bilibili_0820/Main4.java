package _2019秋招笔试题.bilibili_0820;

import java.math.BigInteger;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-20 20:11
 **/
public class Main4 {
    public static void main(String[] args) {

        String[] strArr = new String[]{"32", "231", "123"};
        StringBuilder sb = new StringBuilder ();
        for (String str : strArr) {
            sb.append (str);
        }
        min = sb.toString ();
        helper (strArr, 0);
        System.out.println (min);

    }

    static String min = "";

    static void helper(String[] words, int k) {
        if (k == words.length) {
            String res = getNum (words);
            getMin (res);
            return;
        }
        for (int i = k; i < words.length; i++) {
            swap (words, i, k);
            helper (words, k + 1);
            swap (words, i, k);
        }
    }

    static String getNum(String[] nums) {
        StringBuilder sb = new StringBuilder ();
        for (String str : nums) {
            sb.append (str);
        }
        return sb.toString ();
    }

    static void getMin(String string) {
        for (int i = 0; i < string.length (); i++) {
            if (min.charAt (i) > string.charAt (i)) {
                min = string;
                break;
            }
        }
    }

    static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
