package _2019秋招笔试题.vivo_0922;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-22 16:34
 **/
public class Main3 {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 7, 4, 11, 8, 10};
        int n = arr.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        int len = sum / 2 + 1;
        int[][] f = new int[n + 1][len + 1];
        for (int i = 0; i <= len; i++) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= len; j++) {
                f[i][j] = f[i - 1][j];
                if (arr[i - 1] <= j) {
                    f[i][j] = Math.max (f[i][j], f[i - 1][j - arr[i - 1]] + arr[i - 1]);
                }
            }
        }
        System.out.println (f[n][len]);
        int res = sum - 2 * f[n][len];
        System.out.println (Math.abs (res));
    }
}
