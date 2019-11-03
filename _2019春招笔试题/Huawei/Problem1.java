/**
 * 合法的时间
 *
 * @author
 * @create 2019-04-17 19:01
 **/

package _2019春招笔试题.Huawei;

import com.sun.source.tree.WhileLoopTree;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] strArr = str.substring(1, str.length() - 1).split(",");
        int[] arr = new int[6];
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        //给出6个数字 求能组合的24小时制的最大时间 如果不能组成输出invalid 否侧输出时间如 23:56:00


        Arrays.sort(arr);

        int idx = 0;
        while (idx < 6 && arr[idx] <= 2) {
            idx++;
        }
        if (idx == 0) {
            System.out.println("invalid");
            return;
        }
        if (idx == 6) {
            System.out.println(arr[5] + arr[4] + ":" + arr[3] + arr[2] + ":" + arr[1] + arr[0]);
            return;
        } else {
            if (arr[idx - 1] == 2) {
                int idxsec = idx;
                while (idxsec < 6 && arr[idxsec] <= 4) {
                    idxsec++;
                }
                System.out.println(arr[5] + arr[4] + ":" + arr[3] + arr[2] + ":" + arr[1] + arr[0]);
                System.out.println();
            } else {

            }
        }

    }
}