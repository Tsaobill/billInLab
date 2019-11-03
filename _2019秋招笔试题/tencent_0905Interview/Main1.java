package _2019秋招笔试题.tencent_0905Interview;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-05 19:33
 **/
public class Main1 {
    public static void main(String[] args) {
        System.out.println (getMin (9, 10, 13, 4));
    }

    static int getMin(int a, int b, int c, int k) {
        int lo = 1;
        int hi = (1 << k) - 1;
        int min = Math.min (a, Math.min (b, c));
        int max = Math.max (a, Math.max (b, c));
        int mid;
        while (true) {
            mid = lo + hi >> 1;
            if (mid < min) {
                lo = mid + 1;
            } else if (mid > max) {
                hi = mid - 1;
            } else break;
        }
        return mid;
    }
}
