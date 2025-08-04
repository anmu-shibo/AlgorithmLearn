package AlgorithmTest;

import Algorithm.GasStation;
import org.junit.Test;

public class GasStationTest {
    GasStation gasStation = new GasStation();

    @Test
    public void test() {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int result = gasStation.canCompleteCircuit01(gas, cost);

        System.out.println(result);
    }

}
