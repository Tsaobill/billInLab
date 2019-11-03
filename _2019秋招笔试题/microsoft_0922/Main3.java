package _2019秋招笔试题.microsoft_0922;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-22 20:13
 **/
public class Main3 {
    public static void main(String[] args) {
        String[] a = new String[]{"22", "121"};

    }

    static int fun(String[] A) {
        int cnt = 0;
        for (String s : A) {
            int num = Integer.valueOf (s);
            if (helper (num)) cnt++;

        }
        return cnt;
    }

    static boolean helper(int n) {
        if (n < 100) return n % 10 == n / 10;
        int dig = 0;
        int tt = n;
        while (tt > 0) {
            dig++;
            tt /= 10;
        }
        int[] n1 = new int[dig-1];
        int[] n2 = new int[dig-1];
        for (int i = 0; i < n; i++) {
            
        }
        return true;
    }
}
