package _2019秋招笔试题.minglue_0915;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-15 15:51
 **/
public class Main2 {
    public static void main(String[] args) {
        double num = 151121.15d;
        long integer = (long) num;
        String radix = ((int) (num * 10) % 10) + "" + ((int) (num * 100) % 10);
        String[] intArr = new String[]{integer + "", radix};
        System.out.println (convert (intArr));

    }

    static String convert(String[] intArr) {
        int cnt = 0;
        String res = "";
        String integer = intArr[0];
        String radix = intArr[1];
        int numLen = integer.length ();
        int radixLen = radix.length ();
        for (int i = 0; i < numLen; i++) {
            int singleNum = integer.charAt (i) - 48;
            if (i != numLen - 1 && singleNum != 0) {
                cnt = 0;
                if (numLen - i > 4 && numLen - i <= 9)
                    res += numArr[singleNum] + units[numLen - 5 - i];
                else
                    res += numArr[singleNum] + units[numLen - 1 - i];
            } else {
                if (singleNum != 0) {
                    res += numArr[singleNum];
                }
                if (i < 5 && singleNum == 0 && numLen > 5 && numLen < 9) {
                    if (i == 3) res += units[0];
                }
                if (i != numLen - 1 && integer.charAt (i + 1) - 48 != 0)
                    res += numArr[singleNum];
                cnt++;
            }
        }
        if (radix.charAt (0) - 48 != 0 || radix.charAt (1) - 48 != 0) {
            res += "元";
            int jiao = radix.charAt (0) - 48;
            int fen = radix.charAt (1) - 48;
            if (jiao != 0 && fen != 0) {
                res += numArr[jiao] + radixUnit[0];
                res += numArr[fen] + radixUnit[1];
            } else if (jiao != 0) {
                res += numArr[jiao] + radixUnit[0];
            } else {
                res += numArr[fen] + radixUnit[1];
            }

        } else {
            res = res + "元整";
        }
        if (res.charAt (0) == '壹' && res.charAt (1) == '拾') {
            res = res.substring (1);
        }
        res = "人民币" + res;
        return res;
    }

    static String[] numArr = new String[]{"零", "壹", "贰", "叁", "肆", "伍", "陆",
            "柒", "捌", "玖"};
    static String[] units = new String[]{"万", "拾", "佰", "仟", "亿"};
    static String[] radixUnit = new String[]{"角", "分"};
}
