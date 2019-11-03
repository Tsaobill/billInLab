package LeetCode;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-10 18:23
 **/
public class MaxProfitStockWithFee {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;

        getMaxProfitWithFee (prices, fee);
    }
    // 不限交易次数
    private static void getMaxProfitWithFee(int[] prices, int fee) {
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        buy[0] = -prices[0];
        for (int i = 1; i < n; i++) {
            buy[i] = Math.max (buy[i - 1], sell[i - 1] - prices[i]);
            sell[i] = Math.max (sell[i - 1], buy[i - 1] + prices[i] - fee);
        }
        System.out.println (sell[n - 1]);
    }
}
