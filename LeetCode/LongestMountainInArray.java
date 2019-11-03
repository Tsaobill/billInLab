package LeetCode;

import java.util.Arrays;

/**
 * 数组中的最长山脉
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-05 02:27
 **/
class LongestMountainInArray {
    public static void main(String[] args) {
        LongestMountainInArray lm = new LongestMountainInArray ();
        int[] A = new int[]{2, 1, 4, 7, 3, 2, 5};
        int[] B = new int[]{2, 2, 2};
        int[] C = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] D = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] E = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println (lm.longestMountain (A));
        System.out.println (lm.longestMountain (B));
        System.out.println (lm.longestMountain (C));
        System.out.println (lm.longestMountain (D));
        System.out.println (lm.longestMountain (E));

    }


    /**
     * Runtime: 2 ms, faster than 99.83% of Java online submissions for Longest Mountain in Array.
     * Memory Usage: 38.6 MB, less than 100.00% of Java online submissions for Longest Mountain in Array.
     */
    public int longestMountain(int[] A) {
        int start = 0;
        int maxLen = 0;
        boolean grew = false;
        boolean shrink = false;
        for (int i = 1; i < A.length; ) {
            // need to grow before it shrinks
            while (i != A.length && A[i - 1] < A[i]) {
                i++;
                grew = true;
            }
            // while shrinking
            while (i != A.length && A[i - 1] > A[i] && grew) {
                i++;
                shrink = true;
            }

            // find out how much it grew
            if (shrink) {
                maxLen = maxLen > i - start ? maxLen : i - start;
            } else {
                // it didn't grow so just update pointer to look at AllPermutation index
                i++;
            }
            // reset the front to equal the back so we can begin looking for AllPermutation mountain
            start = i - 1;
            grew = false;
            shrink = false;
        }
        return maxLen;
    }
}
