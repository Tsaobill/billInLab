package _2019秋招笔试题.zhaohang_0923;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-23 20:30
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int[] arr = new int[n];
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
            if (i > 0 && arr[i] < arr[i - 1]) {
                idx = i;
            }
        }
        if (idx == 0) {
            System.out.println (0);
        } else {
            for (int i = 0; i < idx; i++) {
                if (arr[i] > 0) {
                    min = Math.min (min, arr[i]);
                }
            }
            System.out.println (m - min);
        }

    }
}
/*

10 9
6 4 1 6 0 4 1 2 3 7

5 7
0 1 1 4 6

4 7
3 5 6 0

 */