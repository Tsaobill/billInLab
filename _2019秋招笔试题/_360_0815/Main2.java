package _2019秋招笔试题._360_0815;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-15 18:58
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = 5; // 多少位
        int m = 5;// 进制
        int[] num1 = new int[]{4, 4, 1, 1, 1};
        int[] num2 = new int[]{4, 3, 0, 1, 2};
        int[] map = new int[m];
        for (int i = 0; i < n; i++) {
            map[num2[i]]++;
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int num = m - 1;
            while (num >= 0) {
                int over = num + m - num1[i];
                int temp = num - num1[i];
                if (temp >= 0 && temp < m && map[num - num1[i]] != 0) {
                    res[i] = num;
                    map[num - num1[i]]--;
                    break;
                } else if (over >= 0 && over < m && map[over] != 0) {
                    res[i] = num;
                    map[over]--;
                    break;
                }
                num--;
            }
        }
        Arrays.sort (res);
        for (int i = n - 1; i >= 0; i--) {
            System.out.print (res[i] + " ");
        }
    }
}
