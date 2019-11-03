package _2019秋招笔试题.bytedance_0825;

// 并查集
public class Main11 {
    public static void main(String[] args) {
        int n = 3;
        int[][] g = new int[][]{{0, 4, 0}, {4, 0, 6}, {0, 6, 0}};

        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = i;
        }
        int res = n;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (g[i][j] >= 3) {
                    int a = unionSearch (i, pre);
                    int b = unionSearch (j, pre);
                    if (a != b) {
                        pre[b] = a;
                        res--;
                    }
                }
            }
        }
        System.out.println (res);
    }

    static void join(int a, int b, int[] pre) {
        int x = unionSearch (a, pre);
        int y = unionSearch (b, pre);
        if (x != y)
            pre[y] = x;
    }

    static int unionSearch(int ele, int[] pre) {
        while (ele != pre[ele]) {
            pre[ele] = pre[pre[ele]];
            ele = pre[ele];
        }
        return ele;
    }
}