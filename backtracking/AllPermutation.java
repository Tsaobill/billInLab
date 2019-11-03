package backtracking;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-29 14:45
 **/
public class AllPermutation {
    /**
     * 给定一个数n，写出从1到n的n个所有排列
     */

    public static void main(String[] args) {
        int max = 3;
        int[] arr = new int[max];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        dfsPermu (max, 0, arr);
        System.out.println (count);
        PriorityQueue<String> heap;
        StringBuilder sb = new StringBuilder ();
        String s ="";
    }

    static int count = 0;

    private static void dfsPermu(int n, int k, int[] arr) {
        if (k >= n) {
            System.out.println (Arrays.toString (arr));
            count++;
            return;
        }
        for (int i = k; i < n; i++) {
            swap (arr, i, k);
            dfsPermu (n, k + 1, arr);
            swap (arr, i, k);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
