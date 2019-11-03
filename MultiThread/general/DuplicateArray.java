package MultiThread.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-25 16:47
 **/
public class DuplicateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 3, 3, 5, 5, 6, 7, 7, 8, 8, 9};
        int right = 0;
        while (right < arr.length) {
            right = bsearchRight (arr[right], right, arr.length - 1, arr);
            System.out.print (arr[right]+" ");
            right++;
        }
        String str1 = "abc";
        String str2 = "de";
        StringBuilder sb = new StringBuilder ();
        sb.append (str1).append (str2);

    }

    static int bsearchRight(int key, int lo, int hi, int[] arr) {
        while (lo < hi - 1) {
            int m = lo + hi >> 1;
            if (arr[m] <= key) lo = m;
            else hi = m - 1;
        }
        return arr[hi] == key ? hi : lo;
    }
}

