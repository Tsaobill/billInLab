/**
 * 上海大学
 * FileName: LongestPalindrome
 * Author:   bill
 * Date:     2018/7/28 11:17
 * Description: 求最长回文子串
 * History:
 */
package LeetCode;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    public static String getLongestSubstring(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expend(s, i, i);
            int len2 = expend(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }


    private static int expend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}