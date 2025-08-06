package Algorithm;

import java.util.ArrayList;

public class MinSubArrayLen {
    /**
     * 寻找长度最短的数组，使得数组和大于等于target
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int resultLength = 1;
        int length = nums.length;
        //首先是根据是长度递增的去寻找
        while (resultLength <= nums.length) {
            //从下标0开始获取到长度为resultLength的数组
            for (int i = 0; i < length - resultLength; i++) {
                int sum = 0;
                //求和，如果大于等于target就直接返回结果长度
                for (int j = i; j < i + resultLength; j++) {
                    sum += nums[j];
                    if (sum >= target) {
                        return resultLength;
                    }
                }

            }
            resultLength++;
        }
        return 0;
    }

    /**
     * 滑动窗口解法
     * @param target
     * @param nums
     * @return
     */

    public int minSubArrayLen2(int target, int[] nums) {
        int resultLength = nums.length + 1;
        int right = 0;
        int sum = 0;
        int left = 0;
        //首先移动终点位置
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                sum -= nums[left];
                resultLength = Math.min(resultLength, right - left + 1);
                left++;
            }
            right++;
        }
        return resultLength <= nums.length ? resultLength: 0;
    }
}
