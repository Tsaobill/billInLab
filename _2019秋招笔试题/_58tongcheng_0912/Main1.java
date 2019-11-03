package _2019秋招笔试题._58tongcheng_0912;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-12 20:37
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        String[] strArr = str.split (",");
        Set<String> set = new HashSet<> ();
        for (int i = 0; i < strArr.length; i++) {
            set.add (strArr[i]);
        }
        System.out.println (set.size ());
    }
}
