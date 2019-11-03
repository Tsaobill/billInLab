package _2019秋招笔试题.NetEase_0803;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-03 15:00
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int q = sc.nextInt ();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt ();
        }
        Arrays.sort (nums);
        int[] que = new int[q];
        for (int i = q - 1; i >= 0; i--) que[i] = sc.nextInt ();

        while (q > 0) {
            int key = que[q - 1];
            int idx = getIdx (nums, key);
            if (idx == -1) {
                System.out.println (0);
            } else {
                for (int i = idx; i < nums.length; i++) {
                    nums[i] = nums[i] - 1;
                }
                System.out.println (n - idx);
            }
            q--;
        }
    }

    static int getIdx(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi - 1) {
            int m = lo + (hi - lo) / 2;
            if (arr[m] <= key) lo = m;
            else hi = m;
        }
        if (arr[lo] >= key) return lo;
        if (arr[hi] >= key) return hi;
        return -1;
    }
}
