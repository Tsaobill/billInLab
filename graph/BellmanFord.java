package graph;

import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:18
 **/
public class BellmanFord {
    // 一般存边数组。
    class Edge{
        int u; int v; int w;
        public Edge(int a, int b, int c){
            u = a; v = b; w = c;
        }
    }
    // 与Dijkstra和spfa 的区别是用 边数组更新路径
// 有负权边的一般判断是否有解 看是否小于0x3f3f3f3f / 2
// 是的话有解，否则无解
// k可以指定，也可以遍历n-1次，
// 注意：松弛循环，复制一个dist数组来
    static int bellman_ford(Edge[] e, int n, int k){
        int m = e.length;
        int[] dist = new int[n+1];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        int[] copy = new int[n+1];
        for(int i = 0; i < k; i++){ // 边数限制
            copy = dist.clone();
            for(int j = 0; j < m; j++){
                int a = e[j].u, b = e[j].v, c = e[j].w;
                dist[b] = Math.min(dist[b], c + copy[a]); //a的dist用copy数组
            }
        }
        return dist[n] < 0x3f3f3f3f / 2 ? dist[n] : -1;
    }


    // 判读负环
    static boolean bellman_ford(Edge[] e, int n){
        int m = e.length;
        int[] dist = new int[n+1];
        Arrays.fill(dist, 0x3f3f3f3f);
        dist[1] = 0;
        int[] copy = new int[n+1];
        for(int i = 0; i < n - 1; i++){ // 边数限制
            copy = dist.clone(); // 在复制的数组上进行更新，以免互相影响。
            for(int j = 0; j < m; j++){
                int a = e[j].u, b = e[j].v, c = e[j].w;
                dist[b] = Math.min(dist[b], c + copy[a]);
            }
        }
        // 判读负环，在n-1次循环后，在遍历一次 边数组
        int[] back = dist.clone();
        for(int i = 0; i < m; i++){
            int a = e[i].u, b = e[i].v, c = e[i].w;
            dist[b] = Math.min(dist[b], c + dist[a]);
        }
        // 如果边数组发生改变，那么说明存在负环，否则不存在
        for(int i = 0; i <= n; i++){
            if(back[i] != dist[i]) return true;
        }
        return false;
    }
}
