
import java.util.ArrayList;
import java.util.List;

/**
 * 栈的应用之
 * 编译器平衡符号的简单实现
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-16 下午2:11
 **/

public class BalanceCharacter {
    static boolean isPrime(int n){
        for (int i = 2; i < n/2; i++) {
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {

        System.out.println (isPrime (11));

        int n = 90;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        boolean[] st = new boolean[n];
        int idx = -1;
        int count = 0;
        int left = n;
        while (left > 0) {
            idx++;
            idx %= n;
            if (st[idx]) continue;
            count++;
            if ((count & 1) == 0) {
                st[idx] = true;
                left--;
            }
        }
        System.out.println (count);
        System.out.println (idx + 1);
    }




}