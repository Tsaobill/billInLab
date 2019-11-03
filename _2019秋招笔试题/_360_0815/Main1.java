package _2019秋招笔试题._360_0815;

import _2018秋招笔试题.拼多多.Main;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-15 18:58
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = 2;
        int m = 2;
        int[][] map = new int[][]{{2, 1}, {1, 1}};
        int max = 2;
        int res = 0;
        res += (n * m) * 2;
        res += (n + m) * 2;
        int count = 2;
        while (max >= count) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] >= count) {
                        res += getSurface (count, map, i, j);
                    }
                }
            }
            count++;
        }
        int[][] f = new int[2][2];
        int[] arr = new int[2];
        Arrays.fill (arr,Integer.MAX_VALUE);
        Arrays.fill (f,arr);

        System.out.println (res);
    }

    private static int getSurface(int count, int[][] nums, int x, int y) {
        int sum = 4;
        int[] dx = new int[]{-1, 0, 1, 0}, dy = new int[]{0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k], ny = y + dy[k];
            if (nx >= 0 && nx < nums.length && ny >= 0
                    && ny < nums[0].length && nums[nx][ny] >= count) {
                sum--;
            }
        }
        return sum;
    }
}
