/**
 * 上海大学
 * FileName: WordReverseInPlace
 * Author:   bill
 * Date:     2018/7/14 19:23
 * Description: 在原本字符串中反转单词
 * History:
 */
package LeetCode;

public class WordReverseInPlace {
    public static void main(String[] args) {
        char[] s = "the sky is blue".toCharArray();
        wordReverseInPlace(s);
        System.out.println(s);
    }


     private static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[--end];
            s[end] = s[start];
            s[start++] = temp;
        }
    }
    private static void wordReverseInPlace(char[] s) {
        reverse(s, 0, s.length );
        for (int i = 0, j = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(s, j, i );
                j = i + 1;
            }
        }
    }

}