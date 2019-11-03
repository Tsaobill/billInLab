package rmq;

import java.util.ArrayList;
import java.util.Map;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-15 17:07
 **/
public class RangeMaxQuery_SparseTable {
    static int[] arr;
    static int[][] maxn, minn;
    static int n, k;

    public static void main(String[] args) {
        int[] arr = {2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
        n = arr.length;
        RangeMaxQuery_SparseTable.arr = arr;
        initial ();
        int l, r;
        l = 5;
        r = 8;
        System.out.println (query (l, r));
    }

    static void initial() {
        k = log (n) + 1;
        maxn = new int[n + 1][k + 1];
        minn = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            maxn[i][0] = arr[i - 1];
            minn[i][0] = arr[i - 1];
        }
        for (int j = 1; j < k; j++) {
            for (int i = 1; i + (1 << j) - 1 <= n; i++) {
                maxn[i][j] = Math.max (maxn[i][j - 1], maxn[i + (1 << j - 1)][j - 1]);
                minn[i][j] = Math.min (minn[i][j - 1], minn[i + (1 << j - 1)][j - 1]);
            }
        }
    }

    static int query(int l, int r) {
        int k = log (r - l + 1);
        int max = Math.max (maxn[l][k], maxn[r - (1 << k) + 1][k]);
        int min = Math.min (minn[l][k], minn[r - (1 << k) + 1][k]);
        int max_min = max - min;
        return max_min;
    }

    static int log(int n) {
        return (int) (Math.log (n) / Math.log (2));
    }

}
