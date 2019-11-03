package LeetCode;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-01 15:39
 **/
public class LIS {
    public static void main(String[] args) {
//        int[] nums = new int[]{0};
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println (new LIS ().lengthOfLIS (nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > f[count]) {
                f[++count] = nums[i];
            } else {
                if (count == 0) {
                    f[count] = nums[i];
                } else {
                    int idx = getIdx (f, nums[i], count);
                    f[idx] = nums[i];
                }
            }
        }
        return count + 1;
    }

    int getIdx(int[] nums, int key, int hi) {
        int lo = 0;
        while (lo < hi) {
            int m = lo + (hi - lo) / 2;
            if (nums[m] < key) lo = m + 1;
            else hi = m;
        }
        return lo;
    }
}
