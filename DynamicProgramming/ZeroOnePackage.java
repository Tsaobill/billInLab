/**
 * @author
 * @create 2018-10-09 14:30
 **/

package DynamicProgramming;

public class ZeroOnePackage {
    public static void main(String[] args) {
        int[] price = new int[]{100, 20, 40, 50};
        int[] level = new int[]{380, 320, 360, 310};
        int money = 130;
        int maxGear = 3;

    }

    static int maxLevel(int money, int[] price, int[] level, int maxGear) {
        int[][] f = new int[price.length][maxGear];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j < maxGear; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 0;
                }else if (price[i]<j){
                    f[i][j]=f[i-1][j];
                }else {
                    f[i][j]=Math.max(f[i-1][j], 1);
                }
            }
        }
return 0;

    }
}
