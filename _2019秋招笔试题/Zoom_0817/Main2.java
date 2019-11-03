package _2019秋招笔试题.Zoom_0817;

/**
 * 根据前序遍历判断是否为平衡二叉树
 *
 * @version 1.0
 * @created by bill
 * @on 2019-08-17 14:51
 **/
public class Main2 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner (System.in);
//        String str = sc.nextLine ();
//        String[] arr = str.split (",");
        String[] arr = new String[]{"1", "null", "3", "null", "null", "4", "5"};
        System.out.println (isAVL (arr, 0));

    }

    public static boolean isAVL(String[] arr, int i) {
        if (i >= arr.length || arr[i].equals ("null")) return true;
        return isBalanced (arr, i) && isAVL (arr, 2 * i + 1) && isAVL (arr, 2 * i + 2);
    }

    static boolean isBalanced(String[] arr, int i) {
        if (i >= arr.length || arr[i].equals ("null")) return true;
        int left = getMaxDepth (arr, 2 * i + 1);
        int right = getMaxDepth (arr, 2 * i + 2);
        return Math.abs (left - right) <= 1;
    }

    static int getMaxDepth(String[] arr, int i) {
        if (i >= arr.length || arr[i].equals ("null")) return 0;
        return Math.max (getMaxDepth (arr, 2 * i + 1), getMaxDepth (arr, 2 * i + 2)) + 1;
    }
}
