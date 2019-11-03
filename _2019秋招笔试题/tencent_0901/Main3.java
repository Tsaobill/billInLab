package _2019秋招笔试题.tencent_0901;

import java.util.Arrays;

/**
 * @version 1.0
 * codeforces 551C
 * @created by bill
 * @on 2019-09-01 21:02
 **/
public class Main3 {
    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        int[] arr = new int[]{0, 1, 0, 2};
        int sum = 0;
        int farest = 0;
        for (int i = 1; i <= n; i++) {
            sum += arr[i];
            if (arr[i] > 0) farest = i;
        }
        long ans = 0;
        long l = farest + 1;
        long r = farest + sum;
        while (l <= r) {
            long mid = l + r >> 1;
//            if (check (mid, m, farest, arr)) {
            if (ok (mid, m, farest, arr)) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        System.out.println (ans);
    }


    static boolean check(long x, int m, int tot, int[] arr) {
        int s = 0;
        for (int i = 1; i <= tot; i++) {
            s += arr[i];
            while (s + i >= x) {
                s -= x - i;
                m--;
                if (m < 0) return false;
            }
        }
        if (m == 0) return s <= 0;
        return true;
    }

    static boolean ok(long x, int m, int farest, int[] a) {
        int n = a.length;
        int[] b = new int[n];
        System.arraycopy (a, 1, b, 1, farest);
        int top = farest, man = m;
        while (man-- > 0 && top > 0) {
            long left = x - top;
            while (left > 0 && top > 0) {
                if (b[top] == 0) {
                    top--;
                    continue;
                }
                if (b[top] <= left) {
                    left -= b[top--];
                } else {
                    b[top] -= (int) left;
                    break;
                }
            }
        }
        while (top > 0 && b[top] == 0) top--;//找到最后一个并且不是0的点
        return top == 0;
    }
}
