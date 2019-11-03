package _2018秋招笔试题;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-01-06 6:19 PM
 **/
public class BigNum {


    /**
     * 大整数乘法
     *
     * @param bigNumberA  大整数A
     * @param bigNumberB  大整数B
     */
    public static String bigNumberMultiply(String bigNumberA, String bigNumberB) {
        boolean isNegative = false;
        if ((bigNumberA.startsWith ("-") && bigNumberB.startsWith ("-"))
                || (!bigNumberA.startsWith ("-") && !bigNumberB.startsWith ("-"))) {
            // 两数同符号的情况
            bigNumberA = bigNumberA.replaceAll ("-", "");
            bigNumberB = bigNumberB.replaceAll ("-", "");
        } else if ((bigNumberA.startsWith ("-") && !bigNumberB.startsWith ("-"))
                || (!bigNumberA.startsWith ("-") && bigNumberB.startsWith ("-"))) {
            // 两数不同符号的情况
            bigNumberA = bigNumberA.replace ("-", "");
            bigNumberB = bigNumberB.replace ("-", "");
            isNegative = true;
        }
        // 如果两数长度之和小于10，直接相乘返回
        if (bigNumberA.length () + bigNumberB.length () < 10) {
            // 计算乘积
            int tmp = (Integer.parseInt (bigNumberA) * Integer.parseInt (bigNumberB));
            if (tmp == 0) {
                return "0";
            }
            String value = String.valueOf (tmp);
            if (isNegative) {
                value = "-" + value;
            }
            return value;
        }
        // 公式 AC * 10^n+((A-B)(D-C)+AC+BD) * 10^(n/2)+BD当中的a,b,c,d
        String a, b, c, d;
        if (bigNumberA.length () == 1) {
            a = "0";
            b = bigNumberA;
        } else {
            if (bigNumberA.length () % 2 != 0) {
                bigNumberA = "0" + bigNumberA;
            }
            a = bigNumberA.substring (0, bigNumberA.length () / 2);
            b = bigNumberA.substring (bigNumberA.length () / 2);
        }
        if (bigNumberB.length () == 1) {
            c = "0";
            d = bigNumberB;
        } else {
            if (bigNumberB.length () % 2 != 0) {
                bigNumberB = "0" + bigNumberB;
            }
            c = bigNumberB.substring (0, bigNumberB.length () / 2);
            d = bigNumberB.substring (bigNumberB.length () / 2);
        }
        // 按最大位数取值，以确定补零数目
        int n = bigNumberA.length () >= bigNumberB.length () ? bigNumberA.length () : bigNumberB.length ();
//t1,t2为中间运算结果，t3为乘法运算完毕的结果
        String t1, t2, t3;
        String ac = bigNumberMultiply (a, c);
        String bd = bigNumberMultiply (b, d);
//t1=(A-B)(D-C)
        t1 = bigNumberMultiply (bigNumberSubtract (a, b), bigNumberSubtract (d, c));
//t2=(A-B)(D-C)+AC+BD
        t2 = bigNumberSum (bigNumberSum (t1, ac), bd);
//t3= AC * 10^n+((A-B)(D-C)+AC+BD) * 10^(n/2)+BD
        t3 = bigNumberSum (bigNumberSum (Power10 (ac, n), Power10 (t2, n / 2)), bd).replaceAll ("^0+", "");
        if (t3 == "")
            return "0";
        if (isNegative) {
            return "-" + t3;
        }
        return t3;
    }

    /**
     * 大整数加法
     *
     * @param bigNumberA  大整数A
     * @param bigNumberB  大整数B
     */
    public static String bigNumberSum(String bigNumberA, String bigNumberB) {
        if (bigNumberA.startsWith ("-") && !bigNumberB.startsWith ("-")) {
            return bigNumberSubtract (bigNumberB, bigNumberA.replaceAll ("^-", ""));
        } else if (!bigNumberA.startsWith ("-") && bigNumberB.startsWith ("-")) {
            return bigNumberSubtract (bigNumberA, bigNumberB.replaceAll ("^-", ""));
        } else if (bigNumberA.startsWith ("-") && bigNumberB.startsWith ("-")) {
            return "-" + bigNumberSum (bigNumberA.replaceAll ("^-", ""), bigNumberB.replaceAll ("^-", ""));
        }
//1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length () > bigNumberB.length () ? bigNumberA.length () : bigNumberB.length ();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < bigNumberA.length (); i++) {
            arrayA[i] = bigNumberA.charAt (bigNumberA.length () - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length (); i++) {
            arrayB[i] = bigNumberB.charAt (bigNumberB.length () - 1 - i) - '0';
        }
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength + 1];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp += arrayB[i];
//判断是否进位
            if (temp >= 10) {
                temp -= 10;
                result[i + 1] = 1;
            }
            result[i] = temp;
        }
//4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder ();
//是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append (result[i]);
        }
        return sb.toString ();
    }

    /**
     * 大整数减法
     *
     * @param bigNumberA  大整数A
     * @param bigNumberB  大整数B
     */
    public static String bigNumberSubtract(String bigNumberA, String bigNumberB) {
        int compareResult = compare (bigNumberA, bigNumberB);
        if (compareResult == 0) {
            return "0";
        }
        boolean isNegative = false;
        if (compareResult == -1) {
            String tmp = bigNumberB;
            bigNumberB = bigNumberA;
            bigNumberA = tmp;
            isNegative = true;
        }
//1.把两个大整数用数组逆序存储，数组长度等于较大整数位数+1
        int maxLength = bigNumberA.length () > bigNumberB.length () ? bigNumberA.length () : bigNumberB.length ();
        int[] arrayA = new int[maxLength + 1];
        for (int i = 0; i < bigNumberA.length (); i++) {
            arrayA[i] = bigNumberA.charAt (bigNumberA.length () - 1 - i) - '0';
        }
        int[] arrayB = new int[maxLength + 1];
        for (int i = 0; i < bigNumberB.length (); i++) {
            arrayB[i] = bigNumberB.charAt (bigNumberB.length () - 1 - i) - '0';
        }
        //2.构建result数组，数组长度等于较大整数位数+1
        int[] result = new int[maxLength + 1];
        //3.遍历数组，按位相加
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp += arrayA[i];
            temp -= arrayB[i];
            //判断是否进位
            if (temp < 0) {
                temp += 10;
                result[i + 1] = -1;
            }
            result[i] = temp;
        }
        //4.把result数组再次逆序并转成String
        StringBuilder sb = new StringBuilder ();
        //是否找到大整数的最高有效位
        boolean findFirst = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }
            sb.append (result[i]);
        }
        String value = sb.toString ();
        if (isNegative) {
            value = "-" + value;
        }
        return value;
    }

    // 比较大小
    private static int compare(String x, String y) {
        if (x.length () > y.length ()) {
            return 1;
        } else if (x.length () < y.length ()) {
            return -1;
        } else {
            for (int i = 0; i < x.length (); i++) {
                if (x.charAt (i) > y.charAt (i)) {
                    return 1;
                } else if (x.charAt (i) < y.charAt (i)) {
                    return -1;
                }
            }
            return 0;
        }
    }

    // 扩大10的n次方倍
    public static String Power10(String num, int n) {
        for (int i = 0; i < n; i++) {
            num += "0";
        }
        return num;
    }

    public static void main(String[] args) {
        String x = "1513143";
        String y = "9345963";
        System.out.println (bigNumberMultiply (x, y));
    }


}
