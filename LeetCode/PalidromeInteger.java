/**
 * @author
 * @create 2018-08-03 16:43
 **/

package LeetCode;

public class PalidromeInteger {
    public static void main(String[] args) {
        System.out.println(isPali(78987));
    }

    public static boolean isPali(int a) {
        if (a < 0) {
            return false;
        }
        int div = 1;
        while (a / div >= 10) {
            div *= 10;
        }
        while (a != 0) {
            if (a / div != a % 10) {
                return false;
            }
            a = (a % div) / 10;
            div /= 100;
        }
        return true;
    }
}
