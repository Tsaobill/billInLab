package LeetCode;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-31 22:09
 **/
public class MedianofTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{
                1, 2
        };
        int[] nums2 = new int[]{
                3, 4
        };

        System.out.println (new MedianofTwoSortedArray ().findMedianSortedArrays (nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] arr = new int[n + m];
        int idxA = 0, idxB = 0;
        int idx = 0;
        while (idxA < n && idxB < m) {
            if (nums1[idxA] < nums2[idxB]) {
                arr[idx++] = nums1[idxA++];
            } else {
                arr[idx++] = nums2[idxB++];
            }
        }
        while (idxA < n) {
            arr[idx++] = nums1[idxA++];
        }
        while (idxB < m) {
            arr[idx++] = nums2[idxB++];
        }
        int mean = idx / 2;
        if ((idx & 1) == 0) {
            return (arr[mean] + arr[mean - 1]) / 2.0f;
        }
        return arr[mean];


    }
}
