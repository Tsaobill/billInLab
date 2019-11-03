package _2019秋招笔试题.Ctrip_0904;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-04 20:13
 **/
public class Main3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 3, 4, 2};
        int m = 3;
        System.out.println (split (m, nums));
    }

    public static int split(int m, int[] nums) {
        long lo = 0, hi = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            hi += nums[i];
            if (lo < nums[i]) lo = nums[i];
        }
        long ans = hi;
        while (lo <= hi) {
            long mid = lo + hi >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= m) {
                ans = Math.min (ans, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return (int) ans;
    }


}
