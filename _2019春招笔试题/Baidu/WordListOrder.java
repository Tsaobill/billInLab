/**
 * 单词排序
 *
 * @author
 * @create 2019-04-02 9:48
 **/

package _2019春招笔试题.Baidu;


import javafx.collections.ArrayChangeListener;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 判断一个字符串数组能够以 单词的首字母和前一个单词的尾字母相同；第一个的首和最后一个单词尾不作要求
 * 输入：一个字符串数组
 * 输出：1. 不能 返回 -1  2. 能 输出字符串数组
 *
 * 考虑回溯法
 */
public class WordListOrder {
    public static void main(String[] args) {
        String[] arr = new String[]{"ab", "cd", "ef", "bc", "de"};
        listOrder (arr, 0);

    }


    private static void listOrder(String[] arr, int k) {

        // 递归的基本情况（结束情况）
        if (k >= arr.length) {
            System.out.println (Arrays.toString (arr));
        }

        // 主要思路就是，
        // for循环从当前往后遍历，对每一个索引，看匹配不匹配，
        // 不匹配的过就跳到下一个
        // 匹配的话就把当前的加进去，然后递归调用
        for (int i = k; i < arr.length; i++) {
            if (k == 0) {
                swap (arr,k,i);
                listOrder (arr,k+1);
                swap (arr,k,i);
            }
            if (k > 0 && judge (arr[k - 1], arr[i])) {
                swap (arr,k,i);
                listOrder (arr,k+1);
                swap (arr,k,i);
            }
        }
    }

    private static boolean judge(String str1, String str2) {
        return str1.charAt (str1.length () - 1) == str2.charAt (0);
    }

    private static void swap(String[] arr, int n, int m) {
        String temp = arr[n];
        arr[n] = arr[m];
        arr[m] = temp;
    }

}
