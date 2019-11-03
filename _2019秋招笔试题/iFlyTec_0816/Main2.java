package _2019秋招笔试题.iFlyTec_0816;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-16 18:32
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        str = str.substring (1, str.length () - 1);
        String[] strArr = str.split (",");
        int idx = 0;
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals ("")) {
                System.out.println (-1);
                return;
            }
            arr[idx++] = Integer.valueOf (strArr[i]);
        }
        int KEY = 19;
        int res = recursiveBinarySearch (arr, KEY, 0, arr.length - 1);
        if (res == -1) System.out.println (-1);
        else System.out.println (res + 1);
    }

    public static int recursiveBinarySearch(int[] arr, int key, int lo, int hi) {
        if (lo > hi) return -1;
        if (lo == hi) {
            return arr[lo] == key ? lo : -1;
        }
        int m = lo + (hi - lo) / 2;
        if (arr[m] > key) {
            return recursiveBinarySearch (arr, key, lo, m - 1);
        } else if (arr[m] < key) {
            return recursiveBinarySearch (arr, key, m + 1, hi);
        } else {
            return m;
        }
    }
}
