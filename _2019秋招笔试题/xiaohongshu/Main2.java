package _2019秋招笔试题.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-18 15:36
 **/
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        String[] arr = str.split (" ");
        reverse (arr);
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].equals ( " ")){
                System.out.println (arr[i] + " ");
            }
        }
    }

    public static void reverse(String[] arr) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            String temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
}
