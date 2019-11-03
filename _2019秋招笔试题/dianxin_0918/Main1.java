package _2019秋招笔试题.dianxin_0918;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-18 20:55
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt ();
        }
        int res = 0;
        for (int e : arr) {
            res ^= e;
        }
        System.out.println (res);
    }
}
