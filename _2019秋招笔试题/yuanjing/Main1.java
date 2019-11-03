package _2019秋招笔试题.yuanjing;

import java.util.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-29 19:33
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        int k = sc.nextInt ();
        int x = sc.nextInt ();
        String[] strArr = str.split (",");
        int[] arr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.valueOf (strArr[i]);
        }

        List<Integer> res = find (arr, k, x);
        int aa = res.size ();
        for (int i = 0; i < aa - 1; i++) {
            System.out.print (res.get (i));
            System.out.print (",");
        }
        System.out.println (res.get (aa - 1));

    }

    public static List<Integer> find(int[] arr, int k, int x) {
        int size = arr.length;

        int left = 0;
        int right = size - 1;
        int remo = size - k;
        while (remo > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            remo--;
        }
        List<Integer> res = new ArrayList<> ();
        for (int i = left; i < left + k; i++) {
            res.add (arr[i]);
        }
        return res;
    }

}
