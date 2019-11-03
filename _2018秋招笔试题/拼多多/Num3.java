package _2018秋招笔试题.拼多多;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2018-10-21 下午3:31
 **/
public class Num3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int k = sc.nextInt ();
        func (n, k);
    }

    static void func(int n, int k) {
        int m = (n / 2) * ((n + 1) / 2);
        if (k > m) {
            System.out.println ("-");
            return;
        }
        StringBuilder sb = new StringBuilder ();
        if (k == m) {
            for (int i = 0; i < n / 2; i++) {
                sb.append ("A");
            }
            for (int i = 0; i < (n + 1) / 2; i++) {
                sb.append ("B");
            }
            System.out.println (sb.toString ());
            return;
        }
        int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = (i / 2) * ((i + 1) / 2);
        }
        int l = bs (arr, k);
        for (int i = 0; i < n - l; i++) {
            sb.append ("B");
        }

        sb.append ("A");
        int ass;
        while ((l/2)*((l+1)/2) - k > 2) {
            sb.append ("B");
            m--;
        }
        sb.append ("A");
        for (int i = 0; i < l - 3; i++) {
            sb.append ("B");
        }
        System.out.println (sb.toString ());
    }

    static int bs(int[] a, int key) {
        int lo = 2, hi = a.length - 1;

        while (lo < hi - 1) {
            int mid = (lo + hi) / 2;
            if (a[mid] > key) hi = mid;
            else lo = mid;
        }
        if (a[lo] >= key) return lo;
        return hi;
    }
}
