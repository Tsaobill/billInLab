package LeetCode.hard;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-03 22:12
 **/
public class UniquePathIII {
    static int n, m;
    static int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        int ans = uniquePathsIII (grid);
        System.out.println (ans);
    }

    static public int uniquePathsIII(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int sx = 0, sy = 0;
        int left = n * m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) left--;
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                    left--;
                }
            }

        }
        boolean[][] st = new boolean[n][m];
        List<Integer> res = new ArrayList<Integer> (64);

        st[sx][sy] = true;
        dfs (sx, sy, left, "(" + sx + "," + sy + ")", st, grid, res);
        return res.size ();
    }

    static void dfs(int x, int y, int left, String path, boolean[][] st, int[][] grid, List<Integer> res) {
        if (grid[x][y] == 2) {
            if (left == 0) {
                res.add (1);
                System.out.println (path);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            boolean condi = nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length;
            if (condi && !st[nx][ny] && grid[nx][ny] != -1) {
                st[nx][ny] = true;
                dfs (nx, ny, left - 1, path + "(" + nx + "," + ny + ")", st, grid, res);
                st[nx][ny] = false;
            }
        }
    }
}
