package CLRS;

/**
 * @version 1.0
 * @created by bill
 * @on 2018-12-18 8:04 PM
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] a = new int[]{2, 5, 4, 3, 6, 7, 1, 1, 3, 5, 22, 53, 435, 0, 0, 0, 0, 9, 8};
        mergeSort (a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.print (a[i] + ",");
        }
    }

    static void merge(int[] a, int p, int q, int r) {
         int n = q - p + 1;
        int m = r - q;
        int[] left = new int[n + 1];
        int[] right = new int[m + 1];
        for (int i = 0; i < n; i++) {
            left[i] = a[p + i];
        }

        for (int j = 0; j < m; j++) {
            right[j] = a[q + j + 1];
        }
        left[n] = Integer.MAX_VALUE;
        right[m] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (left[i] <= right[j]) {
                a[k] = left[i++];
            } else {
                a[k] = right[j++];
            }
        }
    }

    static void mergeSort(int[] a, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort (a, p, q);
            mergeSort (a, q + 1, r);
            merge (a, p, q, r);
        }
    }
}
