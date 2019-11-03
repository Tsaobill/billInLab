/**
 * 外卖满减
 *
 * @author
 * @create 2018-10-10 7:51
 **/

package DynamicProgramming;

public class WaiMaiManJian {
    public static void main(String[] args) {

        System.out.println(minCost(20, new int[]{18, 19, 17, 6, 7}));
    }

    static int minCost(int Condi, int[] a) {

        int[][] dp = new int[Condi + 1][a.length];
        for (int i = 0; i < a.length; i++) {
            dp[0][i] = a[i];
        }
        for (int i = 0; i < a[0]; i++) {
            dp[i][0] = a[0];
        }
        for (int i = 0; i <= Condi; i++) {
            for (int j = 1; j < a.length; j++) {
//                if (dp[i][j-1]==0){
////                    dp[i][j]=a[j]
////                }
                if (a[j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1];
                } else if (a[j] > i && a[j] < dp[i][j - 1]) {
                    dp[i][j] = a[j];
                } else {
                    dp[i][j] = min(dp[i][j - 1], dp[i - a[j]][j - 1] + a[j]);
                }
            }
        }


        return dp[Condi][a.length - 1];
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }
}
