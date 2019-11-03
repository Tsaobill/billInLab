package _2019秋招笔试题.baidu_0917;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-17 18:11
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int round = sc.nextInt ();
        while (round > 0) {
            int n = sc.nextInt ();
            int m = sc.nextInt ();
            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {
                edges[i] = new Edge (sc.nextInt (), sc.nextInt (), 1);
            }
            int k = 2;
            int res = bellmanFord (edges, n, k);
            System.out.println (res == -1 ? "IMPOSSIBLE" : "POSSIBLE");
            round--;
        }
    }

    static int INF = Integer.MAX_VALUE;

    // 与Dijkstra和spfa 的区别是用 边数组更新路径
// 有负权边的一般判断是否有解 看是否小于0x3f3f3f3f / 2
// 是的话有解，否则无解
// k可以指定，也可以遍历n-1次，
// 注意：松弛循环，复制一个dist数组来
    static int bellmanFord(Edge[] e, int n, int k) {
        int m = e.length;
        int[] dist = new int[n + 1];
        Arrays.fill (dist, 0x3f3f3f3f);
        dist[1] = 0;
        int[] copy = new int[n + 1];
        for (int i = 0; i < k; i++) { // 边数限制
            copy = dist.clone ();
            for (int j = 0; j < m; j++) {
                int a = e[j].u, b = e[j].v, c = e[j].w;
                dist[b] = Math.min (dist[b], c + copy[a]); //a的dist用copy数组
            }
        }
        return dist[n] < 0x3f3f3f3f / 2 ? dist[n] : -1;
    }
}

// 一般存边数组。
class Edge {
    int u;
    int v;
    int w;

    public Edge(int a, int b, int c) {
        u = a;
        v = b;
        w = c;
    }
}


