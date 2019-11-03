/**
 * @author
 * @create 2019-04-05 19:26
 **/

package com.Tecnet;

import java.util.Scanner;

// 相邻0 1 可以消除 问最后剩下多少个字符
public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[] arr = new int[]{0,1,0,1,0};
        int one = 0;
        int zero = 0;
        String str="1010";
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == '1'){
                one++;
            }else{
                zero++;
            }
        }
        int ans = one>zero?one-zero:zero-one;
        System.out.println(ans);
    }
}
