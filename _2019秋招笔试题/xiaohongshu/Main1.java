package _2019秋招笔试题.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 某小红薯在小红书的活动中抽奖中了一定价值的薯券，这些薯券可以用来购买一批商品，求有多少种购买组合。其中一件商品可以买多件。输入 : 薯券金额、商品分别价格输出 : 组合数
 * <p>
 * 输入
 * 输入薯券金额、商品分别价格输出，
 * <p>
 * 例如： 10 [2,3,5]，10 与[2,3,5]中间有空格
 * <p>
 * 输出
 * 输出4，则结果集可以为:2,2,2,2,2；5,5；2,3,5；2,2,3,3共有4种组合
 * <p>
 * <p>
 * 样例输入
 * 10 [2,3,5]
 * 样例输出
 * 4
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-18 14:59
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int m = sc.nextInt ();
        String str = sc.next ();
        str = str.substring (1, str.length () - 1);
        String[] strArr = str.split (",");
        int n = strArr.length;
        int[] cost = new int[n];
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.valueOf (strArr[i]);
        }
        System.out.println (Arrays.toString (cost));
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            f[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= cost[i-1]; j--) {
                f[i][j] = f[i - 1][j];
                for (int k = 1; k * cost[i - 1] <= j; k++) {
                    if (f[i - 1][j - k * cost[i - 1]] != 0) {
                        f[i][j] += f[i - 1][j - k * cost[i - 1]];
                    }
                }
            }
        }
        System.out.println (f[n][m]);
    }
}
