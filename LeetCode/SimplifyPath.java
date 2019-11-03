package LeetCode;

import _2018秋招笔试题.DiDi.StackOutOrder;

import java.util.Stack;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-31 03:12
 **/
public class SimplifyPath {
    public static void main(String[] args) {
        System.out.println (new SimplifyPath ().simplifyPath ("/a/./b/../../c/"));
        StringBuilder sb = new StringBuilder ();
    }


    public String simplifyPath(String path) {
        if (path.length () <= 1) return "/";

        String[] paths = path.split ("/");

        Stack<String> s1 = new Stack<> ();
        Stack<String> s2 = new Stack<> ();

        for (int i = paths.length - 1; i > 0; i--) {
            if (!"".equals (paths[i])) s1.push (paths[i]);
        }
        // s2.push("/");
        while (!s1.isEmpty ()) {
            String str = s1.pop ();
            if (str.equals ("..")) {
                if (s2.size () > 0) s2.pop ();
            } else if (!str.equals (".")) {
                s2.push (str);
            }
        }
        if (s2.isEmpty ()) return "/";
        StringBuilder sb = new StringBuilder ();
        for (String s : s2) {
            sb.append ("/");
            sb.append (s);
        }
        return sb.toString ();
    }
}
