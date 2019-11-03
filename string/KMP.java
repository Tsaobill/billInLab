package string;

import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-26 14:04
 **/
public class KMP {
        public static void main(String[] args){
            int n = 3;
            char[] p = "aba".toCharArray();
            int m = 5;
            char[] s = "ababa".toCharArray();
            int[] next = getNext(p);
            int i = 0, j = 0;
            while(i < s.length && j < p.length){
                if(j == -1 || s[i] == p[j]){
                    i++;
                    j++;
                }else j = next[j];
                // 下方为循环判断所有出现的次数，如果是判断是否存在并输出第一次出现
                // 的位置就不需要。
                if(j == p.length) {
                    System.out.print(i-j);
                    i = i - j + 1;
                    j = 0;
                }
            }
//            if(j == p.length) return i - j;
//            return -1;
        }
        static int[] getNext(char[] p){
            // char[] p = str.toCharArray();
            int i =0, j = -1;
            int[] next = new int[p.length];
            next[0] = -1;
            while(i < p.length - 1){
                if(j == -1 || p[j] == p[i]){
                    i++;
                    j++;
                    if(p[i] == p[j]) next[i] = next[j];
                    else next[i] = j;
                } else j = next[j];
            }
            return next;
        }
    }
