package _2019秋招笔试题.tencent_0920;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-20 20:31
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        List<Integer> list = new ArrayList<> (10000000);
        for (int i = 0; i < n; i++) {
            int c = sc.nextInt ();
            int val = sc.nextInt ();
            for (int j = 0; j < c; j++) {
                list.add (val);
            }
        }
        int len = list.size ();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = list.get (i);
        }
        Arrays.sort (arr);
        int lo = 0, hi = len-1;
        int max = 0;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            max = Math.max (sum, max);
            lo++;
            hi--;
        }
        System.out.println (max);
    }
}
