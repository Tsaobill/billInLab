package _2019秋招笔试题.pinduoduo_0728;

/**
 * pinduoduo 第四题，搭积木，大的在下，最多承受7倍自身重量
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-28 16:14
 **/

import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
//        Scanner in = new Scanner (System.in);
//        int n = in.nextInt ();
//        int[] len = new int[n];
//        for (int i = 0; i < n; i++) {
//            len[i] = in.nextInt ();
//        }
//        int[] wei = new int[n];
//        for (int i = 0; i < n; i++) {
//            wei[i] = in.nextInt ();
//        }

        int[] len = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        int[] wei = new int[]{1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 10};
        dfs (len, wei, 0);
        System.out.println (res);
    }

    static int res = 0;

    static void dfs(int[] len, int[] wei, int num) {
        if (num == len.length) {
            res = res < num ? num : res;
            return;
        }
        if (!judge (wei, num)) {
            res = res < num ? num : res;
            return;
        }

        for (int i = num; i < len.length; i++) {
            if (num > 0 && len[i] < len[num - 1]) {
                swap (len, wei, num, i);
                dfs (len, wei, num + 1);
                swap (len, wei, num, i);
            }
            if (num == 0) {
                swap (len, wei, num, i);
                dfs (len, wei, num + 1);
                swap (len, wei, num, i);
            }
        }

    }

    static boolean judge(int[] wei, int num) {
        int sum = 0;
        for (int i = num; i >= 0; i--) {
            if (7 * wei[i] < sum) {
                return false;
            }
            sum += wei[i];
        }
        return true;
    }

    static void swap(int[] len, int[] wei, int i, int j) {
        int tempLen = len[i];
        len[i] = len[j];
        len[j] = tempLen;

        int tempWei = wei[i];
        wei[i] = wei[j];
        wei[j] = tempWei;

    }
}

