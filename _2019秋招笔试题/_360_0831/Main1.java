package _2019秋招笔试题._360_0831;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-31 17:04
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String s = sc.nextLine ();
        int[] map = new int[26];
        int max = 0;
        for (int i = 0; i < s.length (); i++) {
            max = Math.max (max, ++map[s.charAt (i) - 'a']);
        }
        System.out.println (max);
    }
}
