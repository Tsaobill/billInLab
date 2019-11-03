package _2018秋招笔试题.拼多多;

/**
 * 查找 子序列出现的次数；
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-21 下午9:54
 **/
public class Main1 {


    public static void main(String[] args) {
        System.out.println (solve ("abcabdab", "ab"));
        System.out.println (solveDP ("abcabdab", "ab"));
    }

    static int solve(String S, String T) {
        if (S.length () == 0) {
            return T.length () == 0 ? 1 : 0;
        }
        if (T.length () == 0) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < S.length (); i++) {
            if (S.charAt (i) == T.charAt (0)) {
                cnt += solve (S.substring (i + 1), T.substring (1));
            }
        }
        return cnt;
    }

    static int solveDP(String source, String target) {
        int ns = source.length ();
        int nt = target.length ();

        //dp[i][j]表示0~i-1的s子串中包含0~j-1的t的个数
        int[][] dp = new int[ns + 1][nt + 1];

        if (nt == 0) {
            return (int) Math.pow (2, ns) - 1;
        }

        for (int i = 0; i <= ns; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= nt; j++) {

                if (source.charAt (i-1) == target.charAt (j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[ns][nt];
    }

}
