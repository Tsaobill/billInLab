package graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:16
 **/
public class Prim {
    static int[][] g;
    static int[] dist;
    static boolean[] st;
    static int n, m, INF = 0x3f3f3f3f;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m =sc.nextInt();
        g = new int[n+1][n+1];
        st = new boolean[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, INF);
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == j) g[i][j] = 0;
                else g[i][j] = INF;
            }
        }
        for(int i = 0; i < m; i++){
            int x = sc.nextInt(); int y = sc.nextInt(); int z = sc.nextInt();
            g[x][y] = Math.min(z, g[x][y]);
            g[y][x] = g[x][y];
        }

        int ans = prim();
        System.out.println(ans == INF ? "impossible" : ans);
    }

    static int prim(){
        int res = 0;
        for(int i = 0; i < n; i++){
            int t = -1;
            for(int j = 1; j <= n; j++){
                if(!st[j] && (t == -1 || dist[j] < dist[t])){
                    t = j;
                }
            }
            if(i > 0 && dist[t] == INF) return INF;
            if(i > 0) res += dist[t];

            st[t] = true;
            for(int j = 1; j <= n; j++) dist[j] = Math.min(dist[j], g[t][j]);
        }

        return res;
    }
}
