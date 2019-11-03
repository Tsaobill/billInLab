package _2019秋招笔试题.NetEase_0803;


import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-03 15:00
 **/
public class Main3 {
    public static void main(String[] args) {
        int[] nums = new int[]{53941, 38641, 31525, 75864, 29026, 12199, 83522, 58200, 64784, 80987};
        int n = nums.length;
        int num = nums[0];
        boolean s = (num & 1) == 1;
        boolean flag = false;
        for (int i = 1; i < n; i--) {
            if (s && (nums[i] & 1) == 0) {
                flag = true;
                break;
            }
            if (!s && (nums[i] & 1) == 1) {
                flag = true;
                break;
            }
        }
        if (flag) Arrays.sort (nums);
        for (int i = 0; i < n; i++) {
            System.out.print (nums[i] + " ");
        }
    }
}
