package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-29 15:53
 **/
public class ZuHe {
    public static void main(String[] args) {
        backt (0, 0, 2, 5, new int[2]);
    }

    public static void backt(int t, int s, int k, int max, int[] arr) {
        if (t >= k) {
            System.out.println (Arrays.toString (arr));
            return;
        }
        for (int i = s; i < max; i++) {
            arr[t] = i + 1;
            backt (t + 1, i + 1, k, max, arr);
        }
        List<Integer> list = new ArrayList<> ();


    }



}
