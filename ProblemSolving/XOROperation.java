package ProblemSolving;

/**
 * @version 1.0
 * @created by bill
 * 使用异或操作的一些题目合集
 * @on 2019-06-22 13:08
 **/
public class XOROperation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 5, 8, 7};
        int[] arr2 = new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 5, 8, 7, 9};
        System.out.println (uniqueNum (arr));
        uniqueNums (arr2);
        System.out.println (Is2sMi (16));
    }

    //找出数组中唯一出现一次的数，其余均出现2次
    public static int uniqueNum(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }

    //找出数组中唯二出现一次的数，其余均出现2次
    public static void uniqueNums(int[] arr) {
        int xorRes = 0;
        for (int num : arr) {
            xorRes ^= num;
        }
        int pos = 0;
        while (((xorRes >> pos) & 1) == 0) {
            pos++;
        }
        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if (((num >> pos) & 1) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        System.out.println ("第一个数：" + num1 + "，第二个数：" + num2);
    }

    //判断一个数是否是2的整数幂
    public static boolean Is2sMi(int n) {
        return 0 == (n & (n - 1));
    }

    //一个数的二进制表示中的1的个数
    public static void numsInBinary() {

    }

    //求数组中异或之后最大的两个数
    public static void maxNumsAfterXor() {

    }

}
