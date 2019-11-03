package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-12 22:08
 **/
public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval mi = new MergeInterval ();
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals1 = new int[][]{{1, 4}, {4, 5}};
        int[][] intervals2 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {8, 23}, {9, 30}, {15, 18}, {35, 43}, {45, 50}, {50, 70}};
        mi.merge (intervals);
        mi.merge (intervals1);
        mi.merge (intervals2);
        System.out.println ("end");

    }

    public int[][] merge(int[][] intervals) {
        sort (intervals, 0, intervals.length - 1);

        List<int[]> list = new ArrayList<> ();
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] >= intervals[i + 1][1]) { // 第一个区间包含第二个区间
                intervals[i + 1] = intervals[i];
            } else if (intervals[i][0] == intervals[i + 1][0] && intervals[i][1] <= intervals[i + 1][1]) { // 第二个区间包含第一个区间
                // do nothing
            } else if (intervals[i][1] >= intervals[i + 1][0]) { // 两个区间相交
                intervals[i + 1][0] = intervals[i][0];
            } else {
                list.add (intervals[i]);
            }
        }
        list.add (intervals[intervals.length - 1]);
        int[][] res = new int[list.size ()][2];
        int i = 0;
        for (int[] arr : list) {
            System.out.print (Arrays.toString (arr) + "，");
            res[i++] = arr;
        }
        System.out.println ();
        return res;
    }

    public static void sort(int[][] arr, int lo, int hi) {
        if (lo >= hi) return;
        int m = partition (arr, lo, hi);
        sort (arr, lo, m - 1);
        sort (arr, m + 1, hi);
    }

    public static int partition(int[][] arr, int lo, int hi) {

        int m = lo, i;
        for (i = lo + 1; i <= hi; i++) {
            if (arr[i][0] < arr[lo][0]) {
                int[] temp = arr[i];
                arr[++m] = arr[i];
                arr[i] = temp;
            }
        }
        int[] temp = arr[m];
        arr[m] = arr[lo];
        arr[lo] = temp;
        return m;
    }
}
