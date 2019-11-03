/**
 * 插入排序
 *
 * @author
 * @create 2018-07-24 9:11
 **/

package LeetCode;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 4, 8, 23, 45, 11, 34, 6, 7, 1, 3, 9};
        inserSort1(array, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
        insertionSort(array, array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
    }


    private static void inserSort1(int[] array, int arrayLength) {
        int i, j, temp;
        for (i = 1; i < arrayLength; i++) {
            temp = array[i];
            j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

    }

    private static void insertionSort(int[] s, int n) {
        int i, j; /* counters */
        for (i = 1; i < n; i++) {
            j = i;
            while ((j > 0) && (s[j] < s[j - 1])) {
                swap(s, j, j - 1);
                j = j - 1;
            }
        }
    }

    private static void swap(int[] n, int a, int b) {
        n[a] = n[a] ^ n[b];
        n[b] = n[a] ^ n[b];
        n[a] = n[a] ^ n[b];
    }
}
