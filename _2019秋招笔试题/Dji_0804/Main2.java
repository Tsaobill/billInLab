package _2019秋招笔试题.Dji_0804;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-04 19:19
 **/

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        while (sc.hasNext ()) {
            int n = sc.nextInt ();// 零食种类数
            int t = sc.nextInt ();// 总钱数
            int[] f = new int[t + 1];
            for (int i = 1; i <= n; i++) {
                int c = sc.nextInt ();
                int w = sc.nextInt ();
                int num = sc.nextInt ();
                multiplePack (num, c, w, t, f);
            }
            int max = 0;
            for (int i = 0; i <= t; i++) {
                max = Math.max (max, f[i]);
            }
            System.out.println (max);
        }
    }

    static void multiplePack(int a, int cost, int weight, int v, int[] f) {
        if (cost * a >= v) {
            completePack (cost, weight, v, f);
            return;
        }
        int k = 1;
        while (k < a) {
            zeroOnePack (k * cost, k * weight, v, f);
            a -= k;
            k *= 2;
        }
        zeroOnePack (a * cost, a * weight, v, f);
    }

    static void zeroOnePack(int cost, int weight, int v, int[] f) {
        for (int i = v; i >= cost; i--) {
            f[i] = Math.max (f[i], f[i - cost] + weight);
        }
    }

    static void completePack(int cost, int weight, int v, int[] f) {
        for (int i = cost; i <= v; i++) {
            f[i] = Math.max (f[i], f[i - cost] + weight);
        }
    }
}