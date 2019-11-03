/**
 * @author
 * @create 2019-04-09 20:15
 **/

package com.Zhaohang;
//输入 n代表有男女各n人，没人一个杯子，w代表总的水量。2n个数代表每个杯子的容量：
//要求 男的杯子水相同，女的相同 男的是女的二倍，求最大装水量
public class Problem2 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        int n = 3;
        int w = 18;
        float minMale = 4;
        float minFe = 2;
        float res;
        if (minMale < minFe * 2) {
            //
            if (1.5 * n * minMale < w) {
                res = 1.5f * minMale;
            } else {
                res = w;
            }
        } else {
            //
            if (3 * n * minFe < w) {
                res = 3f * minMale;
            } else {
                res = w;
            }
        }
        String str = String.format("%.6f", res);
        System.out.println(str);
    }
}
