package CLRS;

import java.util.*;


/**
 * @version 1.0
 * @created by bill for hand-write practice
 * @on 2019-05-17 13:43
 **/
public class qsortTest {
    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int[] arr1 = new int[]{11, 3, 5, 6, 8, 7, 9, 4, 10, 14, 1, 2, 12, 13};
        System.out.println ("trip Quick Sort Test=======================================");
        System.out.println ("排序前： " + Arrays.toString (arr));
        tripsort (arr, 0, arr.length - 1);
        System.out.println ("排序后： " + Arrays.toString (arr));
        System.out.println ("排序前： " + Arrays.toString (arr1));
        tripsort (arr1, 0, arr1.length - 1);
        System.out.println ("排序后： " + Arrays.toString (arr1));
        System.out.println ("=======================================");

        //qsort (arr, 0, arr.length - 1);

        sort (arr, 0, arr.length - 1);

        //qsortOpt (arr, 0, arr.length - 1);
        //qsortIteration (arr);
        System.out.println (Arrays.toString (arr));

        List<Integer> list = new ArrayList ();
        list.add (0, 2);
        TreeMap<Integer, String> hashMap = new TreeMap<> ();

    }

    //使用迭代，不用递归
    public static void qsortIteration(int[] arr) {
        Stack<Integer> stack = new Stack<> ();
        stack.push (arr.length - 1);
        stack.push (0);
        while (!stack.isEmpty ()) {
            int lo = stack.pop ();
            int hi = stack.pop ();
            if (hi - lo < 1) continue;
            int m = partition (arr, lo, hi);
            stack.push (hi);
            stack.push (m + 1);

            stack.push (m - 1);
            stack.push (lo);
        }

    }

    public static void qsort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int m = partition (arr, lo, hi);
            qsort (arr, lo, m - 1);
            qsort (arr, m + 1, hi);
        }
    }

    //最差栈深度仍为 lgn
    public static void qsortOpt(int[] arr, int lo, int hi) {
        while (lo < hi) {
            int m = partition (arr, lo, hi);
            if (m > (lo + hi) / 2) {
                qsortOpt (arr, lo, m - 1);
                lo = m + 1;
            } else {
                qsortOpt (arr, m + 1, hi);
                hi = m - 1;
            }
        }


        //System.out.println ("进阶优化");
    }

    // Nico Lotumo
    static int partition_lomuto(int[] arr, int lo, int hi) {
        //选lo作主元
        int i, m = lo;
        for (i = lo + 1; i <= hi; i++) {
            if (arr[i] < arr[lo]) swap (arr, ++m, i);
        }
        swap (arr, lo, m);
        return m;

        // 选hi作主元
//        int i, m = lo - 1;
//        for (i = lo; i < hi; i++) {
//            if (arr[i] < arr[hi]) swap (arr, ++m, i);
//        }
//        swap (arr, m + 1, hi);
//        return m + 1;
    }

    // Hoare Raw
    static int partition_hoareRaw(int[] arr, int lo, int hi) {
        System.out.println ("handy");
        //选lo作主元
//        int p = lo;
//        while(lo < hi){
//            while(lo < hi && arr[hi] >= arr[p]){
//                hi--;
//            }
//            while(lo < hi && arr[lo] <= arr[p]){
//                lo++;
//            }
//            swap(arr, lo, hi);
//        }
//        swap(arr, p, lo);
//        return lo;

        //选hi作主元
        int p = hi;
        while (lo < hi) {
            while (lo < hi && arr[lo] <= arr[p]) {
                lo++;
            }
            while (lo < hi && arr[hi] >= arr[p]) {
                hi--;
            }
            swap (arr, lo, hi);
        }
        swap (arr, p, hi);
        return hi;
    }

    //Hoare nest
    static int partition_nest(int[] arr, int lo, int hi) {
        System.out.println ("nest");
        //选hi作主元
//        int temp = arr[lo];
//        while(lo < hi){
//            while(lo < hi && arr[hi] >= temp){
//                hi--;
//            }
//            arr[lo] = arr[hi];
//            while(lo < hi && arr[lo] <= temp){
//                lo++;
//            }
//            arr[hi] = arr[lo];
//        }
//        arr[lo] = temp;
//        return lo;

        //选hi作主元
        int temp = arr[hi];
        while (lo < hi) {
            while (lo < hi && arr[lo] <= temp) {
                lo++;
            }
            arr[hi] = arr[lo];
            while (lo < hi && arr[hi] >= temp) {
                hi--;
            }
            arr[lo] = arr[hi];
        }
        arr[hi] = temp;
        return hi;
    }

    //Hoare algo4
    static int partition(int[] arr, int lo, int hi) {
//        System.out.println ("algo4");
        //选lo作主元
//        int i = lo, j = hi+1;
//        while(true){
//            while(arr[++i] < arr[lo]) if(i==hi) break;
//            while(arr[--j] > arr[lo]);
//            if(i >= j) break;
//            swap(arr, i, j);
//        }
//        swap(arr, lo, j);
//        return j;

        //选hi作主元
        while (true) {
            int i = lo - 1, j = hi;
            while (true) {
                while (arr[--j] > arr[hi]) if (j == lo) break;
                while (arr[++i] < arr[hi]) ;
                if (i >= j) break;
                swap (arr, i, j);
            }
            swap (arr, i, hi);
            return i;
        }
    }

    static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        //选lo做主元
        int p = arr[lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            if (arr[i] < p) swap (arr, lt++, i++);
            else if (arr[i] > p) swap (arr, i, gt--);
            else i++;
        }


//        //选hi做主元
//        int p = arr[hi];
//        int lt = lo, i = lo, gt = hi;
//        while (i <= gt) {
//            if (arr[i] < p) swap (arr, lt++, i++);
//            else if (arr[i] > p) swap (arr, i, gt--);
//            else i++;
//        }


        sort (arr, lo, lt - 1);
        sort (arr, gt + 1, hi);

    }

    // three-ways quickSort
    public static void tripsort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        // 选lo作主元 并随机交换
        swap (arr, lo, (lo + hi) >>> 1);
        System.out.println ("交换完： " + arr[lo]);
        int p = arr [lo];
        int lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            if (arr[i] < arr [lo]) swap (arr, lt++, i++);
            else if (arr[i] > arr [lo]) swap (arr, i, gt--);
            else i++;
        }

        tripsort (arr, lo, lt - 1);
        tripsort (arr, gt + 1, hi);

    }

    private static void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}