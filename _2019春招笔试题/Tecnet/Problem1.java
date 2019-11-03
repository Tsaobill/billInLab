/**
 * @author
 * @create 2019-04-05 19:26
 **/

package com.Tecnet;

import java.util.Arrays;

//最少携带多少枚金币 能够组成1 到 m之间的所有数值 无解返回-1； n为金币个数 数组为每种金币的面值
public class Problem1 {
    public static void main(String[] args) {

        int sum = 20;
        int n = 4;
        int[] coin = new int[]{1, 2, 5, 10};
        int ans = 0;
        Arrays.sort(coin);
        boolean flag = true;
        int max = -1;
        int[] count = new int[sum];
        for (int i = 1; i <= sum; i++) {
            int left = i;
            ans = 0;
            for (int j = n - 1; j > 0; j--) {
                while (left > coin[j]) {
                    left -= coin[j];
                    ans++;
                }
            }
            while (left >= coin[0]) {
                left -= coin[0];
                ans++;
            }
            if (left != 0) {
                max = -1;
                break;
            }
            max = max > ans ? max : ans;
        }
        System.out.println(ans);
    }

}
