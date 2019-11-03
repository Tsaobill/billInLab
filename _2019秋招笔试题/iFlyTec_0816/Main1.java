package _2019秋招笔试题.iFlyTec_0816;

import java.util.Arrays;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-16 18:16
 **/
public class Main1 {
    public static void main(String[] args) {
        String str3 = "爱讯飞789swr1wwen34ifly65tek";
        String str2 = "爱讯飞swrwweniflytek";
        char[] chars = str2.toCharArray ();
        int[] res = new int[chars.length];
        Arrays.fill (res, -1);
        int idx = 0;
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] - '0' >= 0 && chars[i] - '0' <= 9) {
                flag = true;
                res[idx++] = chars[i] - '0';
            }
        }
        if (!flag) {
            System.out.println (-1);
            return;
        }
        Arrays.sort (res);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == -1) continue;
            System.out.print (res[i]);
        }
    }
}
