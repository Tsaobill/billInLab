package _2019秋招笔试题.tencent_0920;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-20 20:49
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt ();
        while (t-- > 0) {
            int n = sc.nextInt ();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt ();
            }
            Arrays.sort (arr);
            fun (arr);
        }
    }

    static void fun(int[] arr) {
        int sum1 = 0, sum2 = 0;
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            sum1 += (arr[lo++] + arr[hi--]);
            sum2 += (arr[lo++] + arr[hi--]);
        }
        if(sum1 > sum2){
            int t = sum1;
            sum1=sum2;
            sum2=t;
        }
        System.out.println (sum1 + " " + sum2);
    }
}
