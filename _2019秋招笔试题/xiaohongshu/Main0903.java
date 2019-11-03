package _2019秋招笔试题.xiaohongshu;

import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-03 20:32
 **/
public class Main0903 {
    public static void main(String[] args) {
        String s = "a<<bde((c)<)<<";
        char[] c = s.toCharArray ();
        StringBuilder sb = new StringBuilder ();
        Stack<Character> stack = new Stack<> ();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                i++;
                int sum = 1;
                while (sum > 0) {
                    if (c[i] == '(') sum++;
                    if (c[i] == ')') sum--;
                    i++;
                }
                continue;
            }
            if (c[i] == '<' && !stack.isEmpty ()) {
                if (stack.peek () != ')') {
                    stack.pop ();
                }
                i++;
                continue;
            }
            stack.push (c[i]);
        }
        for (char e : stack) {
            sb.append (e);
        }
        System.out.println (sb.toString ());
    }
}
