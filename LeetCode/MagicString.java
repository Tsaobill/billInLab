package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-31 02:33
 **/
public class MagicString {
    public static void main(String[] args) {
        System.out.println (new MagicString ().magicalString (5));
    }

    public int magicalString(int n) {
        int[] ms = new int[n];
        ms[0] = 1;
        ms[1] = 2;
        ms[2] = 2;
        Stack<Integer> stack = new Stack<> ();

        int count = 3;
        int res = 1;
        for (int i = 2, k = 1; count < n; i++, k = 3 - k) {
            for (int j = 0; count < n && j < ms[i]; j++) {
                ms[count++] = k;
                if (k == 1) res++;
            }
        }
        return res;
    }
}
