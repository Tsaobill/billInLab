package _2019秋招笔试题.ebay_1017;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-17 19:47
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int limit = sc.nextInt ();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
        }
        Arrays.sort (arr);
        int ans =0;
        if(n==1) System.out.println (arr[0]);
        else {
            ans =help (arr,arr.length);
        }

        System.out.println (ans);
    }

    static int help(int[] arr, int n) {
        int sum = 0;
        int i = n - 1;
        while (i > 2) {
            int m = cal (arr[0], arr[1], arr[i - 1], arr[i]);
            sum += m;
            i -= 2;
        }
        if (i == 2) {
            sum += arr[0] + arr[1] + arr[2];
        } else
            sum += arr[1];
        return sum;
    }

    static int cal(int a, int b, int y, int z) {
        return Math.min (z + a + y + a, b + a + z + b);
    }
}
