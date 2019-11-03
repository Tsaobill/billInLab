
/**
 * 上海大学
 * FileName: LongestIncreasingSubsequence
 * Author:   bill
 * Date:     2018/11/17 15:57
 * Description: 最长递增子序列
 * History:
 */

package DynamicProgramming;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = new int[]{4, 10, 4, 3, 8, 9};
        int[] b = new int[]{4, 10};
        //System.out.println(getLISBF(a));
//        System.out.println(getLISDP(a));
        System.out.println(getLISGR(a));
        System.out.println(getMGT(b, 3, 0, b.length));

    }

    //暴力解法 未完成 。。。。
    public static int getLISBF(int[] a) {
        if (a.length == 0) {
            return 0;
        }
        int count;
        int max = 1;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                count = 1;
                int curr = a[i];
                for (int k = j; k < a.length; k++) {
                    if (curr < a[k]) {
                        count++;
                        curr = a[k];
                    }
                }
                max = max < count ? count : max;
            }
        }
        return max;
    }

    // 动态规划
    public static int getLISDP(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = max < dp[i] ? dp[i] : max;
        }
        return max;
    }

    //缓存区存储潜在的lis长度
    public static int getLISGR(int[] nums) {
        if (nums.length < 1) return 0;
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int s = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[s] < nums[i]) {
                dp[++s] = nums[i];
            } else if (dp[s] > nums[i]) {
                int k = getMGT(dp, nums[i], 0, s);
                dp[k] = nums[i];
            }
        }
        return s + 1;
    }

    //找到缓存区数组中大于等于当前数字的最小的索引
    static int getMGT(int[] a, int k, int low, int hi) {
        int mid;
        while (low < hi - 1) {
            mid = (low + hi) / 2;
            if (a[mid] > k) {
                hi = mid;
            } else {
                low = mid;
            }
        }
        if (a[low] >= k) return low;
        return hi;
    }
}