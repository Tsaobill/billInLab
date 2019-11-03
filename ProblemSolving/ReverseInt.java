/**
 * @author
 * @create 2018-08-03 15:57
 **/

package ProblemSolving;

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverseInteger(1000000003));
    }

    public static int reverseInteger(int n) {
        int ret = 0;
        while (n != 0) {
            if (Math.abs(ret) > 214748364) {
                return 0;
            }
            ret = ret * 10 + n % 10;
            n /= 10;
            /*
            * 对于int类型的数：
            * /10会从后面减少一位
            * %10会取最后一位
            * */
        }
        return ret;


    }
}
