/**
 * 上海大学
 * FileName: LongestSubstring
 * Author:   bill
 * Date:     2018/7/16 22:03
 * Description: 不重复的最长子串长度
 * History:
 */
package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public static void main(String[] args) {
        String s = "abcedgbcfdagdc";
        System.out.println(length(s));
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
        String[] a = new String[265];
        a['9'] = "asdf";
        System.out.println( Array.get(a,'s'));
    }

    static int length(String s) {
        ArrayList<Character> a = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (a.contains(s.charAt(i))) {
                return length;
            } else {
                a.add(s.charAt(i));
                length++;
            }
        }
        return length;
    }

    //===========
    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;

                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }


    public static int lengthOfLongestSubstring1(String s) {
        int maxLen = 0;
        int availableFrom = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                int last = map.get(s.charAt(j));//拿到重复字符上一次出现的位置
                availableFrom = Math.max(availableFrom, last + 1);
            }
            maxLen = Math.max(maxLen, j - availableFrom + 1);//更新最大长度
            map.put(s.charAt(j), j);
        }
        return maxLen;
    }
}