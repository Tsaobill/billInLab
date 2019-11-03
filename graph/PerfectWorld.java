package graph;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-23 19:25
 **/
public class PerfectWorld {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
        int n = 3;
        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
//        int[][] g = new int[n + 1][n + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                int w = sc.nextInt ();
//                g[i][j] = w;
//            }
//        }
        int INF = 0x3f3f3f3f;
        Arrays.fill (dist, INF);
//
//        int[][] gg = new int[][]{
//                {0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 1, 12, INF, INF, INF},
//                {0, INF, 0, 9, 3, INF, INF},
//                {0, INF, INF, 0, INF, 5, INF},
//                {0, INF, INF, 4, 0, 13, 15},
//                {0, INF, INF, INF, INF, 0, 4},
//                {0, INF, INF, INF, INF, INF, 0},
//        };
        int[][] g = new int[][]{
                {INF, INF, INF, INF},
                {INF, INF, 2, 4},
                {INF, INF, INF, 1},
                {INF, INF, INF, INF},
        };


        dist[1] = 0;
        for (int i = 0; i <= n - 1; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min (dist[j], dist[t] + g[t][j]);
            }
            st[t] = true;
        }
        System.out.println (n);
//        for (int i = 2; i <= n; i++) {
//            int dis = dist[i] == INF ? -1 : dist[i];
//            System.out.println (dis);
//        }
    }

}
