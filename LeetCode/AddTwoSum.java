/**
 * 上海大学
 * FileName: AddTwoSum
 * Author:   bill
 * Date:     2018/7/12 20:08
 * Description:
 * History:
 */
package LeetCode;

public class AddTwoSum {
    public static void main(String[] args) {
        int[] a=new int[]{2,4,6,7,11,13};
        int[] b=addTwoSum(a,8);
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println("");
    }

    public static int[] addTwoSum(int[] n, int target) {
        int i = 0, j = n.length - 1;
        while (i < j) {
            if (n[i] + n[j] > target) {
                j--;
            } else if (n[i] + n[j] < target) {
                i++;
            } else {
                return new int[]{i+1, j+1};
            }
        }
        throw new IllegalArgumentException("new sum solution");
    }



}