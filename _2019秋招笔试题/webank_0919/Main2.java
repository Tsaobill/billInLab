package _2019秋招笔试题.webank_0919;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-19 16:38
 **/
public class Main2 {
    public static void main(String[] args) {
        int n = 66;
        int res = fac (n);

        System.out.println (res);
    }

    static int mod = (int) 1e6 + 3;

    static int fac(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            sum = sum % mod;
        }
        return sum;
    }
}
