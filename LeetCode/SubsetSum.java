/**
 * @author
 * @create 2019-02-22 16:40
 **/

package LeetCode;

public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(isSubsetSum(new int[]{1, 3, 5, 10,22}, 25));
    }

    private static boolean isSubsetSum(int[] a, int sum) {
        boolean[][] ss = new boolean[a.length + 1][sum + 1];
        for (int i = 0; i <= a.length; i++) {
            ss[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            ss[0][j] = false;
        }

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (a[i - 1] > j) {
                    ss[i][j] = ss[i - 1][j];
                } else {
                    ss[i][j] = ss[i - 1][j] || ss[i - 1][j - a[i - 1]];
                }
            }
        }
        return ss[a.length][sum];
    }
}
