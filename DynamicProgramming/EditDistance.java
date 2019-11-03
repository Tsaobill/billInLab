package DynamicProgramming;
/**
 * 计算两个单词的编辑距离
 * 编辑距离：指word 1 最少可以经过几次原子操作变成word 2，(其实2-->1的距离即使1到2的逆操作)
 * 允许的原子操作有：
 * 1.插入一个字符
 * 2.替换一个字符
 * 3.删除一个字符
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-12 下午1:51
 **/
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println (getEditDistance (str1, str2));
    }

    static int getEditDistance(String word1, String word2) {
        int n = word1.length (), m = word2.length ();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = i + j;
                } else if (word1.charAt (i - 1) == word2.charAt (j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
//               转化为子问题
                    dp[i][j] = Math.min (dp[i - 1][j - 1] + 1, Math.min (dp[i][j - 1] + 1, dp[i - 1][j] + 1));
                    //dp[i][j]的来源有3种可能，
                    // 1.dp[i-1][j-1]不进行操作
                    // 2.dp[i-1][j]进行一次insert操作
                    // 3.dp[i][j-1]进行一次remove操作，

                }
            }
        }


        return dp[n - 1][m - 1];
    }

}
