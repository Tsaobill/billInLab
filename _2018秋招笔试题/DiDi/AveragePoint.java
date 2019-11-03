package _2018秋招笔试题.DiDi;

import java.util.*;

/**
 * 平均成绩排序
 *
 * @version 1.0
 * @created by bill
 * @on 2018-10-10 下午10:06
 **/
public class AveragePoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        HashMap<String, Integer> map = new HashMap<> ();
        List<Integer> list = new ArrayList<> ();
        while (true) {
            String[] strArr = sc.nextLine ().split (" ");
            String name = strArr[0];
            long t = 0;
            for (int i = 1; i < strArr.length; i++) {
                t += Integer.parseInt (strArr[i]);
            }
            Integer tt = Math.round (t);
            list.add (tt);
            map.put (name, tt);
            if (!sc.hasNext ()) break;
        }
//        int[] arr=Arrays.
    }
}
