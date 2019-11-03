/**
 * @author
 * @create 2019-04-09 19:02
 **/

package com.Zhaohang;

import java.math.BigInteger;

public class Problem1 {
    public static void main(String[] args) {

        // 领取糖果 共有n个糖果n个人，按顺序领取，每个人可领取超过1到n之间的任意值，
        // 则第一个领的人想要获得超过 6 个糖果的情况有多少中
        //【考点】:
        // 1.先找出规律：
        //      列出每个数的分解方式：如4: 4;13;31;22;211;121;112;1111;8种；
        //      然后就是 1 加上一个等比数列，最后发现结果为 2 的n-6次方
        // 2.在通过for循环依次求2的i次幂时，会很快溢出，
        // 因此最简单的方式就是每次求完就先对666666666取模，保证不会溢出

        int a = 1073741823;
        int n = 60;
        BigInteger ans = new BigInteger("1");
        BigInteger count = new BigInteger("1");
        for (int i = 0; i < n - 6; i++) {
            ans = ans.add(count);
            count = count.add(count);
        }

        ans = ans.mod(BigInteger.valueOf(a));
        System.out.println(ans.toString());
        int res = 1;
        int t = 2;
        for (byte i = 0; i < n - 6; i++) {
            res = (res * t) % a;
        }
        System.out.println(res);
    }
}
