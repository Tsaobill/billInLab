package CLRS;

/**
 * Young氏矩阵
 * 算法导论 第六章思考题 6-3
 *
 * @version 1.0
 * @created by bill
 * @on 2018-09-28 上午9:31
 **/
public class YoungsTableau {
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] a = new int[][]{
                {2, 3, 4, 6, 8}, {5, 7, 9, 12, 13}, {6, 8, 11, 14, 15},
                {9, 10, 12, 15, 17}, {10, 12, 16, 19, 23}
        };
       /* System.out.println (Extract_Min (a, 1, 0));
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == MAX) System.out.print ("MAX ");
                else System.out.print (a[i][j] + " ");
            }
            System.out.println ();
        }*/

        System.out.println (CanSave (a, 16));
        int[] res = Youngs_Sort (a);
        for (int i = 0; i < res.length; i++) {
            if (res[i] == MAX) {
                System.out.print ("MAX ");
            } else {
                System.out.print (res[i] + " ");
            }
        }
        System.out.println ();
    }

    ///c 提取最小值；
    public static int Extract_Min(int[][] a, int i, int j) {
        int min = a[i][j];
        int flag = 0;
        while (i < a.length - 1 && j < a[0].length - 1) {
            if (a[i][j + 1] == MAX && a[i + 1][j] == MAX) {
                a[i][j] = MAX;
                flag = 0;
                break;
            }
            if (a[i + 1][j] < a[i][j + 1]) {
                a[i][j] = a[i + 1][j];
                i++;
                flag = 1;
            } else {
                a[i][j] = a[i][j + 1];
                j++;
                flag = 2;
            }
        }
        if (flag == 1) {
            while (j < a[0].length - 1 && a[i][j] < MAX) {
                a[i][j] = a[i][++j];
            }
        } else if (flag == 2) {
            while (i < a.length - 1 && a[i][j] < MAX) {
                a[i][j] = a[++i][j];
            }
        }
        a[i][j] = MAX;

        return min;
    }

    ///e:排序 O(n^3)时间排序n^2个数
    public static int[] Youngs_Sort(int[][] a) {
        int[] res = new int[a.length * a[0].length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Extract_Min (a, 0, 0);
        }
        return res;
    }
/// f:设计一个时间复杂度为O(m+n)的算法，他可以用来判断一个给定的数是否存储在m x n的Young氏矩阵中

    public static boolean CanSave(int[][] a, int n) {

        if (n < a[0][0] || n > a[a.length - 1][a[0].length - 1]) {
            return false;
        }
        int i = 0, j = 0;
        while (i < a.length - 1 && n > a[i][j]) {
            if (a[i][j] == n) return true;
            i++;
        }
        while (i >= 0 && j < a[0].length) {
            if (a[i][j] == n) return true;
            if (a[i][j] < n) j++;
            else i--;
        }
        return false;
    }
}