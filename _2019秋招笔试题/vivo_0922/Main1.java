package _2019秋招笔试题.vivo_0922;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-22 16:03
 **/
public class Main1 {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{2, 2, 3, 0, 4};
        System.out.println (solution (arr));
    }

    private static int solution(int[] input) {
        if (input.length == 0) return -1;
        int n = input.length;
        boolean res = dfs (0, 0, input);
        if (res) return min;
        return -1;
    }

    static int min = 0x3f3f3f3f;

    //2 2 3 0 4
    static boolean dfs(int cur, int step, int[] arr) {
        if (cur == arr.length - 1) {
            min = Math.min (step, min);
            return true;
        } else if (cur >= arr.length || arr[cur] == 0) {
            return false;
        }

        for (int i = arr[cur]; i > 0; i--) {
            boolean res = dfs (cur + i, step + 1, arr);
            if (res) return true;
        }
        return false;
    }
}
