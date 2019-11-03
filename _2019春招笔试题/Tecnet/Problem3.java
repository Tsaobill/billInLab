/**
 * @author
 * @create 2019-04-05 19:26
 **/

package com.Tecnet;

import java.util.Scanner;

// 不被攻击的最小金币 收买怪兽方案
//买的怪兽金币和武力都会累加
public class Problem3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] power = new int[n];
//        int[] coin = new int[n];
//        for(int i = 0; i < n; i++){
//            power[i] = sc.nextInt();
//        }
//
//        for(int i = 0; i < n; i++){
//            coin[i] = sc.nextInt();
//        }

        int n = 5;
        int[] power = new int[]{8, 5, 6, 10, 11};
        int[] coin = new int[]{1, 1, 1, 2, 4};

        int[] power1 = new int[]{2, 5, 6, 10, 11};
        int[] coin1 = new int[]{1, 1, 1, 2, 4};

        int ans = 0;
        int curPow = 0;
        for (int i = 0; i < n; i++) {
            if (curPow < power[i]) {
                curPow += power[i];
                ans += coin[i];
            }
        }
        System.out.println(ans);
    }
}
