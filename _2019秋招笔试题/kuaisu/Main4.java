package _2019秋招笔试题.kuaisu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-28 20:41
 **/
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        PriorityQueue<Integer> que = new PriorityQueue<Integer> (new Comparator<Integer> () {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {
            que.offer (sc.nextInt ());
        }
        while (que.size () > 1) {
            int y = que.poll ();
            int x = que.poll ();
            if (y > x) {
                que.offer (y - x);
            }
        }
        int res = 0;
        if (que.size () == 1) {
            res = que.poll ();
        }
        System.out.println (res);
    }
    /*
6
2 7 4 1 8 1

7
2 1 1 1 1 1 1
     */
}
