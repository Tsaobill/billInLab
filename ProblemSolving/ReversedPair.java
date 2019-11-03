package ProblemSolving;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 16:44
 **/
public class ReversedPair {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
        }
        int res = MergeSort (arr, 0, arr.length - 1);
        System.out.println (res);
    }

    public static int MergeSort(int sort_array[], int left, int right) {

        int sum = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort (sort_array, left, mid);
            MergeSort (sort_array, mid + 1, right);
            sum = Merge_Array (sort_array, left, right);
        }
        return sum;
    }

    private static int Merge_Array(int[] sort_array, int left, int right) {
        int mid = (left + right) / 2;
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {        //采用升序排序。
            if (sort_array[i] <= sort_array[j]) {
                temp[k++] = sort_array[i++];
            } else {
                count += mid - i + 1;     //计算当前片段序列的逆序对
                temp[k++] = sort_array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = sort_array[i++];
        }
        while (j <= right) {
            temp[k++] = sort_array[j++];
        }
        for (int f = 0; f < k; f++) {
            sort_array[left++] = temp[f];
        }
        return count;
    }
}
