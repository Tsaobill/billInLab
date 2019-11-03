package ProblemSolving;

/**
 * 二维数组中的最长递减子序列
 *
 * @version 1.0
 * @created by bill
 * @on 2019-07-12 18:56
 **/
public class LDSTwoDimention {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int[][] arr1 = new int[][]{{1, 2, 3, 4, 5}, {10, 9, 8, 7, 6}, {11, 12, 13, 14, 15}};
        System.out.println (LDS (arr));
        System.out.println (LDS (arr1));
        System.out.println (LDS (new int[4][4]));
    }

    public static int LDS(int[][] arr) {
        int max = 0;
        int[][] res = new int[arr.length][arr[0].length];
        boolean[][] flag = new boolean[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!flag[i][j]) {
                    findMax (arr, flag, res, i, j);
                }
                max = res[i][j] > max ? res[i][j] : max;
            }
        }
        return max;
    }

    public static int findMax(int[][] arr, boolean[][] flag, int[][] res, int i, int j) {
        int uMax = 0, dMax = 0, lMax = 0, rMax = 0;

        // 计算上面一个元素
        if (i > 0 && arr[i][j] > arr[i - 1][j]) {
            if (!flag[i - 1][j]) {
                uMax = findMax (arr, flag, res, i - 1, j);
            } else {
                uMax = res[i - 1][j];
            }
        }

        // 计算下面一个元素
        if (i < arr.length - 1 && arr[i][j] > arr[i + 1][j]) {
            if (!flag[i + 1][j]) {
                dMax = findMax (arr, flag, res, i + 1, j);
            } else {
                dMax = res[i + 1][j];
            }
        }

        // 计算左面一个元素
        if (j > 0 && arr[i][j] > arr[i][j - 1]) {
            if (!flag[i][j - 1]) {
                lMax = findMax (arr, flag, res, i, j - 1);
            } else {
                lMax = res[i][j - 1];
            }
        }

        // 计算右面一个元素
        if (j < arr[0].length - 1 && arr[i][j] > arr[i][j + 1]) {
            if (!flag[i][j + 1]) {
                rMax = findMax (arr, flag, res, i, j + 1);
            } else {
                uMax = res[i][j + 1];
            }
        }

        res[i][j] = 1 + max (uMax, dMax, lMax, rMax);
        flag[i][j] = true;
        return res[i][j];
    }


    public static int max(int a, int b, int c, int d) {
        a = a > b ? a : b;
        a = a > c ? a : c;
        return a > d ? a : d;
    }
}
