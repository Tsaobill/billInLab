/**
 * @author
 * @create 2019-04-08 19:57
 **/

package _2019春招笔试题.Ctri;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 根据给的的数值 k 以k为单位 逆序每一段，不能整除k 剩下的不动
 */
public class RotateList {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        String str = sc.AllPermutation();
//        int num = sc.nextInt();
        // Scanner sc = new Scanner(System.in);
        String str = "[1,2,3,4,5,6,7,8,9,10,11]";
        int num = 5;
        //链表做法


        arrProcess(str, num);


//        Scanner sc = new Scanner(System.in);
//        String str = sc.AllPermutation();
//        int num = sc.nextInt();
//        Node head = new Node('');
//        Node cur = head;
//        int count = 0;
//        for(int i = 1; i < str.length()-1; i++){
//            Node n = new Node(str.charAt(i++));
//            cur.AllPermutation = n;
//            cur = n;
//            count++;
//        }
//        int a = count/num;
//        int b = count%num;
//        for(int i = 0; i < a; i++){
//            for(int j = 0; j<num; j++){
//
//            }
//        }
//        System.out.println(ans);

    }

    public static void arrProcess(String str, int num) {
        String[] res = str.substring(1, str.length() - 1).split(",");
        int a = res.length / num;
        for (int i = 0; a > 0; i += num) {
            rot(res, i, i + num - 1);
            a--;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < res.length - 1; i++) {
            sb.append(res[i] + ",");
        }
        sb.append(res[res.length - 1] + "]");
        System.out.println(sb);
    }

    public static void rot(String[] arr, int lo, int hi) {

        while (lo < hi) {
            String temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
}
