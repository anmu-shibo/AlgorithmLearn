package Algorithm;

public class SumOfSortedArray {
    /**
     * 根据有序数组，和提供的值，计算数组中那两个数相加的和为目标值，返回这两个数的下标，从1开始计数
     * @param numbers numbers
     * @param target target
     * @return resultInts
     */
    public static int[] twoSum(int[] numbers, int target) {
        int[] resultInts = new int[2];
        //定义两个指针，分别指向数组的起始位置和末尾位置
        int left = 1;
        int right = numbers.length;
        while (left < right) {
            int sum = numbers[left - 1] + numbers[right - 1];
            if (sum == target) {
                resultInts = new int[]{left, right};
                //找到答案后肯定是要直接跳出循环的，所以这里直接用break即可
                break;
            } else if (sum < target) {
                left++;
            }  else {
                right--;
            }
        }
        return resultInts;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
