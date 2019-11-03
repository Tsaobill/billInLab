package _2019秋招笔试题.kuaisu;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-28 19:29
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        String[] answers = new String[n];
        for (int i = 0; i < n; i++) {
            answers[i] = sc.next ();
        }
        int[] po = new int[m];
        int res = 0;
        for (int j = 0; j < m; j++) {
            int point = sc.nextInt ();
            int[] map = new int[26];
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (++map[answers[i].charAt (j) - 'A'] > max) {
                    max = map[answers[i].charAt (j) - 'A'];
                }
            }
            res += point * max;
        }
        System.out.println (res);

    }


}
