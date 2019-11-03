package LeetCode;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-09 21:45
 **/
public class MaxProfitStock {
    // 思路一：分割两次交易

    /**
     * 枚举第一次卖出的点，以第一次交易的卖出为分界线，分割两次交易，分别求出最大值(利用I中的解法)，
     * Tips：注意到第二次的卖出之前一定是递增，而之后一定是递减，可以利用这个先确定第二次卖出的点，
     * 然后在此之前的区间里遍历第一次卖出
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;

        int result = 0;
        int secSell = prices.length - 1;

        // 找到第二次交易的卖出点
        while (secSell > 0 && prices[secSell - 1] >= prices[secSell]) {
            secSell--;
        }

        // 在[0, secSell - 1]枚举第一次交易的卖出
        for (int i = 0; i < secSell; i++) {
            while (i < secSell && prices[i] <= prices[i + 1]) {
                i++;
            }

            int max = maxProfitHelper (prices, 0, i) + maxProfitHelper (prices, i, secSell);
            result = max > result ? max : result;
        }
        return result;
    }

    public int maxProfitHelper(int[] prices, int lo, int hi) {
        if (lo >= hi) return 0;

        int min = prices[lo];
        int max = 0;
        for (int i = lo + 1; i <= hi; i++) {
            min = Math.min (min, prices[i]);
            max = Math.max (prices[i] - min, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        int res = new MaxProfitStock ().maxProfit (prices);
        System.out.println (res);
    }
}
