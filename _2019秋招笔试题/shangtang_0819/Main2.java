package _2019秋招笔试题.shangtang_0819;

import java.util.Scanner;

/**
 * 最长的山峰
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-19 18:59
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
        }
        System.out.println (getMountain (arr));

    }


    static int getMountain(int[] arr) {
        int start = 0;
        int maxLen = 0;
        boolean grow = false;
        boolean shrink = false;
        int i = 1;
        while (i < arr.length) {
            // need grow before shrink
            while (i != arr.length && arr[i - 1] < arr[i]) {
                i++;
                grow = true;
            }

            // also shrink to be mountain
            while (i != arr.length && arr[i - 1] > arr[i] && grow) {
                i++;
                shrink = true;
            }

            if (shrink) {
                maxLen = Math.max (maxLen, i - start);
            } else i++;

            // 重置
            start = i - 1;
            grow = false;
            shrink = false;
        }
        return maxLen;
    }
}
