package graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-28 19:50
 **/
public class Testss {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 9, 4, 6, 8, 11, 22, 45, 3};
        int CAP = 100000;
        int[] hash = new int[CAP];
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            min = Math.min (arr[i], min);
            max = Math.max (arr[i], max);
            hash[arr[i]]++;
        }
        for (; min <= max; min++) {
            if (hash[min] == 0) break;
        }
        System.out.println (Arrays.toString (arr));
        System.out.println (min);
    }

}
