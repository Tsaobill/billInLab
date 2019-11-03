package _2018秋招笔试题;
/**
 * @version 1.0
 * @created by bill
 * @on 2019-03-25 2:23 PM
 **/
public class FindTwoUniqueNums {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 6, 6, 5, 5, 7, 7, 23, 23, 34, 34, 45, 53};
        findNums (arr);
    }

    public static void findNums(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res ^= arr[i];
        }
        int pos = 0;
        for (int i = 0; i < 32; i++) {
            if (1 == ((res >> i) & 1)) {
                pos = i;
                break;
            }
        }
        int x = 0, y = 0;
        for (int i = 0; i < arr.length; i++) {
            if (1 == ((arr[i] >> pos) & 1)) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }
        System.out.println ("The two distinct numbers is " + x + " and " + y);
    }
}
