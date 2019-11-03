package rmq;

import java.io.*;
import java.util.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-15 16:53
 **/
class SegTree {
    // start 和 end 是区间范围
    int start;
    int end;
    long dat; // 记录的信息（最值，统计值）
    long tag; // 懒标记
}
public class AcWing243{
    static class FR {
        BufferedReader br;
        StringTokenizer tk;

        FR(InputStream stream) {
            br = new BufferedReader (new InputStreamReader (stream), 32768);
            tk = null;
        }

        String next() {
            while (tk == null || !tk.hasMoreElements ()) {
                try {
                    tk = new StringTokenizer (br.readLine ());
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            return tk.nextToken ();
        }

        int nextInt() {
            return Integer.parseInt (next ());
        }
    }
    static void solve(InputStream stream, PrintWriter out) {
        FR sc = new FR (stream);

        //  start code.....
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        int[] arr = new int[n + 1];
        SegTree[] tree = new SegTree[n << 2 + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new SegTree ();
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt ();
        }
        build_ (arr, tree, 1, 1, n);
        while (m-- > 0) {
            String str = sc.next ();
            int l = sc.nextInt (), r = sc.nextInt ();
            if (str.equals ("Q")) {
                System.out.println (query_ (tree, 1, l, r));
            } else {
                int val = sc.nextInt ();
                update_ (tree, 1, l, r, val);
            }
        }

    }
    public static void main(String[] args) {
        OutputStream os = System.out;
        InputStream is = System.in;
        PrintWriter out = new PrintWriter (os);
        solve (is, out);
        out.close (); // 不关闭就没有输出
    }

    // 1. 建树，初始调用 build(1, 1, n);
    static void build_(int[] arr, SegTree[] tree, int rt, int l, int r) {
        if (l == r) {
            tree[rt].dat = arr[l];
            tree[rt].start = l;
            tree[rt].end = r;
//            System.out.println ("rt:" + rt + " l:" + l + " r:" + r + " " + idx++);
            // 单点区间不能再分，递归结束
            return;
        }

        // 递归左右子树
        int mid = l + r >> 1;
        build_ (arr, tree, rt << 1, l, mid);
        build_ (arr, tree, rt << 1 | 1, mid + 1, r);

        //回溯时更新
        tree[rt].dat = tree[rt << 1].dat + tree[rt << 1 | 1].dat;
        tree[rt].start = tree[rt << 1].start;
        tree[rt].end = tree[rt << 1 | 1].end;
    }


    // 2. 懒标记
    static void spread_(SegTree[] tree, int rt) {
        if (tree[rt].tag != 0) {
            int ls = rt << 1, rs = rt << 1 | 1;
            long lazy = tree[rt].tag;
            // 修改区间信息并更新懒标记
            tree[ls].dat += lazy * (tree[ls].end - tree[ls].start + 1);
            tree[ls].tag += lazy;

            tree[rs].dat += lazy * (tree[rs].end - tree[rs].start + 1);
            tree[rs].tag += lazy;

            // 大区间信息已经传递给下一层，因此要清零。
            tree[rt].tag = 0;
        }
    }

    // 3. 区间修改
    static void update_(SegTree[] tree, int rt, int l, int r, int val) {
        if (l <= tree[rt].start && r >= tree[rt].end) {
            // 如果一个结点表示的区间被修改区间覆盖，那它就是连续区间的一段
            // 如果它所包含的小区间都不用修改，只要修改懒标记就行了
            tree[rt].dat += val * (tree[rt].end - tree[rt].start + 1);
            tree[rt].tag += val;

            return;// 因为不用修改，直接返回就行
        }
        // 保证懒标记只在最新的区间上
        spread_ (tree, rt);

        int mid = tree[rt].start + tree[rt].end >> 1;

        if (l <= mid) update_ (tree, rt << 1, l, r, val);
        if (r >= mid + 1) update_ (tree, rt << 1 | 1, l, r, val);

        // 递归回溯时修改dat
        tree[rt].dat = tree[rt << 1].dat + tree[rt << 1 | 1].dat;
    }

    static long query_(SegTree[] tree, int rt, int l, int r) {
        if (l <= tree[rt].start && r >= tree[rt].end) {
            return tree[rt].dat;
        }
        spread_ (tree, rt);

        int mid = tree[rt].start + tree[rt].end >> 1;
        long ans = 0;
        if (l <= mid) ans += query_ (tree, rt << 1, l, r);
        if (r >= mid + 1) ans += query_ (tree, rt << 1 | 1, l, r);
        return ans;
    }
}


