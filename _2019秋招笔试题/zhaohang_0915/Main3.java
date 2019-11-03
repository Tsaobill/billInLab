package _2019秋招笔试题.zhaohang_0915;

import java.math.BigInteger;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-15 21:03
 **/
public class Main3 {
    public static void main(String[] args) {
        String str = "???5";
        char[] nums = str.toCharArray ();
        for (int i = 0; i < nums.length; i++) {
            cnt += nums[i] == '?' ? 1 : 0;
        }
        int[] mark = new int[cnt];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '?') {
                mark[idx++] = i;
            }
        }
        dfs (0, mark, nums);
        System.out.println (res);
    }

    static int cnt = 0;
    static int mod = 1000000007;
    static int res = 0;

    static void dfs(int lv, int[] mark, char[] nums) {
        if (lv == cnt) {
            String s = new String (nums);
            if (new BigInteger (s).mod (new BigInteger ("13")).intValue () == 5) {
                res++;
                res %= mod;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            nums[mark[lv]] = (char) ('0' + i);
            dfs (lv + 1, mark, nums);
        }
    }
}
