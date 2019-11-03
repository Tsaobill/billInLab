/**
 * 摔鸡蛋
 *
 * @author
 * @create 2019-02-20 9:49
 **/

package DynamicProgramming;

public class Eggs {
    public static void main(String[] args) {
        System.out.println(getMinEggs(100, 2));
    }

    private static int getMinEggs(int m, int n) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                //按最坏情况赋值，j层楼最多尝试j次
                dp[i][j] = j;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= m; j++) {
                for (int k = 1; k <= j; k++) {
                    dp[i][j] = Math.min(Math.max(dp[i][j - k], dp[i - 1][k - 1]) + 1, dp[i][j]);
                }
            }
        }
//        for (int i = 0; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                System.out.print(dp[i][j] + "\t");
//            }
//            System.out.println();
//        }

        return dp[n][m];
    }
}
