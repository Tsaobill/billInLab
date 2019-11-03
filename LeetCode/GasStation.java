package LeetCode;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-13 15:25
 **/
public class GasStation {
    public static void main(String[] args) {
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        System.out.println (new GasStation ().canCompleteCircuit (gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGas, next;
        for (int i = 0; i < gas.length; i++) {
            curGas = gas[i];
            int j = i, k = 0;
            while (curGas >= cost[j] && k != gas.length) {
                next = j == gas.length - 1 ? 0 : j + 1;
                curGas = curGas - cost[j] + gas[next];
                j = next;
                k++;
            }
            if (k == gas.length) return i;
        }
        return -1;
    }
}
