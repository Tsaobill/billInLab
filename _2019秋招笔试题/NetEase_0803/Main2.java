package _2019秋招笔试题.NetEase_0803;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-03 14:59
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt ();
        while (t > 0) {
            int n = sc.nextInt ();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt ();
            }
            String res = helper (nums, 0, nums.length) ? "YES" : "NO";
            System.out.println (res);

            t--;
        }
    }


    public static boolean helper(int[] nums, int k, int num) {
        if (k >= num) {
            return judge (nums, k - 1);
        }
        for (int i = k; i < num; i++) {
            if (k > 0 && judge (nums, i)) {
                swap (nums, k, i);
                if (helper (nums, k + 1, num)) {
                    return true;
                }
                swap (nums, k, i);
            }
            if (k == 0) {
                swap (nums, k, i);
                if (helper (nums, k + 1, num)) {
                    return true;
                }
                swap (nums, k, i);
            }
        }
        return false;
    }

    static boolean judge(int[] nums, int idx) {
        int pre = idx == 0 ? nums.length - 1 : idx - 1;
        int next = idx == nums.length - 1 ? 0 : idx + 1;
        return nums[idx] < (nums[pre] + nums[next]);
    }

    static void swap(int[] nums, int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }
}
