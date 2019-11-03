package _2019秋招笔试题.tencent_0920;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-20 21:29
 **/
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        HashSet<Integer> set = new HashSet<> ();

        for (int i = 0; i < n; i++) {
            int e = sc.nextInt ();
            if (set.contains (e)) {
                set.remove (e);
            } else {
                set.add (e);
            }
        }
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt ();
        }
        int res = 0;
        for (int e : set) {
            for (int j = 0; j < n; j++) {
                res ^= (e + arr2[j]);
            }
        }
        System.out.println (res);
    }
}
/*
6
4 6 0 0 3 3
0 5 6 5 0 3
8


5
1 2 1 0 0
1 2 3 0 0
2
 */