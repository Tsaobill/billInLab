package _2019秋招笔试题.Zoom_0817;

/**
 * 浮点数组中的最大子数组乘积
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-17 14:24
 **/
public class Main1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        String str = sc.nextLine ();
//        String[] arr = str.split (",");
//        float[] nums = new float[arr.length];
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = Float.valueOf (arr[i]);
//        }
        double[] nums = new double[]{-3d, 1d, 0, 6, 0.9d, 8, -2};
        double lastmin = nums[0], lastmax = nums[0];
        double curmin = nums[0], curmax = nums[0];
        double max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curmin = Math.min (nums[i], lastmin * nums[i]);
            curmax = Math.max (nums[i], lastmax * nums[i]);
            max = Math.max (max, curmax);
            lastmax = curmax;
            lastmin = curmin;
        }
        System.out.println (max);
    }
}
