package _2019秋招笔试题.tencent_0901;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-01 19:57
 **/
public class Main2 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = new int[]{8, 2, 4, 6, 5};
        int[][] segMin = new int[n][n];
        int[][] segSum = new int[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    segMin[i][j] = arr[i];
                    segSum[i][j] = arr[i];
                } else {
                    segMin[i][j] = Math.min (arr[j], segMin[i][j - 1]);
                    segSum[i][j] = arr[j] + segSum[i][j - 1];
                }
                int tt = segMin[i][j] * segSum[i][j];
//                System.out.println (tt);
                if (max < tt) {
                    System.out.println (max +" -->" + tt);
                    max = tt;
                }
            }
        }
        System.out.println (max);
    }
}
