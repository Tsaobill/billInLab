package _2019秋招笔试题.webank_0919;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-19 17:20
 **/
public class Main3 {
    static int[] h, ne, e;
    static int idx = 0;

    static void add(int x, int y) {
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        h = new int[n + 1];
        e = new int[2 * m];
        ne = new int[2 * m];
        Arrays.fill (h, -1);
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt (), y = sc.nextInt ();
            add (x, y);
            add (y, x);
        }
        int start = sc.nextInt (), end = sc.nextInt ();
        boolean[] st = new boolean[n + 1];
        mark = new boolean[n + 1];
        st[start] = true;
        List<Integer> path = new ArrayList<> ();
        path.add (start);
        dfs (start, end, st, path);
        System.out.println ("never");
        for (int i = 1; i <= n; i++) {
            if (!mark[i]) {
                System.out.print (i + " ");
            }
        }
    }

    static boolean[] mark;

    static void dfs(int cur, int end, boolean[] st, List<Integer> path) {
        if (cur == end) {
            System.out.print ("路径：");
            for (int e : path) {
                System.out.print (e + " ");
                mark[e] = true;
            }
            System.out.println ();
            return;
        }
        for (int i = h[cur]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                path.add (j);
                dfs (j, end, st, path);
                st[j] = false;
                path.remove (path.size () - 1);
            }
        }
    }
}
/*
5 4
1 2
2 3
4 2
5 2
1 3
=====
5 6
1 2
3 1
2 3
4 2
4 3
5 2
1 4
 */