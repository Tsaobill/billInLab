package CLRS;

import java.util.Arrays;
import java.util.Random;

/**
 * 手写练习及测试
 *
 * @version 1.0
 * @created by bill
 * @on 2019-05-19 13:13
 **/
public class BinarySearchHandyTest {
    static int TYPE = 7;
    static int ROUND = 10;

    public static void main(String[] args) {
        binarySearchTestHelper (ROUND);
        System.out.println (binarySearch (new int[]{71, 71, 72, 72, 74, 74, 96, 96}, 71));
        System.out.println (binarySearch (new int[]{51, 61, 63, 64, 67, 69, 70, 70, 73}, 51));
    }

    private static int binarySearch(int[] arr, int key) {
        if (TYPE == 0) {
            //原始 不考虑元素是否重复；
            int lo = 0, hi = arr.length - 1;
            while (lo <= hi) {
                int m = lo + (hi - lo) / 2;
                if (arr[m] > key) hi = m - 1;
                else if (arr[m] < key) lo = m + 1;
                else return m;
            }
            return -1;
        } else if (TYPE == 1) {
            //考虑重复，返回key第一次出现的索引
            //循环条件为 lo < hi
            int lo = 0, hi = arr.length - 1;
            while (lo < hi) {
                int m = lo + (hi - lo) / 2;
                if (arr[m] < key) lo = m + 1;
                else hi = m;//不能减1 因为arr[m]==key的情况也包括在内，如果减一，那么key只出现一次就找不到了
            }
            return arr[lo] == key ? lo : -1;
        } else if (TYPE == 2) {
            //考虑重复，返回key第一次出现的索引
            //循环条件为 lo < hi - 1 循环后面要判断lo和lo+1； （退出时lo=hi-1）
            int lo = 0, hi = arr.length - 1;
            while (lo < hi - 1) {
                int m = lo + (hi - lo) / 2;
                if (arr[m] < key) lo = m + 1;//甚至lo=m;
                else hi = m;
            }
            if (arr[lo] == key) return lo;
            if (arr[lo + 1] == key) return lo + 1;
            return -1;

        } else if (TYPE == 3) {
            //考虑重复，返回key最后一次出现的索引
            //循环条件必须为 lo < hi - 1 ，因为是往后找，将arr[m]小于key和等于key合并，因此这两种情况的操作只能为lo = m，
            // 此时 在lo = hi-1 时，m将永远等于left，而lo将一直=hi-1，因此lo<hi的条件将永远无法跳出
            // 循环后面要判断lo和lo+1； （退出时lo=hi-1）
            int lo = 0, hi = arr.length - 1;
            while (lo < hi - 1) {
                int m = lo + (hi - lo) / 2;
                if (arr[m] > key) hi = m - 1;//甚至hi=m
                else lo = m;//不能加1 因为arr[m]==key的情况也包括在内，如果加一，那么key只出现一次就找不到了
            }
            if (arr[hi] == key) return hi;
            if (arr[hi - 1] == key) return hi - 1;
            return -1;

        } else if (TYPE == 4) {
            //返回小于key值且最靠近key的那个所以====另一种做法 调用查找key第一次出现的位置，然后-1；
            // 返回小于key的元素的最大值(重复的话取最后一个)
            int lo = 0, hi = arr.length - 1;
            while (lo < hi - 1) {
                int m = (hi - lo) / 2 + lo;
                if (arr[m] < key) lo = m;
                else hi = m - 1;
            }
            if (arr[lo + 1] < key) return lo + 1;
            if (arr[lo] < key) return lo;
            return -1;
        } else if (TYPE == 5) {
            //返回第一个大于key的值得索引（无论key是否重复出现）
            int lo = 0, hi = arr.length - 1;
            while (lo < hi) {
                int m = (hi - lo) / 2 + lo;
                if (arr[m] > key) hi = m;
                else lo = m + 1;
            }
            if (arr[lo] > key) return lo;
            return -1;
        } else if (TYPE == 6) {
            // 返回大于等于key的最小值的索引
            // 1.如果存在返回最后一个key的索引
            // 2. 不存在第一个大于key的索引
            int lo = 0, hi = arr.length - 1;
            while (lo < hi - 1) {
                int m = (hi - lo) / 2 + lo;
                if (arr[m] > key) hi = m;
                else lo = m;
            }
            if (arr[lo] >= key) return lo;
            if (arr[lo + 1] > key) return lo + 1;
            return -1;
        } else if (TYPE == 7) {
            // 返回大于等于key的最小值的索引
            int lo = 0, hi = arr.length - 1;
            while (lo < hi - 1) {
                int m = (hi - lo)/2 + lo;
                if (arr[m] <= key) lo = m;
                else hi = m;
            }
            if (arr[lo] >= key) return lo;
            return hi;
        } else if(TYPE==8){
            // 返回小于等于key的最小值的索引
            // 1.如果存在返回key第一次出现的索引
            // 2. 不存在返回刚好小于key的索引
            int lo = 0, hi = arr.length - 1;
            while (lo < hi - 1) {
                int m = (hi - lo) / 2 + lo;
                if (arr[m] < key) lo = m;
                else hi = m;
            }
            if (arr[lo + 1] <= key) return lo + 1;
            if (arr[lo] <= key) return lo;
            return -1;
        }
        else if (TYPE==9){

        }
        return -1;

    }


    private static void binarySearchTestHelper(int testRound) {
        for (int i = 0; i < testRound; i++) {
            int[] arr = QuickSort.creatRandArr ();
            qsortTest.qsort (arr, 0, arr.length - 1);
            int key = 50 + new Random ().nextInt (20);
            System.out.println ("find " + key + "  in  " + Arrays.toString (arr));
            int index = binarySearch (arr, key);
            System.out.print (index);
            if (index >= 0) {
                System.out.print ("  " + (arr[index] == key));
            } else {
                System.out.print ("  未找到");
            }
            System.out.println ();
            System.out.println ("====================================================================");
        }
    }
}
