package _2019秋招笔试题.webank_0919;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-19 16:25
 **/
public class Main1 {
    // 求n得阶乘最后一个不为0的数字
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int res = lastNonZeroNumInNsFac (n);
        System.out.println (res);
    }

    static int fac(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            sum = sum % 1000;
        }
        return sum;
    }

    static int lastNonZeroNumInNsFac(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            while (sum > 0) {
                if (sum % 10 == 0) {
                    sum /= 10;
                } else {
                    sum = sum % 1000;
                    break;
                }
            }
        }
        while (sum > 0) {
            if (sum % 10 == 0) {
                sum /= 10;
            } else {
                return (sum % 10);
            }
        }
        return 0;
    }
}
