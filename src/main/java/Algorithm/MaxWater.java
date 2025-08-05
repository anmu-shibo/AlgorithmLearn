package Algorithm;

public class MaxWater {
    /**
     * 给定一个长度为 n 的整数数组 height。
     * 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
     * 求出最大储水量
     * @param height height
     * @return int
     */
    public static int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        //计算当前最大储水量
        int maxWater = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            //如果左边小于右边，根据木桶原理，左边的高度不可能成为最大储水量，所以移动左边的指针，反之移动右边的指针
            if (height[left] < height[right]) {
                left++;
                maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            } else {
                right--;
                maxWater = Math.max(maxWater, Math.min(height[left], height[right]) * (right - left));
            }
        }
        return  maxWater;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int[] arr1 = {1,1};
        System.out.println(maxArea(arr));
        System.out.println(maxArea(arr1));
    }
}
