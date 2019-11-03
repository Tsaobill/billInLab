package rmq;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-15 17:06
 **/
/*
    http://blog.csdn.net/zztant/article/details/8535764
 */

public class RangeMaxQuery_SegTree {
    public static void main(String[] args) {
        int[] arr = {0, 2, 4, 3, 1, 6, 7, 8, 9, 1, 7};
        n = arr.length;
        MinP = new int[n << 2];
        MaxP = new int[n << 2];
        build (1, n - 1, arr, 1);
        query (1, 1, n - 1, 5, 9);
        System.out.println (minT);
        System.out.println (maxT);
    }

    static int n;
    static int[] MinP, MaxP;
    static int minT = Integer.MAX_VALUE, maxT = Integer.MIN_VALUE;

    static void build(int l, int r, int[] arr, int node) {
        if (l == r) {
            MinP[node] = arr[l];
            MaxP[node] = arr[l];
            return;
        }
        int mid = l + r >> 1;
        build (l, mid, arr, node << 1);
        build (mid + 1, r, arr, node << 1 | 1);
        MinP[node] = Math.min (MinP[node << 1], MinP[node << 1 | 1]);
        MaxP[node] = Math.max (MaxP[node << 1], MaxP[node << 1 | 1]);
    }

    static void update(int val, int K, int l, int r, int p) {
        int m = l + r >> 1;
        if (l == r) {
            MaxP[p] = MinP[p] = val;
            return;
        }
        if (K <= m) update (val, K, l, m, p << 1);
        else update (val, K, m + 1, r, p << 1 | 1);

        MaxP[p] = Math.max (MaxP[p << 1], MaxP[p << 1 | 1]);
        MinP[p] = Math.min (MinP[p << 1], MinP[p << 1 | 1]);
    }

    static void query(int node, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            minT = Math.min (minT, MinP[node]);
            maxT = Math.max (maxT, MaxP[node]);
            return;
        }
        int m = l + r >> 1;
        if (L <= m) query (node << 1, l, m, L, R);
        if (R >= m + 1) query (node << 1 | 1, m + 1, r, L, R);
    }

}
