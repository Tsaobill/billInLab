package _2019秋招笔试题.Tencent_0817;

import java.lang.annotation.Target;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-17 19:52
 **/
public class Main1 {
    public static void main(String[] args) {
        String str = "HG[3|B[2|CA]]F";
        System.out.println (decodeString (str));
    }

    public static String decodeString(String s) {
        String res = "";
        for (int i = 0; i < s.length (); ) {
            if (!isDigit (s.charAt (i)) && s.charAt (i) != '[') {
                res += s.charAt (i++);
            } else {
                int t = 0;
                i++;
                while (isDigit (s.charAt (i))) t = t * 10 + s.charAt (i++) - '0';
                int j = i + 1, sum = 1;
                while (sum > 0) {
                    if (s.charAt (j) == '[') sum++;
                    if (s.charAt (j) == ']') sum--;
                    j++;
                }
                String subRes = decodeString (s.substring (i + 1, j - 1));
                while (t > 0) {
                    res += subRes;
                    t--;
                }
                i = j;
            }
        }
        return res;
    }

    static boolean isDigit(char c) {
        return c >= 48 && c <= 57;
    }
}
