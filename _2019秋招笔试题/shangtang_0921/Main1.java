package _2019秋招笔试题.shangtang_0921;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 19:23
 **/
public class Main1 {
    public static void main(String[] args) {
        int m = 3, n = 2;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
                }
            }
        }
        System.out.println (f[m - 1][n - 1]);
    }

}
