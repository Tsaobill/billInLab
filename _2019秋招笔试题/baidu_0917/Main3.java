package _2019秋招笔试题.baidu_0917;

import _2019秋招笔试题._DiDi.Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 两个属性
 * 最小生成树中最大的 一个属性， 和最大的另一个属性，分别乘一个系数的和的最小值
 * 思路：根据属性A建MST求目标值，根据属性B建MST求目标值，输出小的那个。
 * @version 1.0
 * @created by bill
 * @on 2019-09-17 19:46
 **/
public class Main3 {

    static int[][][] g;
    static int[] dist;
    static boolean[] st;
    static int n, m, INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        int fa = sc.nextInt ();
        int fb = sc.nextInt ();
        g = new int[n + 1][n + 1][2];
        st = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill (dist, INF);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == j) {
                    g[i][j][0] = 0;
                    g[i][j][1] = 0;
                } else {
                    g[i][j][0] = INF;
                    g[i][j][1] = INF;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            int z = sc.nextInt ();
            int zz = sc.nextInt ();
            g[x][y][0] = z;
            g[x][y][1] = zz;
            g[y][x][0] = g[x][y][0];
            g[y][x][1] = g[x][y][1];
        }

        int res1 = prim (0);
        int res2 = prim (1);
        int k = fa * res1 + fb + res2;
        System.out.println (k);
    }

    static int prim(int idx) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }
            if (i > 0 && dist[t] == INF) return INF;
            if (i > 0) res += dist[t];

            st[t] = true;
            for (int j = 1; j <= n; j++) dist[j] = Math.min (dist[j], g[t][j][idx]);
        }
        int max = dist[0];
        for (int i = 0; i <= n; i++) {
            max = Math.max (max, dist[i]);
        }
        return res;
    }
}
