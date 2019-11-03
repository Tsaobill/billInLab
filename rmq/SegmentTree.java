package rmq;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-16 19:32
 **/
public class SegmentTree {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[]{0, 11, 15, -12, -16, 18, -8, -4, -9, 16, 18};
        int[] tree = new int[n << 2];

        build_tree (arr, tree, 1, 1, n);
        System.out.println (query_tree (arr, tree, 1, 1, n, 7, 8));
        update_tree (arr, tree, 1, 1, n, 5, 10, -4);
        System.out.println (query_tree (arr, tree, 1, 1, n, 6, 6));
        update_tree (arr, tree, 1, 1, n, 3, 4, 2);
        System.out.println (query_tree (arr, tree, 1, 1, n, 1, 4));

    }

    // 1. 建树
    static void build_tree(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }
        int mid = start + end >> 1;
        build_tree (arr, tree, node << 1, start, mid);
        build_tree (arr, tree, node << 1 | 1, mid + 1, end);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    // 2. 区间修改===想要lgn的修改，就要使用懒标记( 大数据会超时)
    static void update_tree(int[] arr, int[] tree, int node, int start, int end, int L, int R, int val) {
        if (start == end) {
            tree[node] += val;
            arr[start] += val;
            return;
        }
        int mid = start + end >> 1;
        if (mid >= L) update_tree (arr, tree, node << 1, start, mid, L, R, val);
        if (mid + 1 <= R) update_tree (arr, tree, node << 1 | 1, mid + 1, end, L, R, val);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    // 3. 区间查询
    static int query_tree(int[] arr, int[] tree, int node, int start, int end, int L, int R) {
        if (L <= start && R >= end) {
            return tree[node];
        }
        int ans = 0;
        int mid = start + end >> 1;
        if (L <= mid) ans += query_tree (arr, tree, node << 1, start, mid, L, R);
        if (mid + 1 <= R) ans += query_tree (arr, tree, node << 1 | 1, mid + 1, end, L, R);
        return ans;
    }


}
