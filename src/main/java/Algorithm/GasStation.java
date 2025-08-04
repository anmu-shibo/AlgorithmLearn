package Algorithm;

import java.math.BigDecimal;

public class GasStation {

    /**
     *
     * 复杂度过高
     */
    public int canCompleteCircuit01(int[] gas, int[] cost) {

        int start;
        int restGas = 0;
        int n = gas.length;
        int result = -1;
        for (start = 0; start < n; start++) {
            restGas = gas[start];
            for (int i = 0; i < n; i++) {
                int index = (start + i) % n;
                int nextIndex = (start + i + 1) % n;
                if (restGas < cost[index]) {
                    break;
                }
                restGas -= cost[index];
                restGas += gas[nextIndex];
                if (nextIndex == start) {
                    result = start;
                }
            }
        }
        return result;
    }

    public int canCompleteCircuit02(int[] gas, int[] cost) {
        return -1;
    }
}
