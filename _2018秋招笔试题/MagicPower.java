package _2018秋招笔试题;


import java.util.Arrays;
import java.util.Scanner;


/**
 * 最高魔杖法强
 * 题目描述：一根魔杖上有n个并排水晶石，每个水晶石有能量值，魔杖的法术强度等于水晶石的最小值
 * 魔杖可以通过融合相邻的两颗水晶石进行强化，最多可以强化m次，求魔杖的最高法术强度
 * 输入描述：有两行数据
 * 第一行两个数 n m ；n为水晶个数，m为最多强化次数
 * 第二行n个用数，每个数为第i个水晶能量值。
 * 输出描述：魔杖的最高法术强度。
 * 例：
 * 输入：6 3
 * 1 7 2 2 5 9
 * 输出： 8
 *
 * @version 1.0 滴滴2019春季校园招聘
 * @created by bill
 * @on 2018-10-10 下午8:00
 **/
public class MagicPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String[] str1 = sc.nextLine ().split (" ");
        int n = Integer.parseInt (str1[0]);
        int m = Integer.parseInt (str1[1]);
        int[] a = new int[n];

        String[] str2 = sc.nextLine ().split (" ");
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt (str2[i]);
        }

//        int k = 0;
//        while (sc.hasNext ()) {
//            a[k++] = sc.nextInt ();
//        }

        for (int i = 0; i < m; i++) {
            a = enPower (a, n - i);
        }
//        输出e 方便debug
//        for (int e :
//                a) {
//            System.out.print (e + ",");
//        }
//        System.out.println ("=====");
        Arrays.sort (a);
        System.out.println (a[0]);


    }

    static int maxPower;

    static int[] enPower(int[] a, int n) {
        int[] res = new int[n - 1];
        int flag = 0, min = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] < min) {
                min = a[i];
                flag = i;
            }
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (i == flag) {
                if (i == 0) {
                    res[j] = a[i] + a[i + 1];
                    i++;
                } else if (i == n - 1) {
                    res[j - 1] = a[i - 1] + a[i];
                } else {
                    if (a[i + 1] < a[i - 1]) {
                        res[j] = a[i] + a[i + 1];
                        i++;
                    } else {
                        res[j - 1] = a[i] + a[i - 1];
                        res[j] = a[++i];
                    }
                }
            } else {
                res[j] = a[i];
            }
            j++;
        }
        return res;
    }

}
