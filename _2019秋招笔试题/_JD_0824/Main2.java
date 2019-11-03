package _2019秋招笔试题._JD_0824;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-24 18:57
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int m = sc.nextInt ();
        Stu[] con = new Stu[2 * n + 1];
        for (int i = 0; i < con.length; i++) {
            con[i] = new Stu (i, 0);
        }
        boolean[][] g = new boolean[2 * n + 1][2 * n + 1];
        int res = 0;
        int[] num = new int[n];
        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt ();
            int y = sc.nextInt ();
            g[x][y] = true;
            g[y][x] = true;
            con[x].con = con[x].con + 1;
            con[y].con += 1;
        }
        Arrays.sort (con);
        while (m > 0) {
            reset (g, con[0].num, con);
            m -= con[0].con;
            num[res++] = con[0].num;
        }

        System.out.println (res);
        Arrays.sort (num);
        for (int i = 0; i < res; i++) {
            System.out.print (num[i] + " ");
        }
    }

    static void reset(boolean[][] arr, int idx, Stu[] con) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[idx][i]) {

                arr[idx][i] = false;
            }
            if (arr[i][idx]) {
                for (Stu s : con) {
                    if (s.num == i) s.con--;
                }
                arr[i][idx] = false;
            }
        }

    }
}

class Stu implements Comparable<Stu> {
    int num;
    int con;

    public Stu(int num, int con) {
        this.num = num;
        this.con = con;
    }

    @Override
    public int compareTo(Stu o) {
        if (this.con != o.con) return o.con - this.con;
        return this.num - o.num;
    }
}