package _2018秋招笔试题;

/**
 * 01背包问题
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-09 上午9:51
 **/
public class ZeroOnePack {
    public static void main(String[] args) {

        int level[] = {80, 100, 60, 30, 70, 20};
        int price[] = {4, 6, 2, 2, 5, 1};
        int maxMoney = 12;
        System.out.println (maxLevel (maxMoney, price, level, level.length));
    }

    static int maxLevel(int maxMoney, int[] price, int[] level, int n) {
        int[][] dp = new int[n + 1][maxMoney + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxMoney; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j < price[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max (dp[i - 1][j], dp[i - 1][j - price[i-1]] + level[i-1]);
                }
            }
        }
        return dp[n][maxMoney];
    }

    static int max(int a, int b) {
        return a > b ? a : b;
    }

}
