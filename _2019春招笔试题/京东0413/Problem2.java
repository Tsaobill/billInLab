import java.util.Scanner;

/**
 * 给出m个字符串S1，S2，...，Sm和一个单独的字符串T。请在T中选出尽可能多的子串同时满足：
 * <p>
 * 1）这些子串在T中互不相交。
 * <p>
 * 2）这些子串都是S1，S2，...，Sm中的某个串。
 * <p>
 * 问最多能选出多少个子串。
 * <p>
 * 输入
 * 第一行一个数m（1≤m≤10），接下来m行，每行一个串。最后一行输入一个串T。
 * 输入中所有单个串的长度不超过100000，串中只会出现小写字母。
 * <p>
 * 输出
 * 输出一个数，最多能选出多少串。
 * <p>
 * 样例输入
 * 3
 * aa
 * b
 * ac
 * bbaac
 * 样例输出
 * 3
 * 提示
 * 样例解释：把T中字符从1开始编号，用[L,R]表示从第L个字符到第R个字符所构成的子串。
 * 一种选择子串的方法是[1,1],[2,2],[3,4]一共3个串，另一种选法是[1,1],[2,2],[4,5]一共也是3个串。
 * 注意不能同时选择子串[3,4],[4,5]因为它们相交了。
 */
public class Problem2 {
    public static void main(String[] args) {
        String tar = "bbaac";
        String[] strs = new String[]{"aa", "b", "ac"};
        System.out.println(isMatch(tar, strs));
    }


    public static int isMatch(String tar, String[] strs) {
        int len = tar.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int count = 0;
                for (int k = 0; k < strs.length; k++) {
                    if (tar.substring(i, j).equals(strs[k])) {
                        count += (1 + isMatch(tar.substring(j), strs));
                        break;
                    }
                }
                max = max < count ? count : max;

            }
        }
        return max;
    }
}
