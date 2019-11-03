package _2019秋招笔试题.meituan_0918;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-18 16:23
 **/
public class Main2 {
    /**
     * 匹配司机
     */
    public static void main(String[] args) {
        int n = 3;
        double[][] A = new double[][]{{1.08, 1.25, 1.5},
                {1.5, 1.35, 1.75},
                {1.22, 1.48, 2.5}
        };
        int[] res = new int[n];
        boolean[] st = new boolean[n];
        dfs (0, 0.0, res, st, A, n);
        int[] aa = map.get (sum);
        String ansStr = String.format ("%.2f", sum);
        System.out.println (ansStr);
        for (int i = 0; i < n; i++) {
            System.out.println ((i + 1) + " " + (aa[i] + 1));
        }
    }

    static double sum = 0;
    static Map<Double, int[]> map = new HashMap<> ();

    static void dfs(int k, double path, int[] arr, boolean[] st, double[][] A, int n) {
        if (k == n) {
            if (sum < path) {
                sum = path;
                map.put (path, arr.clone ());
            }
        }
        for (int i = 0; i < n; i++) {
            if (!st[i]) {
                st[i] = true;
                arr[k] = i;
                dfs (k + 1, path + A[k][i], arr, st, A, n);
                st[i] = false;
            }
        }
    }
}
