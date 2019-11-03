package _2019秋招笔试题._360_0831;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-31 16:40
 **/
public class Main2 {
    public static void main(String[] args) {
        int n = 10;
        int m = 3;
        int[] arr = new int[]{5, 2, 6};

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dfs (arr, 0, i, n)) {
                res++;
            }
        }
        System.out.println (res);
    }
    static boolean dfs(int[] arr, int k, int dist, int n) {
        if (k == arr.length)  return true; // 说明该起点成立
        if (dist - arr[k] > 0) { // 可以向左走
            if (dfs (arr, k + 1, dist - arr[k], n)) {
                return true;
            }
        }
        if (dist + arr[k] <= n) {// 可以向右走
            if (dfs (arr, k + 1, dist + arr[k], n)) {
                return true;
            }
        }
        return false;
    }
}