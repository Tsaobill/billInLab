package _2019秋招笔试题.ea_0921;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 20:22
 **/
public class Main1 {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[][] evo = new int[n][2];
        for (int i = 0; i < n; i++) {
            evo[i][0] = sc.nextInt ();
            evo[i][1] = sc.nextInt ();
        }
        Arrays.sort (evo, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else return a[0] - b[0];
        });
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < 2; j++) {
//                System.out.print (evo[i][j]+" ");
//            }
//            System.out.println ();
//        }
        int inf = 1 << 30;
        dp = new int[n];
        int len = 0;
        int _count = 0;
        int maxlen = -inf;
        boolean[] mark = new boolean[n];
        while (true) {
            dp = new int[n];
            dp[0] = -inf;
            len = 0;
            for (int i = 0; i < n; i++) {
                if (mark[i]) continue;
                int pos = Search (0, len, evo[i][1]);
                dp[pos] = evo[i][1];
                if (pos > len) {
                    len++;
                    mark[i] = true;
                }
            }
            if (len > maxlen) {
                maxlen = len;
                _count = 1;
            } else if (len == maxlen) _count++;
            else break;
        }
        System.out.println (_count);
    }

    static int mod = 1000000007;

    static int Search(int low, int high, int number) {
        while (low <= high) {
            int mid = (low + high) >> 1;
            if (dp[mid] == number) return mid;
            else if (dp[mid] > number) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

}
/*
4
1 2
3 4
4 2
3 4
 */