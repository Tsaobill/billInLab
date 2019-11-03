package graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:25
 **/
public class BinaryGraphMaxMatch {
    static int[] h, e, ne, match;
    static boolean[] st;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1= sc.nextInt(); int n2 = sc.nextInt(); int m = sc.nextInt();
        int n = n1 + n2;
        h = new int[n+1]; e = new int[m]; ne = new int[m]; match = new int[n+1];
        st = new boolean[n+1];
        Arrays.fill(h, -1);
        for(int i = 0; i < m; i++){
            int x = sc.nextInt(); int y = sc.nextInt();
            e[i] = y; ne[i] = h[x]; h[x] = i;
        }

        int res = 0;
        for(int i = 1; i <= n1; i++){
            Arrays.fill(st, false);
            if(find(i)) res++;
        }
        System.out.println(res);
    }

    static boolean find(int x){
        for(int i = h[x]; i != -1; i = ne[i]){
            int j = e[i];
            if(!st[j]){
                st[j] = true;
                if(match[j] == 0 || find(match[j])){
                    match[j] = x;
                    return true;
                }
            }
        }
        return false;
    }

}
