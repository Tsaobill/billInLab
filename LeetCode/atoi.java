/**
 * 上海大学
 * FileName: atoi
 * Author:   bill
 * Date:     2018/7/16 21:18
 * Description: 将字符串转换int 范围-2^63到2^63 - 1
 * History:
 */
package LeetCode;

public class atoi {
    private static final int DEV_10 = Integer.MAX_VALUE / 10;

    public static void main(String[] args) {
        String s = "    +1245,6 7  89";
        System.out.println(atoi(s));


    }

    static int atoi(String string) {
        int i = 0, n = string.length();
        while (i < n && Character.isWhitespace(string.charAt(i))) i++;
        int sign = 1;
        if (i < n && string.charAt(i) == '+') {
            i++;
        } else if (i < n && string.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        int num = 0;
        while (i < n ) {
            if ( Character.isDigit(string.charAt(i)))
            {
                int digit = Character.getNumericValue(string.charAt(i));
                if (num > DEV_10 || num == DEV_10 && digit >= 8) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                } else {
                    num = num * 10 + digit;
                }
            }
            i++;
        }
        return num * sign;
    }
}