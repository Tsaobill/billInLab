package _2019秋招笔试题.bilibili_0820;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-20 19:18
 **/
public class Main1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        String string = sc.nextLine ();
        String[] words = new String[]{"I","am", "a", "student."};
        // func (words);
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print (words[i] + " ");
        }
    }


    static void func(String[] strs) {
        int lo = 0, hi = strs.length - 1;
        while (lo < hi) {
            String temp = strs[hi];
            strs[hi] = strs[lo];
            strs[lo] = temp;
            hi--;
            lo++;
        }
    }
}
