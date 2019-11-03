package _2019秋招笔试题.qianxin;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-12 20:03
 **/
public class Main1 {
    public static String convert(int number) {
        String[] word = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        String[] unit = {"", "十", "百", "千", "万"};
        String res = String.valueOf (number);
        char[] charArray = res.toCharArray ();
        String str = "";
        int n = charArray.length;
        int a = Integer.valueOf (str);
        if(a/10==1){
            str+= "十"+word[a%10];
            return str;
        }

        for (int i = 0; i < n; i++) {
            int c = (int) charArray[i] - 48;
            if (c != 0) {
                str += word[c] + unit[n - i - 1];
            } else {
                if (i == n - 1) {
                } else {
                    if (charArray[i + 1] != '0') {
                        str += word[c];
                    }
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        String str = sc.next();

        for (int i = 0; i < str.length (); i++) {
            if (!Character.isDigit (str.charAt (i))) {
                System.out.println ("错误输入");
                return;
            }
        }
        System.out.println (convert (Integer.parseInt (str)));
    }

}
