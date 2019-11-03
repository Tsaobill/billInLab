/**
 * @author
 * @create 2019-04-05 17:28
 **/
package _2019春招笔试题.Baidu;



public class MaxThreeProduct {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, -10, 1, 0};
        System.out.println(max_3_nums_Product(arr));
    }

    /**
     * @param arr 输入数组
     * @return 数组中三个数的最大乘积
     * 思路：遍历数组，保存最小的两个负数 和 最大的三个正数，
     * 最后比较最大三个数的乘积 和 两个负数乘最大正数的积，返回最大的
     */
    public static int max_3_nums_Product(int[] arr) {
        if (arr.length < 3) return Integer.MIN_VALUE;
        int[] neg = new int[2];//最大堆
        int[] pos = new int[3];//最小堆
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > pos[0]) {
                pos[0] = arr[i];
                int temp = pos[2] < pos[1] ? 2 : 1;
                swap(pos, 0, temp);
            }
            if (arr[i] <= neg[1]) {
                neg[0] = arr[i];
                swap(neg, 0, 1);

            }
            if (arr[i] < neg[0] && arr[i] > neg[1]) {
                neg[0] = arr[i];
            }
        }
        int maxPos = pos[1] > pos[2] ? pos[1] : pos[2];
        int max1 = maxPos * neg[0] * neg[1];
        int max2 = pos[0] * pos[1] * pos[2];
        return max1 > max2 ? max1 : max2;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
