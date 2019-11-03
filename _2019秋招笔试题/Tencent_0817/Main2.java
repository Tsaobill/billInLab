package _2019秋招笔试题.Tencent_0817;

import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-17 19:55
 **/
public class Main2 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 4, 3, 6, 5, 8, 7};
        int n = 3;
        int m = 5;
        int[] q = new int[]{1, 2, 0, 2, 4};
        int cur = 0;
        while (cur < m) {
            int kk = 1;
            while (q[cur]-- > 0) {
                kk *= 2;
            }
            System.out.println ("kk="+kk);
            reverse (arr, kk);
            System.out.println (Arrays.toString (arr));
            int res = getReversed (arr);
            System.out.println (res);
            cur++;

        }

    }

    static int getReversed(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) res++;
            }
        }
        return res;
    }

    static void reverse(int[] arr, int k) {
        for (int i = 0; i < arr.length; i += k) {
            reverse (arr, i, i + k - 1);
        }
    }

    static void reverse(int[] arr, int i, int j) {
        if (j >= arr.length) j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
