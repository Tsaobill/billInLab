/**
 * 上海大学
 * FileName: ValidNumber
 * Author:   bill
 * Date:     2018/7/17 21:09
 * Description: Validate if a given string is numeric
 * 验证一个给定的字符串是否是数字的
 * History:
 */
package LeetCode;

public class ValidNumber {
    public static void main(String[] args) {

        String s = "   +1 23456";
        System.out.println(validNumber(s));
    }

    static boolean validNumber(String str) {
        int i = 0, n = str.length(), flag = 0, count = 0;
        while (i < n) {
            if (Character.isWhitespace(str.charAt(i))) {
                if (count >= 1){
                    System.out.print("i = ");System.out.println(i);
                    System.out.print("flag = ");System.out.println(1);
                    return false;
                }
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (flag++>=1)return false;
            } else if (Character.isDigit(str.charAt(i))) {
                count++;
            } else {
                System.out.println("2");
                return false;
            }
            i++;
        }
        return true;
    }
}