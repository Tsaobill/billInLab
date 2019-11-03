package CLRS;

/**
 * 求数组的逆序对
 *
 * @version 1.0
 * @created by bill
 * @on 2018-12-20 7:07 PM
 **/
public class Inversion {
    public static void main(String[] args) {
        int[] a = new int[]{6, 5, 4, 3, 2, 1};
        int n = inversion (a, 0, a.length - 1);
        System.out.println ("=============");
        System.out.println (n);
        for (int i = 0; i < a.length; i++) {
            System.out.print (a[i] + ",");
        }
        System.out.println ();
    }

    static int inversion(int[] a, int p, int r) {
        if (p >= r) {
            return 0;
        }
        int inv = 0;
        int q = (p + r) / 2;
        inv += inversion (a, p, q);
        System.out.println (inv);

        inv += inversion (a, q + 1, r);
        System.out.println (inv);

        inv += merge_inversion (a, p, q, r);
        System.out.println (inv);

        return inv;
    }


    static int merge_inversion(int[] a, int p, int q, int r) {
        int inv = 0;
        int n = q - p + 1;
        int m = r - q;
        int[] left = new int[n];
        int[] right = new int[m];
        for (int i = 0; i < n; i++) {
            left[i] = a[p + i];
        }
        for (int i = 0; i < m; i++) {
            right[i] = a[q + i + 1];
        }
        int i = 0, j = 0;
        int i_old = -1;
        int k = p;
        while (i < n && j < m) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
                //对于inv的累加有两种方式，
                // 方法1：对于left中的每一个元素left[i]如果大于right[j],则right中前j个元素均可与left[i]构成逆序对共有 inv += j+1;
                // 方法2：对于right中的每一个元素 r j,如果小于left i，则left中从到最后所有元素均可与其构成逆序对共有 inv += n-i;
//                inv += n - i;
                if (i_old != i) {
                    inv += j + 1;
                    i_old = i;
                } else {
                    inv += 1;
                }
            }
        }
        while (i < n) {
            a[k++] = left[i++];
            inv += m;
        }
        while (j < m) {
            a[k++] = right[j++];
        }
        return inv;
    }
}








