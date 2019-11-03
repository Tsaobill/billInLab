package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-15 17:12
 **/
public class RussianDoll {

    public static void main(String[] args) {

    }

    public int maxEnvelopes(int[][] nums) {
        sort (nums);
        for (int[] arr : nums) {
            for (int n : arr) {

            }
        }
        return 0;
    }

    void sort(int[][] nums) {
        Arrays.sort (nums, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
    }


}
