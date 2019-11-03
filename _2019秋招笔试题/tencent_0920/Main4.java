package _2019秋招笔试题.tencent_0920;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-20 21:03
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt (), k = sc.nextInt ();
        PriorityQueue<Integer> pq = new PriorityQueue<> (n);
        int acc = 0;
        for (int i = 0; i < n; i++) {
            pq.offer (sc.nextInt ());
        }
        while (k-- > 0) {
            if (!pq.isEmpty ()) {
                int p = pq.poll ();
                int cur = p - acc;
                if (cur == 0) {
                    continue;
                } else if (cur < 0) {
                    System.out.println (0);
                } else {
                    System.out.println (cur);
                }
                acc = p;
            }else {
                System.out.println (0);
            }
        }
    }
}
