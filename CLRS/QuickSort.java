/**
 * 快速排序
 *
 * @author
 * @create 2018-12-03 16:49
 **/

package CLRS;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int testNum = 20;
        for (int i = 0; i < testNum; i++) {
            qSortTest ();
        }


//        int[] array = new int[]{3, 5, 6, 8, 7, 9, 4, 10};
//        quickSort (array, 0, array.length - 1);
//        System.out.println (isSorted (array));
    }


    private static void qSortTest() {
        int[] a = creatRandArr ();
        System.out.println ("=========================================================");
        System.out.print ("before:" + "\t");
        System.out.println (Arrays.toString (a));
        //quickSort (a, 0, a.length - 1);
        tripleWaysSort (a, 0, a.length - 1);
        System.out.print ("\n" + "after:" + "\t");
        System.out.println (Arrays.toString (a));
        System.out.println ("qSortResult:  " + isSorted (a));
    }

    private static void quickSort(int[] a, int lo, int hi) {
        if (lo < hi) {
            //System.out.println (Arrays.toString (a));
            int n = partition (a, lo, hi, 4);
            quickSort (a, lo, n - 1);
            quickSort (a, n + 1, hi);
        }
    }


    private static int partition(int[] arr, int lo, int hi, int type) {
        if (type == 0) {
            // Nico Lomuto 划分方法（CLRS也是 aka前后指针，此方法好处 单链表的快排也可以用

            int i = lo - 1;
            int v = arr[hi];
            for (int j = lo; j < hi; j++) {
                if (arr[j] < v) {//这里用<=也行，
                    // 不过是在循环不变式里左边为<=主元变成<主元
                    //而相应右边就由大于主元变成大于等于主元
                    swap (arr, ++i, j);
                }
            }
            swap (arr, i + 1, hi);
            return i + 1;
        } else if (type == 1) {
            //Hoare划分方法变种(空穴法) ，不用每次交换，直接赋值即可
            // 选hi必须先从lo开始  选lo则必须先从hi开始
//            int temp = arr[hi];
//            while (lo < hi) {
//                while (lo < hi && arr[lo] <= temp) {
//                    lo++;
//                }
//                arr[hi] = arr[lo];
//                while (lo < hi && arr[hi] >= temp) {
//                    hi--;
//                }
//                arr[lo] = arr[hi];
//            }
//            arr[hi] = temp;
//            return hi;
            int temp = arr[lo];
            while (lo < hi) {
                while (lo < hi && arr[hi] >= temp) {
                    hi--;
                }
                arr[lo] = arr[hi];
                while (lo < hi && arr[lo] <= temp) {
                    lo++;
                }
                arr[hi] = arr[lo];
            }
            arr[lo] = temp;
            return lo;


        } else if (type == 2) {
            //Hoare划分方法 选hi必须先从lo开始  选lo则必须先从hi开始
            int pivot = lo;
            while (lo < hi) {
                while (lo < hi && arr[hi] >= arr[pivot]) {
                    hi--;
                }
                while (lo < hi && arr[lo] <= arr[pivot]) {
                    lo++;
                }
                swap (arr, lo, hi);
            }
            swap (arr, lo, pivot);
            return lo;
        } else {
            System.out.println ("hi");
            int i = lo - 1, j = hi;
            while (true) {
                //这内循环有两种中止情况
                //1. i==hi 此时arr[i]依然小于v 接下来j=hi不成立第二个内循环不会进行,
                //   外循环中止i=j
                //2. arr[i] >= v, 此时外循环的中止时 j = i-1
                while (arr[++i] < arr[hi]) ;
                while (arr[--j] > arr[hi]) if (j == lo) break;

                //这个判断放在交换之前很有必要
                //如果将这个条件作为外循环的循环条件；由于内循环没有对i和j的位置进行判断
                // 因此大多数时候(注意不是最大或最小)循环退出的时候j会在i的前面一个位置
                //那么循环内的i和j上元素交换会出错，更不可能用后面的循环中i代替j和lo来交换
                //因为这样这样交换之后主元和i的位置依然很可能是错的
                if (i >= j) break;
                swap (arr, i, j);
            }
//            //根据循环不变式，i左边的都小于主元，j右边都大于主元
//            //循环结束时，
//            // 1.j=i-1，那么arr[j]小于主元，
//            // 2.j == i,根据上方分析知道arr[i]<小于主元，那么arr[j] 等于主元
            swap (arr, i, hi);
            return i;
        }


    }

    /**
     * 3 way quick sort
     *
     * @param arr the array to be sorted
     * @param lo  start index
     * @param hi  end index
     */
    private static void tripleWaysSort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        //选lo做主元
//        int lt = lo, i = lo + 1, gt = hi;
//        int v = arr[lo];
//        while (i <= gt) {
//            if (arr[i] < v) swap (arr, lt++, i++);
//            else if (arr[i] > v) swap (arr, i, gt--);
//            else i++;
//        }

        //选hi做主元
        int lt = lo, i = lo, gt = hi;
        int p = arr[hi];
        while (i <= gt) {
            if (arr[i] < p) swap (arr, lt++, i++);
            else if (arr[i] > p) swap (arr, i, gt--);
            else i++;
        }
        System.out.println ("three ways choose hi");
        tripleWaysSort (arr, lo, lt - 1);
        tripleWaysSort (arr, gt + 1, hi);

    }


    private static void swap(int[] n, int a, int b) {
        int t = n[a];
        n[a] = n[b];
        n[b] = t;
    }

    private static Random r = new Random ();

    public static int[] creatRandArr() {
        int length = 5 + r.nextInt (10);
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = 50 + r.nextInt (30);
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
