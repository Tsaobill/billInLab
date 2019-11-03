package _2019秋招笔试题.microsoft_0922;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-22 20:11
 **/
public class Main1 {
    public static void main(String[] args) {
        String[] A = new String[]{"abcd","cdab"};
        System.out.println (solution (A));
    }
    static int solution(String[] A) {
        Set<String> set= new HashSet<> ();
        for (String s: A){
            int[] odd= new int[26];
            int[] even= new int[26];
            for (int i=0; i<s.length(); i++){
                if (i % 2 == 1) odd[s.charAt(i)-'a']++;
                else even[s.charAt(i)-'a']++;
            }
            String sig= Arrays.toString(odd)+ Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }
}
