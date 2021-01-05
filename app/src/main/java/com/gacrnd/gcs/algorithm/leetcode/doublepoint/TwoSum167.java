package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @author Jack_Ou  created on 2020/12/11.
 */
public class TwoSum167 {

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            // 用二分法去找下一个
            int low = i + 1;
            int high = numbers.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = (low + high) / 2;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] twoSumII(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum = 0;
        while (start < end) {
            sum = numbers[start] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[]{start + 1, end + 1};
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int[] res = twoSum(numbers, 18);
        System.out.println(res[0] + "===" + res[1]);
    }
}
