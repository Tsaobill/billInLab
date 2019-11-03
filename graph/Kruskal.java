package graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-27 23:21
 **/
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int u; int v; int w;
        public Edge(int a, int b, int c){ u = a; v = b; w = c;}

        @Override
        public int compareTo(Edge e){
            return this.w - e.w;
        }
    }
    static Edge[] edges;
    static int INF = 0x3f3f3f3f, n, m;
    static int[] pre;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  m = sc.nextInt();
        edges = new Edge[m];
        pre = new int[n+1];
        for(int i = 0; i < m; i++){
            int x = sc.nextInt(); int y = sc.nextInt(); int z = sc.nextInt();
            edges[i] = new Edge(x, y, z);
        }
        int ans =kruskal();
        System.out.println(ans < INF/2 ? ans : "impossible"  );
    }

    static int kruskal(){
        Arrays.sort(edges);
        for(int i = 0; i <= n; i++) pre[i] = i; // 初始化并查集

        int res = 0, cnt = 0;
        for(int i = 0; i < m; i++){
            int a = edges[i].u; int b = edges[i].v; int w = edges[i].w;
            a = find(a);
            b = find(b);
            if(a != b){
                pre[a] = b;
                res += w;
                cnt++;
            }
        }

        if(cnt < n - 1) return INF;
        return res;
    }

    static int find(int e){
        return e == pre[e] ? e : (pre[e] = find(pre[e]));
    }
}
