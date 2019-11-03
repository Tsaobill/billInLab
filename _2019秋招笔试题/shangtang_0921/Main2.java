package _2019秋招笔试题.shangtang_0921;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 19:34
 **/
public class Main2 {
    public static void main(String[] args) {

        int n = 6;
        int[] arr = new int[]{3, -1, 8, 6, 5, 2};
//        Scanner sc = new Scanner (System.in);
//        int n = sc.nextInt ();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) arr[i] = sc.nextInt ();

        int maxNotCircle = NotCircleMaxValue (arr);
        int maxCircle = CircleMaxvalue (arr);
        int res = Math.max (maxCircle,maxNotCircle);
        System.out.println (res);

//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            int k = i, cnt = 0, sum = 0;
//            while (cnt++ < n) {
//                if (sum < 0) sum = 0;
//                k %= n;
//                sum += arr[k++];
//                max = Math.max (max, sum);
//            }
//        }
//        System.out.println (max);
    }

    public static int CircleMaxvalue(int[] a) {
        int minIndex = getMinindex (a);
        if (minIndex <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        int start = minIndex + 1;
        int maxvalue = a[start % a.length], sum = 0;
        for (int i = start; (i % a.length) != minIndex; i++) {
            if (sum > 0)
                sum += a[i % a.length];
            else
                sum = a[i % a.length];
            if (maxvalue < sum) {
                maxvalue = sum;
            }


        }
        return maxvalue;
    }


    public static int getMinindex(int[] a) {
        int minvalue = a[0], sum = 0, i = 0, MinIndex = 0;
        while (i < a.length) {
            if (sum < 0)
                sum += a[i];
            else
                sum = a[i];
            if (minvalue > sum) {
                minvalue = sum;
                MinIndex = i;
            }
            i++;
        }
        return MinIndex;

    }

    public static int NotCircleMaxValue(int[] a) {//求非环形结构时最大和字数组

        if (null == a || a.length <= 0) {
            System.out.println ("数组不合法");
            return Integer.MIN_VALUE;
        }
        int maxvalue = a[0], sum = 0, i = 0;
        while (i < a.length) {
            if (sum > 0)
                sum += a[i];
            else
                sum = a[i];
            if (maxvalue < sum) {
                maxvalue = sum;
            }
            i++;
        }

        return maxvalue;
    }

}
