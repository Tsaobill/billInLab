package _2019秋招笔试题._58tongcheng_0912;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-12 21:05
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
        }
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            int pre = 1;
            if (i > 0 && arr[i] > arr[i - 1]) {
                pre = f[i - 1] + 1;
            }
            int t = i + 1;
            int next = 1;
            while (t < n && arr[t] <= arr[i] && arr[t] < arr[t - 1]) {
                next++;
                t++;
            }
            f[i] = Math.max (pre, next);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += f[i];
        }
        System.out.println (sum);
    }
}
