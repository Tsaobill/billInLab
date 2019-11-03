/**
 * 上海大学
 * FileName: OneEditDistance
 * Author:   bill
 * Date:     2018/7/29 21:29
 * Description: 判断两个字符串的编辑距离是否是1
 * 编辑距离 ：Edit Distance 又称Vladimir Levenshtein
 * History:
 */
package LeetCode;

public class OneEditDistance {
    public static void main(String[] args) {
        System.out.println(editDistance("bill", "tsao"));
        System.out.println(isOneDistance("bill","tsao"));
    }


    /*编辑距离算法
     *
     * 递归式:
     * d[0j]=j;
     * d[i0]=i;
     * d[ij]=min { d[i-1,j]+1 ; d[i,j-1}]+1 ; d[i-1,j-1]+1 }
     *
     * */
    private static int editDistance(String s, String t) {
        int[][] dis = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length() + 1; i++) {
            dis[i][0] = i;
        }
        for (int i = 0; i < t.length(); i++) {
            dis[0][i] = i;
        }
        int temp = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    temp = 0;
                else temp = 1;
                dis[i][j] = Math.min(dis[i - 1][j] > dis[i][j - 1] ? dis[i][j - 1] + 1 : dis[i - 1][j] + 1, dis[i - 1][j - 1] + temp);
            }
        }

        return dis[s.length()][t.length()];
    }


    //方法1: 利用求编辑距离的方法 判断是否为1  时间复杂度 O(mn),空间复杂度 O(mn) 也可优化为O(1)
    //方法2: O(n)runtime，O(1)space
    /*
    * 注意: 当对两个参数进行操作的时候 考虑对称性 如本方法的第3行当m>n将他们交换
    *
    *
    * */
    private static boolean isOneDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return isOneDistance(t, s);
        if (n - m > 1) return false;
        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        if (i == m) return shift > 0;
        //====================
        if (shift == 0) i++;//关键是这一步和下面的while循环
                            //如果m和n相等     那么s和t否跳过这不匹配的字符 继续匹配后面的
                            //如果m和n不相等(m+1=n) 那么s不跳过 而t跳过shift(为1)；
        while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
        //=====================




        return i == m;
    }

}