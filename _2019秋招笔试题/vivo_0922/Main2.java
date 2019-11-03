package _2019秋招笔试题.vivo_0922;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-22 16:55
 **/
public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 3};
        int n = arr[0];
        int m = arr[1];
        int[] res = new int[n];
        int[] src = new int[n];
        for (int i = 0; i < n; i++) {
            src[i] = i + 1;
        }
        boolean[] st = new boolean[n];
        int idx = 0;
        int round = 0;
        while (idx < n) {
            if (!st[round] && round % m == 0) {
                res[idx++] = src[round];
                round++;
                round %= n;
                st[round] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println (res[i]);
        }
    }
}
