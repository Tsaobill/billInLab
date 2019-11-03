package _2019秋招笔试题.zhaohang_0923;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-23 19:40
 **/
public class Main1 {
    public static void main(String[] args) {
        int n = 100;
        int res = solve (n);
        System.out.println (res);
    }

    static int solve(int n) {
        if (n == 0) return 1;
        else if (n < 10) return n;
        else return Math.max (solve (n / 10) * (n % 10), solve (n / 10 - 1) * 9);
    }
}
