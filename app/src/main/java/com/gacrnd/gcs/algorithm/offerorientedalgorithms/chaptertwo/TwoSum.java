package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

/**
 * 排序数组中两个数字之和
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
