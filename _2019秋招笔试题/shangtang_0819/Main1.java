package _2019秋招笔试题.shangtang_0819;

import java.util.Scanner;
import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-19 18:58
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine ();
        String[] strS = str.split (" ");
        Stack<Integer> stack = new Stack<> ();
        int num1 = 0, num2 = 0;
        for (int i = 0; i < strS.length; i++) {
            String s = strS[i];
            if (s.equals ("+")) {
                num1 = stack.pop ();
                num2 = stack.pop ();
                stack.push (num1 + num2);
            } else if (s.equals ("-")) {
                num1 = stack.pop ();
                num2 = stack.pop ();
                stack.push (num1 - num2);
            } else if (s.equals ("*")) {
                num1 = stack.pop ();
                num2 = stack.pop ();
                stack.push (num1 * num2);
            } else if (s.equals ("/")) {
                num1 = stack.pop ();
                num2 = stack.pop ();
                stack.push (num1 / num2);
            } else {
                stack.push (Integer.parseInt (s));
            }
        }
        int res = stack.pop ();
        System.out.println (res);
    }
}
