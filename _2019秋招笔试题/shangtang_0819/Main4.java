package _2019秋招笔试题.shangtang_0819;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 完全平方数组
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-19 20:31
 **/
public class Main4 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        int n = sc.nextInt ();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt ();
//        }
        int[] arr = new int[]{3, 10, 6, 13};
        int[] arr1 = new int[]{8, 8, 8};
        int[] arr2 = new int[]{4, 5, 13, 12, 4};

        dfs (arr, 0);
        System.out.println (count);
    }

    static int count = 0;
    static TreeMap<String, String> map = new TreeMap<> ();

    static void dfs(int[] arr, int k) {
        if (k == arr.length) {
            String res = Arrays.toString (arr);
            if (!map.containsKey (res)) {
                map.put (res, "");
                count++;
            }
            return;
        }

        for (int i = k; i < arr.length; i++) {
            if (k > 0 && isComp (arr[i] + arr[k - 1])) {
                swap (arr, i, k);
                dfs (arr, k + 1);
                swap (arr, i, k);
            }
            if (k == 0) {
                swap (arr, i, k);
                dfs (arr, k + 1);
                swap (arr, i, k);
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static boolean isComp(int n) {
        for (int i = 1; i < n; i++) {
            if (i * i == n) return true;
        }
        return false;
    }
}
