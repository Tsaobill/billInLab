/**
 * 给定一个由数组表示各位的数 将其加1
 *
 * @author
 * @create 2018-08-03 16:09
 **/

package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {
        List<Integer> num = new ArrayList<>();
        num.add(9);
        num.add(9);
        num.add(9);
        plusOne(num);
        for (int a :
                num) {
            System.out.print(a);
        }
    }
    public static void plusOne(List<Integer> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            int digit = a.get(i);
            if (digit < 9) {
                a.set(i, digit + 1);
                return;
            } else {
                a.set(i, 0);
            }
        }
        a.add(0);
        a.set(0, 1);
    }

}
