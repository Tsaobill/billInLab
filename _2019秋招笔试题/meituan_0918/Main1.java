package _2019秋招笔试题.meituan_0918;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-18 16:11
 **/
public class Main1 {
    // 布尔表达式求值，
    // 只会出现 true false and or
    // 表达式非法输出error
    public static void main(String[] args) {
        String str = "true or false and false";
        String str1 = "true and false";
        String str2 = "and";
        String[] arr = str.split (" ");
        if ((arr.length & 1) == 0) System.out.println ("error");
        if (arr.length == 1 && ("and".equals (arr[0]) || "or".equals (arr[0]))) {
            System.out.println ("error");
        }
        boolean res = false;

    }

    static boolean isOpt(String opt) {
        return opt.equals ("and") || opt.equals ("or");
    }

    static boolean isVal(String val) {
        return val.equals ("true") || val.equals ("false");
    }

}
