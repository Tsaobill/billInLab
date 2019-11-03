/**
 * 上海大学
 * FileName: Shuffling
 * Author:   bill
 * Date:     2018/8/25 16:58
 * Description: 洗牌
 * History:
 */
package LeetCode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class Shuffling {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }

        List<Integer> result = new ArrayList<>();
        int T, n, k;
        T = list.get(0);
        list = list.subList(1, list.size());
        for (int i = 0; i < T; i++) {
            n = list.get(0);
            k = list.get (1);
            List<Integer> ll = list.subList(2, (2 * n) + 2);
            result.addAll(shuffling(ll, k));
            list = list.subList((2 * n) + 2, list.size());
        }
        for (int i = 0; i < result.size() - 1; i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.print(result.get(result.size() - 1));
    }


    private static List<Integer> shuffling(List<Integer> list, int k) {
        int n = list.size() / 2;
        Integer[] result = new Integer[2 * n];
        while (k > 0) {
            for (int i = n; i < result.length - 1; i++) {
                result[((2 * (i + 1)) % (2 * n)) - 1] = list.get(i);
            }
            for (int i = 0; i < n; i++) {
                result[((2 * (i + 1) - 1) % (2 * n)) - 1] = list.get(i);
            }
            result[2 * n - 1] = list.get(2 * n - 1);
            list.clear();
            list.addAll(Arrays.asList(result));
            k--;
        }
        return list;
    }
}