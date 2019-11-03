package _2019秋招笔试题.shengyou_0906;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-06 21:16
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        List<Integer> list = new ArrayList<> (n + 1);
        for (int i = 0; i <= n; i++) {
            list.add (i);
        }

        while (list.size () != 1) {
            for (int i = 0; i < list.size (); i += 1) {
                list.remove (i);
            }
        }
        for (int e : list) {
            System.out.println (e);
        }
    }
}
