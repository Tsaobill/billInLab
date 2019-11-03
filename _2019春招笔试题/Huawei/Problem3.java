/**
 * @author
 * @create 2019-04-17 19:48
 **/

package _2019春招笔试题.Huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        //m个cpu处理n个任务 从时间最小开始依次处理 求最时间
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        if (n > m) {
            System.out.println(arr[arr.length - 1]);
            return;
        }
        int index = n - 1;
        int sum = 0;
        while (index >= 0) {
            sum += arr[index];
            index -= m;
        }
        System.out.println(sum);

    }
}
