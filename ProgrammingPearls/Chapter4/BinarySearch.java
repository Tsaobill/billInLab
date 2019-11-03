package ProgrammingPearls.Chapter4;

/**
 * 正确编写二分搜索
 *
 * @version 1.0
 * @created by bill
 * @on 2018-09-29 下午2:30
 **/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[30];
        for (int i = 0; i < 30; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < 30; i++) {
            System.out.print (binarySearch (arr,i+1)+",");
        }

        System.out.println (binarySearch (arr, 30));
        System.out.println (count);
    }

    public static int count = 0;

    public static int binarySearch(int[] a, int n) {
        int hi = a.length - 1, low = 0;
        if (n < a[low] || n > a[hi]) {
            return -1;
        }
        if (a[low] == n) return low;
        if (a[hi] == n) return hi;
        int p;
        while (low < hi-1) {
            count++;
            p = low + (hi - low) / 2;
            if (a[p] == n) {
                return p;
            } else {
                if (a[p] > n) {
                    hi = p;
                } else {
                    low = p;
                }
            }
        }
        return -1;
    }

}
