package _2019秋招笔试题._58tongcheng_0912;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-12 20:43
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int m = sc.nextInt ();
        int n = sc.nextInt ();
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt ();
            }
        }
        boolean[][] flag = new boolean[m][n];
        dfs (0, 0, map[0][0], flag, map);
        System.out.println (min);
    }

    static int min = Integer.MAX_VALUE;

    static void dfs(int i, int j, int res, boolean[][] flag, int[][] board) {
        if (i == board.length - 1 && j == board[0].length - 1) {
            min = Math.min (res, min);
            return;
        }
        int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !flag[x][y]) {
                flag[x][y] = true;
                dfs (x, y, res + board[x][y], flag, board);
                flag[x][y] = false;
            }
        }
    }
}
