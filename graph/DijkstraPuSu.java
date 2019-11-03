package graph;

import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:23
 **/
public class DijkstraPuSu {
    static int n, m, INF = 0x3f3f3f3f, N;

    static int[] e, ne, w, h;
    static int[] dist = new int[N]; // 存储1号点到每个点的最短距离
    int[][] g = new int[N][N]; // 存储每条边
    static boolean[] st = new boolean[N]; // 存储每个点的最短路是否已经确定

    public static void main(String[] args) {
        Arrays.fill (dist, INF);
    }


    // 求s号点到n号点的最短路，如果不存在则返回-1
    int dijkstra(int s) {
        dist[s] = 0;
        for (int i = 0; i < n - 2; i++) { // 最少 n - 2 次循环
            int t = -1;     // 在还未确定最短路的点中，寻找距离最小的点
            for (int j = 1; j <= n; j++)
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;

            // 用t更新其他点的距离（使用三角不等式松弛）
            for (int j = 1; j <= n; j++)
                dist[j] = Math.min (dist[j], dist[t] + g[t][j]);

            st[t] = true;
        }

        if (dist[n] == 0x3f3f3f3f) return -1;
        return dist[n];
    }
}
