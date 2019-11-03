package _2019秋招笔试题.bytedance_0825;

import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-25 20:02
 **/
public class Main4 {
    static int[] pre;
    static int[] nums;

    public static void main(String[] args) {

        int[] arr = new int[]{20, 50, 22, 74, 9, 36, 18, 27, 63};
        int n = arr.length;
        pre = new int[n];
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
            nums[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (GCD (arr[i], arr[j]) > 1) {
                    int a = unionfind (i);
                    int b = unionfind (j);
                    if (a != b) {
                        pre[a] = b;
                        nums[b] += nums[a];
                    }
                }
            }
        }

        printPre ();
        int res = 0;
        for (int i = 0; i < n; i++) {

            res = Math.max (nums[i], res);
        }
        System.out.println (res);
    }

    static int unionfind(int ele) {
        while (ele != pre[ele]) {
            pre[ele] = pre[pre[ele]];
            ele = pre[ele];
        }
        return ele;
    }

    static void printPre() {
        for (int i = 0; i < pre.length; i++) {
            System.out.print (pre[i] + " ");
        }
        System.out.println ();
    }

    static int GCD(int a, int b) {
        return b == 0 ? a : GCD (b, a % b);
    }
}
