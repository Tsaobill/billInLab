/**
 * @author
 * @create 2019-04-08 19:35
 **/

package _2019春招笔试题.Ctri;

import java.util.Scanner;

public class ListRing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int[] a = new int[128];
        for (int i = 0; i < str.length(); i++) {
            a[str.charAt(i++)]++;
        }
        boolean b = false;
        for (int i = 0; i < 128; i++) {
            if (a[i] > 1) {
                b = true;
                break;
            }
        }
        System.out.println(b);
    }
}

class Node {
    String val;
    Node next;

    Node(String val) {
        this.val = val;
    }

}