package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

/**
 * 输入一个递增排序的数组和一个值k，请问如何在数组中找出两个和为k的数字并返回它们的下标？假设数组中存在且只存在
 * 一对符合条件的数字，同时一个数字不能使用两次。例如输入数组[1, 2, 4, 6, 10]，k的值为8，数组中的数字2和6的和为8，它们的下标分别为1和3。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/9 0:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/9 0:44
 * @UpdateRemark: 更新说明
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] source = new int[] {1,2,4,6,10};
        int[] result = twoSum(source,8);
        System.out.println(result[0] + ":" + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j && nums[i] + nums[j] != target) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{i, j};
    }
}
