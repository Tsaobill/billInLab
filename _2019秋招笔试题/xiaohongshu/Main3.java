package _2019秋招笔试题.xiaohongshu;

import java.util.Scanner;

/**
 * 薯队长写了n篇笔记， 编号从 1～n，每篇笔记都获得了不少点赞数。 薯队长想从中选出一些笔记，作一个精选集合。挑选的时候有两个规则：
 *
 * 1.    不能出现连续编号的笔记。
 *
 * 2.    总点赞总数最多
 *
 * 如果满足 1，2条件有多种方案，挑选笔记总数最少的那种。
 *
 * 输入
 * 输入包含两行。第一行整数 n 表示多少篇笔记。
 *
 * 第二行 n 个整数分别表示 n 篇笔记的获得的点赞数。 （ 0 < n <= 1000, 0 <= 点赞数 <= 1000)
 *
 * 输出
 * 输出两个整数x y。空格分割。
 *
 * x 表示总点赞数，y表示挑选的笔记总数。
 *
 *
 * 样例输入
 * 4
 * 1 2 3 1
 * 样例输出
 * 4 2
 *
 * 提示
 * 挑选了第1和第3篇。总共 1 + 3 = 4 个赞。
 * @version 1.0
 * @created by bill
 * @on 2019-08-18 16:23
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt (); // 个数
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
        }

        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += arr[i];
            } else {
                b += arr[i];
            }
        }
        int res = 0, count = 0;
        if (a > b) {
            count = (n % 2 == 0) ? n / 2 : n / 2 + 1;
            res = a;
        } else {
            count = n / 2;
            res = b;
        }
        System.out.println (res + " " + count);
    }
}
