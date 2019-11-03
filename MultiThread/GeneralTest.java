package MultiThread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-22 02:59
 **/
public class GeneralTest {
    public static void main(String[] args) {
        String s = "eaaaabaaec";
        List<Integer> res = partitionLabels (s);


        int[] arr = new int[]{1, 2, 3, 4};
        Integer[] nums = new Integer[]{1, 2, 3, 4};
        List<Integer> list = Arrays.asList (nums);
        for (int n : list) {
            System.out.println (n);
        }
    }

    static int[] f, g, v;

    static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<> ();
        if (S.length () < 1) return res;
        int[] stat = new int[26];
        for (int i = 0; i < S.length (); i++) {
            stat[S.charAt (i) - 'a'] = i;
        }
        int idx = 0;
        int cut = 0;
        while (idx < S.length ()) {
            int n = stat[S.charAt (idx) - 'a'];
            for (int i = idx; i < n; i++) {
                cut = Math.max (cut, stat[S.charAt (i) - 'a']);
            }
            System.out.println ("idx: " + idx);
            System.out.println ("cut: " + cut);
            res.add (cut - idx + 1);

            if (cut == idx) {
                System.out.println ("条件成立");
                break;
            }
            idx = cut + 1;
            System.out.println ("idx: " + idx);
            cut++;
        }
        return res;
    }

}
