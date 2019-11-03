package ProblemSolving;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-25 00:34
 **/
public class NQueensTest {
    public static void main(String[] args) {
        int size = 4;

        placeQueens (0, new int[size], size);
        System.out.println (size + "皇后，共有" + count + "种解法。by: new");
    }

    static int count = 0;

    private static void placeQueens(int n, int[] array, int size) {
        if (n == size) {
            print (array);
            return;
        }
        // 对当前行的每一个位置进行遍历
        for (int i = 0; i < size; i++) {
            array[n] = i;
            if (check (n, array)) {
                placeQueens (n + 1, array, size);
            }
        }
    }

    private static boolean check(int n, int[] array) {
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs (n - i) == Math.abs (array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[] array) {
        for (int a :
                array) {
            System.out.print (a + 1 + " ");

        }
        count++;
        System.out.println ();
    }
}