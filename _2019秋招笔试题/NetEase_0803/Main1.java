package _2019秋招笔试题.NetEase_0803;


import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-03 14:59
 **/
public class Main1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        float n = sc.nextInt ();
//        float[] score = new float[(int) n];
//        for (int i = 0; i < n; i++) {
//            score[i] = sc.nextInt ();
//        }
//        int q = sc.nextInt ();
        int[] score = new int[]{100, 98, 87};
        Arrays.fill (score, -1);
        int idx = 1;
        double num = getNum (score, idx - 1) - 1;
        double res = num / score.length * 100f;
        String out = String.format ("%.6f", res);
        System.out.println (out);

    }

    static int getNum(int[] arr, int idx) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= arr[idx]) res++;
        }
        return res;
    }
}
