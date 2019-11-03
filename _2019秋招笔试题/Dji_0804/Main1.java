package _2019秋招笔试题.Dji_0804;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-04 19:16
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int MAX = 480;
        while (sc.hasNext ()) {
            int n = sc.nextInt ();// bug数
            int a = sc.nextInt ();// 喝咖啡的倍数
            int x = sc.nextInt ();// 最多的咖啡数目
            int time = 0; // 记录所有bug的总时间
            for (int i = 0; i < n; i++) {
                time += sc.nextInt ();
            }
            //将效率转化成时间扩展
            if (x * a * 60 + (8 - x) * 60 < time) { // 计算可以用咖啡扩展到的最大时间是否小于所有bug时间总和
                System.out.println (0);
            } else {
                int good = x * 60 * a; // 用咖啡加时的时间段；
                int mod = time % a;
                int ans = mod == 0 ? time / a : time / a + 1;
                if (good > time) { // 如果能在咖啡加时的时间内完成
                    System.out.println (ans);
                } else { //  否则就用加时的时间，加上
                    System.out.println (x * 60 + time - good);
                }

            }
        }
    }
}