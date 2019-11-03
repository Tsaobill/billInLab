package _2018秋招笔试题.DiDi;

import _2018秋招笔试题.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定入栈次序，求所有可能出栈次序
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-12 上午10:57
 **/
public class StackOutOrder {
    static int[] in = {1, 2, 3, 4};

    public static void main(String[] args) {
//        String s = "4132";
        String s = "3124";
//        String s = "4321";
        funOne (0, new Stack<Integer> (), "");
        if (res.contains (s)) {
            System.out.println ("Yes");
        } else {
            System.out.println ("No");
        }

    }

    static List<String> res = new ArrayList<> ();

    static void fun(int n, Stack<Integer> stk, String out) {

        if (n == in.length && stk.isEmpty ()) {
            res.add (out);
        }

        Stack<Integer> sin = (Stack<Integer>) stk.clone ();
        Stack<Integer> sout = (Stack<Integer>) stk.clone ();

        if (n < in.length) {
            sin.push (in[n]);
            fun (n + 1, sin, out);
        }

        if (!stk.isEmpty ()) {
            String temp = out + sout.pop ();
            fun (n, sout, temp);
        }
    }

    static void funOne(int n, Stack<Integer> stk, String out) {

        if (n == in.length && stk.isEmpty ()) {
            res.add (out);
        }


        if (n < in.length) {
            stk.push (in[n]);
            fun (n + 1, stk, out);
            stk.pop ();
        }

        if (!stk.isEmpty ()) {
            int m = stk.pop ();
            String temp = out + m;
            fun (n, stk, temp);
            stk.push (m);
        }
    }
}
