/**
 * 上海大学
 * FileName: Solution4
 * Author:   bill
 * Date:     2018/8/27 20:13
 * Description:
 * History:
 */
package LeetCode;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        System.out.println(sumMaxOddDivisor(N));
        System.out.println(maxOddDivisor(N));
    }


    static int maxOddDivisor(int n) {
        int sum = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                sum += (n + 1) / 2 * (1 + n) / 2;
            } else {
                sum += n / 2 * (1 + n - 1) / 2;
            }
            n /= 2;
        }
        return sum;
    }
    private static int sumMaxOddDivisor(int n){
        if (n==1)return 1;
        /*
        * sum(n)=f(1)+...+f(n)=f(2)+f(4)+...+1+3+...+
        * 而所有的f(2k)=f(k),则有f(2)+f(4)+....=f(1)+f(2)+f(n/2)=sum(n/2)
        * sum(n)=sum(n/2)+1+3+...
        * */
        if (n%2==0){
            return sumMaxOddDivisor(n/2)+n*n/4;
        }else {
            return sumMaxOddDivisor(n/2) + (n+1)*(n+1)/4;
            //还可以用下面这种方式
            //return sumMaxOddDivisor(n-1)+n
            // 奇数的最大奇约数为本身，n 再加上前面偶数个  这样就把奇数又转化成了偶数的情况；
        }

    }
}

    //方法二
    /*
    * import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.println(sumOfMaxOdd(n));
        }
    }

     * 奇数的最大约数就是本身。问题就是求所有f(i), i为偶数的和 因为要求的是最大奇约数，所以f(2k) = f(k)，所以f(2) + f(4)
     * + ... + f(2k) = f(1) + f(2) + ... + f(k);
     *
     * sum(n) = sum (n / 2) + 1 + 3 + ... + n - 1 = sum (n/2) + n*n/4（n 为偶数）
     *
     *        = sum (n - 1) + n （n为奇数）
     *
    public static long sumOfMaxOdd(long n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return sumOfMaxOdd(n / 2) + n * n / 4;
        } else {
            return sumOfMaxOdd(n - 1) + n;
        }
    }


}

*/
