package graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-27 21:41
 **/
public class binaryGraph {

    static int[] e, ne, h;
    static int n, m, idx;
    static boolean[] c, st;
    static boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        e = new int[m];
        ne = new int[m];
        h = new int[n + 1];
        c = new boolean[n + 1];
        st = new boolean[n + 1];
        Arrays.fill (h, -1);

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            add (x, y);
        }

        for (int i = 1; i <= n; i++) {
            if (!st[i]) {
                dfs (i);
            }
            if (!flag) break;
        }
        System.out.println (flag ? "Yes" : "No");
    }

    static void dfs(int x) {
        st[x] = true;
        for (int i = h[x]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                c[j] = !c[x];
                dfs (j);
            } else if (c[j] == c[x] && j != x) flag = false;
        }
    }

    static void add(int x, int y) {
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }
}
