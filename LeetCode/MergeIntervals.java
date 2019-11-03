package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-01 22:46
 **/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        new MergeIntervals ().merge (intervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return new int[0][0];
        //sort (intervals, 0, intervals.length - 1);
        for (int[] e : intervals) {
            System.out.println (e[0] + "," + e[1]);
        }
        System.out.println ("===============");
        List<int[]> list = new ArrayList<> ();

        java.util.Arrays.sort (intervals,(i1,i2)->Integer.compare (i1[0],i2[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            // i 的起点 小于等于 i+1的起点
            if (intervals[i][1] >= intervals[i + 1][1]) { // 第一个区间包含第二个区间
                intervals[i + 1] = intervals[i];
            } else if (intervals[i][0] == intervals[i + 1][0] && intervals[i][1] < intervals[i + 1][1]) { // 第二个区间包含第一个区间
                // do nothing
            } else if (intervals[i][1] < intervals[i + 1][0]) { // 两个区间分离
                list.add (intervals[i]);
            } else {
                intervals[i + 1][0] = intervals[i][0];
            }
        }
        list.add (intervals[intervals.length - 1]);
        int[][] res = new int[list.size ()][2];
        int i = 0;
        for (int[] arr : list) {
            res[i++] = arr;
        }

        return res;
    }

    public void sort(int[][] arr, int lo, int hi) {
        if (lo >= hi) return;
        int m = partition (arr, lo, hi);
        sort (arr, lo, m - 1);
        sort (arr, m + 1, hi);
    }

    public int partition(int[][] arr, int lo, int hi) {

        int m = lo, i;
        for (i = lo + 1; i <= hi; i++) {
            if (arr[i][0] < arr[lo][0]) {
                int[] temp = arr[++m];
                arr[m] = arr[i];
                arr[i] = temp;
            }
        }
        int[] temp = arr[m];
        arr[m] = arr[lo];
        arr[lo] = temp;
        return m;
    }
}
