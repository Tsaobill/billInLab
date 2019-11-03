package _2018秋招笔试题.拼多多;

import java.util.*;

/*
* 判断是否子串 是返回index 否则返回-1
* */
public class Main {



    static int substringIndex(String source, String target) {
        char[] str = source.toCharArray ();
        char[] strSub = target.toCharArray ();
//        if (str == null || strSub == null) return -1;
        int lenStr = str.length;
        int lenSub = strSub.length;
        int len = lenStr - lenSub + 1;
        if (lenStr < lenSub) return -1;
        for (int i = 0; i < len; i++) {
            int j = 0;
            for (; j < lenSub; j++) {
                if (str[i + j] != strSub[j]) break;
            }
            if (j == lenSub) return i;
        }
        return -1;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        int res;

        String _source;
        try {
            _source = in.nextLine ();
        } catch (Exception e) {
            _source = null;
        }

        String _target;
        try {
            _target = in.nextLine ();
        } catch (Exception e) {
            _target = null;
        }

        res = substringIndex (_source, _target);
        System.out.println (String.valueOf (res));

    }
}
