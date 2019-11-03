package _2019秋招笔试题.ea_1012;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-12 21:13
 **/
public class Main2 {
    static long[][] mat = new long[33][33];
    static int[] digit = new int[40];
    static int cnt;

    public static void main(String[] args) {
        int n = 2;
        int m = 12;
        initMatrix ();
        System.out.println (solve (m) - solve (n - 1));
    }

    static long solve(int temp) {
        long ans = 0;
        int i, j, num0, num1, k = 0;
        cnt = 0;// 二进制表示有多少位
        // 记录二进制表示的每一位是0还是1
        digit[cnt] = -1111111;
        while (temp > 0) {
            digit[++cnt] = temp % 2;
            if (k == 0 && digit[cnt] == 1) k = cnt;
            temp /= 2;
        }
//        System.out.println ("=====================");
//        System.out.println (Arrays.toString (digit));
//        System.out.println ("=====================");
        for (i = 1; i < cnt; i++) {// 数字temp有cnt个二进制位，求位数小于cnt的所有ZDN的个数
            // 第i位放1
            for (j = 0; j < i; j++) {
                if (2 * j > i - 2) break;
                ans += mat[i - 1][j];
            }
        }

        num0 = 0;// 0的个数
        num1 = 1;// 1的个数
        for (j = i - 1; j > 0; j--) {
            if (digit[j] == 0) {// 如果这一位是0
                num0++;
                continue;
            }
            // 这位是1，先累加放0的，再放1
            num0++;
            for (int m = 0; m < j; m++) {
                if (num1 + m > (j - 1 - m) + num0) break;
                ans += mat[j - 1][m];
            }
            num0--;
            num1++;
        }
        if (num0 >= num1) ans++;// 如果当前这个数的0的个数大于等于1的个数，结果再加1
        return ans;
    }

    static void initMatrix() {
        int i, j;
        mat[0][0] = 1;
        for (i = 1; i < 33; i++) {
            mat[i][0] = 1;
            for (j = 1; j < i; j++) {
                mat[i][j] = mat[i - 1][j - 1] + mat[i - 1][j];
            }
            mat[i][j] = 1;
        }
    }
}
