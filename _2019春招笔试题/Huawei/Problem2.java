/**
 * @author
 * @create 2019-04-17 19:48
 **/

package _2019春招笔试题.Huawei;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        //买水果的最大利润  给出成本和价格 以及本金
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr1 = str.split(",");
        int[] cost = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            cost[i] = Integer.parseInt(arr1[i]);
        }
        str = in.nextLine();
        arr1 = str.split(",");
        int[] price = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            price[i] = Integer.parseInt(arr1[i]);

        }
        int mon = in.nextInt();
        sort(cost, price, 0, cost.length - 1);

        for (int i = 0; i < cost.length; i++) {
            if (mon >= cost[i]) {
                mon = mon + price[i] - cost[i];
            } else {
                break;
            }
        }
        System.out.println(mon);
    }

    public static void sort(int[] cost, int[] price, int lo, int hi) {
        if (lo < hi) {
            int n = partition(cost, price, lo, hi);
            sort(cost, price, lo, n - 1);
            sort(cost, price, n + 1, hi);
        }
    }

    public static int partition(int[] cost, int[] price, int lo, int hi) {
        int v = cost[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (cost[j] <= v) {
                swap(cost, price, ++i, j);
            }
        }
        swap(cost, price, i + 1, hi);
        return i + 1;
    }

    public static void swap(int[] cost, int[] price, int p, int q) {
        int temp1 = cost[p];
        cost[p] = cost[q];
        cost[q] = temp1;
        int temp2 = price[p];
        price[p] = price[q];
        price[q] = temp2;
    }
}
