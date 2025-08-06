package AlgorithmTest;

import Algorithm.MinSubArrayLen;
import org.junit.Test;

public class MinSubArrayLenTest {

    MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
    @Test
    public void test() {
//        int[] nums = new int[]{2,3,1,2,4,3};
//        int target = 7;
//        int result = minSubArrayLen.minSubArrayLen(target, nums);
//        System.out.println(result);


        int[] nums = new int[]{2,3,1,6,7,3};
        int target = 7;
        int result = minSubArrayLen.minSubArrayLen2(target, nums);
        System.out.println(result);

        String string = "abc";
        int j = 1;
        if (string.charAt(j) != (string.charAt(0))) {
            System.out.println("abc");
        }

    }
}
