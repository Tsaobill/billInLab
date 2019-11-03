/**
 * 上海大学
 * FileName: WordReverse
 * Author:   bill
 * Date:     2018/7/14 17:44
 * Description: 反转字符串中的单词
 * History:
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class WordReverse {

    public static void main(String[] args) {
//        String s="the sky is blue";
//        System.out.println(s);
//        System.out.println("Two-Pass");
//        System.out.println(reverse(s));
//        System.out.println("升级版方法：");
//        System.out.println(reversePro(s));
//        System.out.println("NO Split:");
//        System.out.println(reverse1(s));
        int[] a=new int[]{0,1,2,3,4,5,6};
        reverseArray(a,3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print(" ");
        }
    }


/// 方法1： 分成两步：先分割得到一个字符串数组，再将其反转加到一个字符串上
    static String reverse(String s){
        String[] strNew= s.split(" ");//按空格分割
        StringBuilder sb=new StringBuilder();
        //System.out.println(sb.length());
        for (int i = strNew.length-1; i >=0; i--) {
            sb.append(strNew[i]+" ");
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }

    //（不用split()方程）
    static String reverse1(String s){

        ArrayList<String> strList=new ArrayList<>();
        for (int i = 0,j=0;i <=s.length(); i++) {
            if (i==s.length() ||s.charAt(i)==' '){
                strList.add(s.substring(j,i));
                j=i+1;
            }
        }
        StringBuilder sb=new StringBuilder();
        //System.out.println(sb.length());
        for (int i = strList.size()-1; i >=0; i--) {
            sb.append(strList.get(i)+" ");
        }
        return sb.toString().substring(0,sb.toString().length()-1);

    }

    ///方法2：一步
    static  String reversePro(String s ){
        StringBuilder sb=new StringBuilder();
        int j=s.length();
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)==' '){
                j=i;
            }else if(i==0 || s.charAt(i-1)==' '){
                if (sb.length()!=0){
                    sb.append(' ');
                }
                sb.append(s.substring(i,j));
            }
        }
        return sb.toString();
    }


    //Rotate an array to the right by k steps in-place without allocating extra space. For
    //instance, with k = 3, the array [0, 1, 2, 3, 4, 5, 6] is rotated to [4, 5, 6, 0, 1, 2, 3]
    static void reverseArray(int[] a,int k){
        rea(a,a.length-k,a.length-1);
        rea(a,0,a.length-k-1);
        rea(a,0,a.length-1);
    }
    static void rea(int[] a,int begin,int end){
        while (begin<end){
            int temp=a[begin];
            a[begin++]=a[end];
            a[end--]=temp;
        }

    }

}