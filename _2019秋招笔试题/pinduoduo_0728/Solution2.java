package _2019秋招笔试题.pinduoduo_0728;

import java.util.Scanner;

/**
 * 字符串组成环
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-28 13:17
 **/
public class Solution2 {
    static boolean res;

    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        String[] strArr = sc.AllPermutation ().split (" ");
        String[] strArr = new String[]{"ABC", "CDC", "CBA","ADA"};
        System.out.println (canRing (strArr));
    }

    public static boolean canRing(String[] strArr) {

        helper (strArr, 0, strArr.length);
        return res;
    }

    public static void helper(String[] strArr, int k, int num) {
        if (k >= num) {
            if (judge (strArr[strArr.length - 1], strArr[0])) {
                res = true;
            }
            return;
        }
        for (int i = k; i < num; i++) {
            if (k > 0 && judge (strArr[k - 1], strArr[i])) {
                swap (strArr, k, i);
                helper (strArr, k + 1, num);
                swap (strArr, k, i);
            }
            if (k == 0) {
                swap (strArr, k, i);
                helper (strArr, k + 1, num);
                swap (strArr, k, i);
            }
        }

    }

    static void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    public static boolean judge(String str1, String str2) {
        return str1.charAt (str1.length () - 1) == str2.charAt (0);
    }
}
