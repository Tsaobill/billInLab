package _2019秋招笔试题.ea_0921;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 23:18
 **/
public class Main3 {
    public static void main(String[] args) {
        int n = 15;
        int res = solve (n);
        System.out.println (res);
    }

    static int solve(int n) {
        int fac = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            fac *= i;
            sum += fac;
        }
        return sum;
    }
}
