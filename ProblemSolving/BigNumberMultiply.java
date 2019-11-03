package ProblemSolving;

import java.time.Clock;
import java.util.Scanner;

/**
 * 大数乘法
 *
 * @version 1.0
 * @created by bill
 * @on 2018-09-14 上午10:29
 **/
public class BigNumberMultiply {
    public static void main(String[] args) {
        long start=System.currentTimeMillis ();

        Scanner sc = new Scanner (System.in);
        String str1 = sc.nextLine ();
        String str2 = sc.nextLine ();
        bigNumMulty (str1, str2);

        long end =System.currentTimeMillis ();
        System.out.println ("运行时长："+(end-start) +"ms");
    }

    private static void bigNumMulty(String str1, String str2) {
        int a[] = new int[200];
        int b[] = new int[200];
        int res[] = new int[400];


        boolean flag = true;
        if (str1.charAt (0) == '-') {
            flag = false;
            str1=str1.substring (1);
        }
        if (str2.charAt (0) == '-') {
            flag=!flag;
            str2=str2.substring (1);
        }

        int i, j;
        j = 0;
        for (i = str1.length () - 1; i >= 0; i--) {
            a[j++] = str1.charAt (i)-'0' ;
        }
        j = 0;
        for (i = str2.length () - 1; i >= 0; i--) {
            b[j++] = str2.charAt (i) - '0';
        }

        //进行计算
        //按照竖乘法规则循环计算，并将中间计算结果保存到对于的位置，暂不考虑进位
        for (i = 0; i < str1.length (); i++) {
            for (j = 0; j < str2.length (); j++) {
                res[i + j] += a[i] * b[j];
            }
        }

        //进位
        for (i = 0; i < res.length; i++) {
            if (res[i] > 9) {
                res[i + 1] += res[i] / 10;
                res[i] %= 10;
            }
        }

        int count = res.length - 1;
        while (res[count] == 0) {
            count--;
        }
        if (!flag) System.out.print ('-');
        for (i = count; i >= 0; i--) {
            System.out.print (res[i]);
        }
        System.out.println ();

    }
}
