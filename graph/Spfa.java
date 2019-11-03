package graph;

import java.util.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:17
 **/
public class Spfa {
    static int[] h, e, ne, w, dist;
    static boolean[] st;
    static int n, m;
    static int INF = 0x3f3f3f3f;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        h = new int[n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        int INF = 0x3f3f3f3f;
        Arrays.fill (dist, INF);
        Arrays.fill (h, -1);
        e = new int[m];
        ne = new int[m];
        w = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            int z = sc.nextInt ();
            e[i] = y;
            w[i] = z;
            ne[i] = h[x];
            h[x] = i;
        }

        String res = "";
        int d = spfa ();
        res += d == INF ? "impossible" : d;
        System.out.println (res);
    }

    static int spfa() {
        Queue<Integer> q = new LinkedList<> ();
        q.offer (1);
        dist[1] = 0;
        st[1] = true;
        while (!q.isEmpty ()) {
            int t = q.poll ();
            st[t] = false;
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > dist[t] + w[i]) {
                    dist[j] = dist[t] + w[i];
                    if (!st[j]) {
                        q.offer (j);
                        st[j] = true;
                    }
                }
            }

        }
        return dist[n] == INF ? -1 : dist[n];
    }
    /**
     * int n;      // 总点数
     * int h[N], w[N], e[N], ne[N], idx;       // 邻接表存储所有边
     * int dist[N], cnt[N];        // dist[x]存储1号点到x的最短距离，cnt[x]存储1到x的最短路中经过的点数
     * bool st[N];     // 存储每个点是否在队列中
     *
     * // 如果存在负环，则返回true，否则返回false。
     * bool spfa()
     * {
     *     // 不需要初始化dist数组
     *     // 原理：如果某条最短路径上有n个点（除了自己），那么加上自己之后一共有n+1个点，由抽屉原理一定有两个点相同，所以存在环。
     *
     *     // 判断负环全入队，dist数组不用初始化
     *     queue<int> q;
     *     for (int i = 1; i <= n; i ++ ) {
     *         q.push(i);
     *         st[i] = true;
     *     }
     *
     *     while (q.size()) {
     *         auto t = q.front();
     *         q.pop();
     *
     *         st[t] = false;
     *
     *         for (int i = h[t]; i != -1; i = ne[i]) {
     *             int j = e[i];
     *             if (dist[j] > dist[t] + w[i]) {
     *                 dist[j] = dist[t] + w[i];
     *                 cnt[j] = cnt[t] + 1;
     *
     *                 if (cnt[j] >= n) {
     *                     // 如果从1号点到x的最短路中包含至少n个点（不包括自己），则说明存在环
     *                     return true;
     *                 }
     *
     *                 if (!st[j]) {
     *                     q.push(j);
     *                     st[j] = true;
     *                 }
     *             }
     *         }
     *     }
     *
     *     return false;
     * }
     */
}
