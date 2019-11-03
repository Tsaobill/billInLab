package _2018秋招笔试题.美团;

import java.util.Scanner;

/**
 * 第2题
 * 判断自由树的结点度数序列
 * @version 1.0
 * @created by bill
 * @on 2018-10-09 下午8:58
 **/
public class Num2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int count = sc.nextInt ();

        for (int i = 0; i < count; i++) {
            int n=sc.nextInt ();
            String str=sc.nextLine ();
            String[] strArr=str.split (" ");
            int[] arr=new int[strArr.length];
            for (int j = 0; j < arr.length; j++) {
                arr[j]= Integer.parseInt (strArr[j]);
            }
            System.out.println (judge (new int[]{1, 2, 1, 3, 2, 1}, n));
        }

    }

    static String judge(int[] a, int x) {
        long n = (long) x;
        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= 0) return "No";
            sum += a[i];
        }
        return sum == 2 * (n - 1) ? "Yes" : "No";
    }
}
