/**
 * 上海大学
 * FileName: MaximumSubarray
 * Author:   bill
 * Date:     2018/11/22 23:07
 * Description:
 * History:
 */
package DynamicProgramming;


public class MaximumSubarray{

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("====================");
        System.out.println("bruteSolve result : " + bruteSolve(a));

        System.out.println("====================");
        System.out.println("Dynamic Programming Result : " + dpSolve(a));

        System.out.println("====================");
        System.out.println("optimized DP Result : "+ solve(a));
    }
    //方法一：暴力求解 O(n^2)time，O(1)space
    public static int bruteSolve(int[] a ){
        int sum = 0,max = a[0];
        for (int i = 0; i < a.length ; i++ ) {
            for (int j = i;j < a.length ;j++ ) {
                sum += a[j];
                if (max<sum) {
                    max = sum;
                }
            }
            sum = 0;
        }
        return max;
    }
    //方法二：动态规划 O(n)time，O(n)space
    //设dp[i] 前缀A[0-i]中以a[i]结尾的最大连续子数组的和（方便写状态转移方程）；那么原数组的最大连续子数组一定在其中，只需用一个数的保存并更新即可
    public static int dpSolve(int[] a){
        int[] dp = new int[a.length];
        dp[0] = a[0];
        int f=0;
        int max = a[0];
        for (int i = 1; i < a.length ;i++ ) {
//            if (dp[i-1] > 0) {
//                dp[i] = dp[i-1] + a[i];
//            }else{
//                dp[i] = a[i];
//            }
//            max = dp[i] > max? dp[i] : max;
            f= Math.max(f+a[i],a[i]);
            max = Math.max(max,f);
        }
        return max;
    }
    //方法三：O(n)time，O(1)space
    //利用动态规划，但是不用构建数组
    public static int solve(int[] a){
        int max=a[0],sum=a[0];
        for (int i = 0; i < a.length; i++ ) {
            if (sum>0) {
                sum += a[i];
            }else {
                sum = a[i];
            }
            max = sum > max? sum:max;
        }
        return max;
    }


}

