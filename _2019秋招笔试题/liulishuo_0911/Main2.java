package _2019秋招笔试题.liulishuo_0911;

import _2018秋招笔试题.拼多多.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-11 21:21
 **/
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        String line = sc.nextLine ();
//        String[] strArr = line.split (" ");
//        List<String> list = new ArrayList<> ();
//        list.add (line);
//        int n = strArr.length;
//        while (sc.hasNextLine ()) {
//            list.add (sc.nextLine ());
//        }
//        int m = list.size ();
//        int[][] map = new int[n][m];
//        int cur = 0;
//        for (String str : list) {
//            strArr = str.split (" ");
//            for (int i = 0; i < strArr.length; i++) {
//                map[cur][i] = Integer.valueOf (strArr[i]);
//            }
//            cur++;
//        }

        int n = 4, m = 4;
        boolean[][] flag = new boolean[n][m];
        int[][] map = new int[][]{{2, 0, 0, 1}, {0, 1, 0, 1}, {1, 0, 0, 0}, {3, 0, 1, 0}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 2) {
                    dfs (0, i, j, map, flag);
                    break;
                }
            }
        }
        System.out.println (min);
    }


    static void dfs(int aa, int i, int j, int[][] map, boolean[][] flag) {
        if (map[i][j] == 3) {
            min = Math.min (aa, min);
            return;
        }
        int[] nx = new int[]{-1, 0, 1, 0}, ny = new int[]{0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + nx[k], y = j + ny[k];
            if (x >= 0 && x < map.length && y >= 0 && y < map[0].length && !flag[x][y] && map[x][y] != 1) {
                flag[x][y] = true;
                dfs (aa + 1, x, y, map, flag);
                flag[x][y] = false;
            }
        }
    }

    static int min = 0xffffffff;
}
