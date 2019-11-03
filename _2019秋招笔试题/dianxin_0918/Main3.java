package _2019秋招笔试题.dianxin_0918;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-18 20:59
 **/
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String input = sc.nextLine ();
        input = input.substring (1, input.length () - 1);
        StringBuilder sb = new StringBuilder ();
        for (int i = 0; i < input.length (); i++) {
            if (input.charAt (i) != ' ') {
                sb.append (input.charAt (i));
            }
        }
        input = sb.toString ();
        String[] strArr = input.split (",");
        int n = strArr.length;
        int[] arr = new int[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf (strArr[i]);
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += arr[i];
            max = Math.max (max, sum);
        }
        System.out.println (max);
    }
}
