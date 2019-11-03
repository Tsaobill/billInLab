package _2019秋招笔试题.dianxin_0918;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-18 21:00
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String input = sc.nextLine ();
        String[] arr = input.split (";");
        char[] str1 = arr[0].toCharArray ();
        char[] str2 = arr[1].toCharArray ();
        if (str1.length != str2.length) {
            System.out.println ("False");
            return;
        }
        int n = str1.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (str1[i] == str1[j]) {
                    if (str2[i] != str2[j]) {
                        System.out.println ("False");
                        return;
                    }
                }
            }
        }
     
        System.out.println ("True");
    }
}

