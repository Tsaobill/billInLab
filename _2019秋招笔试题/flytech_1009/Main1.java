package _2019秋招笔试题.flytech_1009;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-09 18:57
 **/
public class Main1 {
    public static void main(String[] args) {
        System.out.println (func (new Scanner (System.in).nextInt ()));
    }

    public static int f(int n) {
        if (n == 2 || n == 3) return n - 1;
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }


    public static int func(int n) {
        if (n <= 4) return n;
        else return 3 * func (n - 3);
    }
}
