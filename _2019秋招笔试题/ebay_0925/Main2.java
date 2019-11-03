package _2019秋招笔试题.ebay_0925;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-25 20:14
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] arr = new int[n];
        Map<Integer, Integer> map = new HashMap<> ();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt ();
            if(!map.containsKey (arr[i])){
                map.put (arr[i],1);
            }else {
                int v = map.get (arr[i]);
                map.put (arr[i],v+1);
            }
        }
        int m = sc.nextInt ();
        for (int i = 0; i < m; i++) {
            int lo = sc.nextInt ();
            int hi = sc.nextInt ();
            int sum =0;
            for (int j = lo; j <= hi; j++) {
                if(map.get (arr[i])==1) sum++;
            }
            System.out.println (sum);
        }
    }
}
