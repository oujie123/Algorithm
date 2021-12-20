package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个数组，如何找出数组中所有和为0的三个数字的三元组？
 * 注意返回值中不得包含重复的三元组。例如在数组中[-1, 0, 1, 2, -1, -4]中
 * 有两个三元组的和为0，它们分别是[-1, 0, 1]和[-1, -1, 2]。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/9 0:57
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/9 0:57
 * @UpdateRemark: 更新说明
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for (int i = 0; i < result.size(); i++) {
            List<Integer> temp = result.get(i);
            System.out.println(temp.toString());
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3)
            return null;
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2) {
            twoSum(nums, i, result);

            // 防止重复，由于前面已经对数组进行排序，只需要顺序遍历就行
            int temp = nums[i];
            while (i < nums.length && temp == nums[i]) {
                i++;
            }
        }
        return result;
    }

    private static void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i;
        int k = nums.length - 1;

        while (j < k) {
            int sum = nums[j] + nums[k] + nums[i];
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int temp = nums[j];
                while (j < k && temp == nums[j]) {
                    j++;
                }
            } else if (sum > 0) {
                k--;
            } else {
                j++;
            }
        }
    }
}
