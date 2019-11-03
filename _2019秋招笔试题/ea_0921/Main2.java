package _2019秋招笔试题.ea_0921;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 20:25
 **/

public class Main2 {
    static int n, m, gold, INF = 0x3f3f3f3f;
    static int[] e, ne, w, g, h, dist;
    static boolean[] st;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        gold = sc.nextInt ();
        e = new int[m];
        h = new int[n + 1];
        w = new int[m];
        g = new int[m];
        ne = new int[m];
        Arrays.fill (h, -1);

        for (int i = 0; i < m; i++) {
            int x = 1 + sc.nextInt ();
            int y = 1 + sc.nextInt ();
            int we = sc.nextInt ();
            int go = sc.nextInt ();
            e[i] = y;
            ne[i] = h[x];
            w[i] = we;
            g[i] = go;
            h[x] = i;
        }
        st = new boolean[n + 1];
        dist = new int[n + 1];
        dfs (1, 0, 0, st);
        System.out.println (min == INF ? -1 : min);
    }

    /*
4 4 20
0 1 1 10
0 2 1 10
1 2 1 10
2 3 1 10
     */
    static int min = INF;

    static void dfs(int curPoint, int dist, int goldCost, boolean[] st) {
        if (goldCost > gold) return;
        if (curPoint == n) {
            min = Math.min (min, dist);
            return;
        }
        for (int i = h[curPoint]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                dfs (j, dist + w[i], goldCost + g[i], st);
                st[j] = false;
            }
        }
    }
}