package _2019秋招笔试题.bytedance_0825;

import java.util.Scanner;

/**
 * 3
 * 0 4 0
 * 4 0 0
 * 0 0 0
 * =====> 2
 * <p>
 * 3
 * 0 4 0
 * 4 0 6
 * 0 6 0
 * =====> 1
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-25 19:03
 **/
// flood fill
public class Main1 {
    public static void main(String[] args) {
        int n = 3;
        int[][] g = new int[][]{{0, 4, 0}, {4, 0, 6}, {0, 6, 0}};

        boolean[] st = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                res++;
                dfs (g, i, st);
            }
        }
        System.out.println (res);
    }

    static void dfs(int[][] g, int num, boolean[] st) {
        for (int i = 0; i < g.length; i++) {
            if (g[i][num] >= 3 && !st[i]) {
                st[i] = true;
                dfs (g, i, st);
            }
        }
    }
}
