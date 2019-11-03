package _2019秋招笔试题.Ctrip_0904;

import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-04 19:38
 **/
public class Main2 {
    static String resolve(String expr) {
        char[] c = expr.toCharArray ();
        int sum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') sum++;
            if (c[i] == ')') sum--;
        }
        if (sum != 0) {
            System.out.println ("不匹配");
            return "";
        }

        //dfs (c, 0, c.length - 1);
//
//        StringBuilder sb = new StringBuilder ();
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] != '(' && c[i] != ')') {
//                sb.append (c[i]);
//            }
//        }

        return stackM (expr);
    }

    static String stackM(String s) {
        Stack<Character> s1 = new Stack<> ();
        Stack<Character> s2 = new Stack<> ();
        for (int i = 0; i < s.length (); i++) {
            if (s.charAt (i) == ')') {
                while (s1.peek () != '(') {
                    s2.push (s1.pop ());
                }
                s1.pop ();
                for (char cc : s2) {
                    s1.push (cc);
                }
                s2.clear ();
            } else {
                s1.push (s.charAt (i));
            }
        }
        StringBuilder sb = new StringBuilder ();
        for (char cc : s1) sb.append (cc);
        return sb.toString ();
    }

    static int dfs(char[] c, int lo, int hi) {
        int t = lo;
        int i = lo;
        for (; i <= hi; i++) {
            if (c[i] == '(') {
                i++;
                t = i;
                while (c[i] != ')') {
                    if (c[i] == '(') {
                        i = dfs (c, i + 1, hi);
                    } else i++;
                }
            }
            if (c[i] == ')') {
                reverse (c, t, i - 1);
                return i + 1;
            }
        }
        return hi;
    }

    static void reverse(char[] c, int lo, int hi) {
        while (lo < hi) {
            swap (c, lo, hi);
            lo++;
            hi--;
        }
    }

    static void swap(char[] c, int a, int b) {
        char cc = c[a];
        c[a] = c[b];
        c[b] = cc;
    }


    /******************************结束写代码******************************/


    public static void main(String[] args) {
        String res;

        String _expr = "((ur)oi)";
        String _exprs = "(e(d(zx)f)adf)";

        res = resolve (_exprs);
        System.out.println (res);
    }
}

