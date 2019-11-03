package _2018秋招笔试题.DiDi.美团;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一题
 * 外卖满减
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-09 下午6:13
 **/
public class Num1 {


    public static void main(String[] args) {

//         System.out.println (minCost (20, new int[]{18, 19, 17, 6, 7}));
        System.out.println (minCost (101, new int[]{50, 52, 501, 501, 506, 301, 105, 109, 206, 305, 46}));
    }

    static int minCost(int Condi, int[] a) {
        List<Integer> list=new ArrayList<> ();
        int min = a[0];
        int[][] dp = new int[Condi][a.length];
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= min) {
                min = a[i];
            }
            dp[0][i] = min;
        }
        for (int i = 0; i < Condi; i++) {
            dp[i][0] = a[0];
        }
        for (int i = 1; i < Condi; i++) {
            for (int j = 1; j < a.length; j++) {
                if (dp[i][j - 1] < i + 1) {
                    if (a[j] < i + 1) {
//                        dp[i][j] = dp[i][j - 1] + a[j];
                        dp[i][j] = dp[i - a[j]][j - 1] + a[j];

                    } else {
                        dp[i][j] = a[j];
                    }
                } else {
                    if (a[j] >= dp[i][j - 1]) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (i + 1 <= a[j] && a[j] < dp[i][j - 1]) {
                        dp[i][j] = a[j];
                    } else {
//                        if (dp[i+1 - a[j]][j - 1] + a[j]>i+1) {
                        dp[i][j] = min (dp[i][j - 1], dp[i - a[j]][j - 1] + a[j]);

                        if (dp[i][j - 1]>dp[i - a[j]][j - 1] + a[j]){
                            list.add (j);
                        }
//                        }else {
//                            dp[i][j] = dp[i][j - 1];
//                        }
                    }
                }
            }
        }

        //检验dp矩阵各项的值
        for (int i = 0; i < Condi; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.print (dp[i][j] + " ,");
            }
            System.out.println ("   " + (i + 1));
        }

        return dp[Condi - 1][a.length - 1];
    }

    static int min(int a, int b) {
        return a < b ? a : b;
    }
}


