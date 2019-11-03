package graph;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:19
 **/
class Edge implements Comparable<Edge> {
    int num, cost;

    public Edge(int num, int cost) {
        this.num = num;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e) {
        return this.cost - e.cost;
    }
}


public class Dijkstra {
    static int n, m, INF = 0x3f3f3f3f;
    ;
    static int[] e, ne, w, h, dist;
    static boolean[] st;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt ();
        m = sc.nextInt ();
        h = new int[n + 1];
        dist = new int[n + 1];
        st = new boolean[n + 1];
        Arrays.fill (dist, INF);
        Arrays.fill (h, -1);
        e = new int[m];
        w = new int[m];
        ne = new int[m];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            int z = sc.nextInt ();
            e[i] = y;
            w[i] = z;
            ne[i] = h[x];
            h[x] = i;
        }

        int res = dijkstra ();
        System.out.println (res);
    }

    static int dijkstra() {
        PriorityQueue<Edge> heap = new PriorityQueue<> ();
        heap.offer (new Edge (1, 0));
        while (!heap.isEmpty ()) {
            Edge ver = heap.poll ();
            int u = ver.num;
            if (st[u]) continue;
            st[u] = true;
            for (int i = h[u]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > ver.cost + w[i]) {
                    dist[j] = ver.cost + w[i];
                    heap.offer (new Edge (j, dist[j]));
                }
            }
        }

        return dist[n] == INF ? -1 : dist[n];
    }

}
