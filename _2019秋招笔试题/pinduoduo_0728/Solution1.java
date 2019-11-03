package _2019秋招笔试题.pinduoduo_0728;

/**
 * 第一题
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-28 13:16
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner (System.in);
//        String str1 = in.nextLine ();
//        String str2 = in.AllPermutation ();
//        int[] arrA = toIntArray (str1);
//        int[] arrB = toIntArray (str2);
        int[] arrA = new int[]{1, 3, 4, 5, 6, 7, 7};
        int[] arrB = new int[]{2, 5, 8, 6};

        int idxA = -1;
        for (int i = 0; i < arrA.length - 1; i++) {
            if (arrA[i] >= arrA[i + 1]) {
                idxA = i + 1;
                break;
            }
        }

        int res = -1;
        for (int i = 0; i < arrB.length; i++) {
            if (arrB[i] > arrA[idxA - 1] && (idxA == arrA.length - 1 || arrB[i] < arrA[idxA + 1])) {
                res = res < arrB[i] ? arrB[i] : res;
            }
        }

        if (res == -1) {
            for (int i = 0; i < arrB.length; i++) {
                if ((idxA == 1 || arrB[i] > arrA[idxA - 2]) && arrB[i] < arrA[idxA]) {
                    res = res < arrB[i] ? arrB[i] : res;
                }
            }
        } else {
            arrA[idxA] = res;
            System.out.println (Arrays.toString (arrA));
            return;
        }

        if (res == -1) {
            System.out.println ("NO");
        } else {
            arrA[idxA - 1] = res;
            System.out.println (Arrays.toString (arrA));
        }
    }

    public static int[] toIntArray(String str) {
        String[] strs = str.split (" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.parseInt (strs[i]);

        }
        return arr;
    }
}