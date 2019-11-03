package _2019秋招笔试题.zhaohang_0923;

import java.util.*;

public class Main2 {
//
//    static int[] e = new int[3 * 100000 + 1], ne = new int[3 * 100000 + 1], h = new int[2 * 100000 + 1];
//    static int idx = 0;
//
//    static void add(int x, int y) {
//        e[idx] = y;
//        ne[idx] = h[x];
//        h[x] = idx++;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        int n = sc.nextInt ();
//        Arrays.fill (h, -1);
//        for (int i = 1; i <= n; i++) {
//            int cnt = sc.nextInt ();
//            for (int j = 0; j < cnt; j++) {
//                int y = sc.nextInt ();
//                add (i, y);
//            }
//        }
//        st = new boolean[n + 1];
//        for (int i = 1; i <= n; i++) {
//            System.out.print (dfs (i) + " ");
//        }
//    }
//
//    static boolean[] st;
//
//    static int dfs(int c) {
//        if (st[c]) return 0;
//        st[c] = true;
//        int cnt = 1;
//        for (int i = h[c]; i != -1; i = ne[i]) {
//            int j = e[i];
//            cnt += dfs (j);
//        }
//        return cnt;
//    }

    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        map = new HashMap<> (n);
        for (int i = 1; i <= n; i++) {
            int cnt = sc.nextInt ();
            List<Integer> list = new ArrayList<> (cnt);
            for (int j = 0; j < cnt; j++) {
                list.add (sc.nextInt ());
            }
            map.put (i, list);
        }
        st = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            int num = dfs (i);
            System.out.print (num+" ");
        }
    }

    static boolean[] st;

    static int dfs(int i) {
        if (st[i]) return 0;
        st[i] = true;
        List<Integer> list = map.get (i);
        int cnt = 1;
        for (int e : list) {
            cnt += dfs (e);
        }
        return cnt;
    }
}


/*

import java.util.*;

public class Main {

    static Map<Integer, List<Integer>> map = new HashMap<> ();

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        for (int i = 1; i <= n; i++) {
            int cnt = sc.nextInt ();
            List<Integer> list = new ArrayList<> (cnt);
            for (int j = 0; j < cnt; j++) {
                list.add (sc.nextInt ());
            }
            map.put (i, list);
        }
        st = new boolean[n + 1];
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = dfs (i);
        }
        System.out.print (res[1]);
        for (int i = 2; i <= n; i++) {
            System.out.print (" " + res[i]);
        }
    }

    static boolean[] st;

    static int dfs(int i) {
        if (st[i]) return 0;
        st[i] = true;
        List<Integer> list = map.get (i);
        int cnt = 1;
        for (int e : list) {
            cnt += dfs (e);
        }
        return cnt;
    }
}

 */