/**
 * N皇后问题回溯法
 *
 * @author
 * @create 2019-03-14 15:19
 **/

package ProblemSolving;

public class NQueens {
    public static void main(String[] args) {
        NQueens.placeQueens(0);
        System.out.println(max+"皇后，共有"+NQueens.count+"种解法。");
    }

    private static int count = 0;
    private static final int max = 9;
    private static int[] array = new int[max];

    private static void placeQueens(int n) {
        if (n == NQueens.max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (check(n)) {
                placeQueens(n + 1);
            }
        }
    }

    private static boolean check(int n) {
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    private static void print() {
        for (int a :
                array) {
            System.out.print(a + 1 + " ");

        }
        NQueens.count++;
        System.out.println();
    }
}
