package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

/**
 * 输入一个整数数组，如果一个数字左边的子数组数字之和等于右边的子数组数字之和，
 * 请返回该数字的下标。如果存在多个这样的数字，则返回最左边一个的下标。如果不存在这样的数字，
 * 则返回-1。例如在数组[1, 7, 3, 6, 2, 9]中，下标为3的数字（值为6）左边三个数字1、7、3和右边两
 * 个数字2和9的和相等，都是11，因此正确的输出值是3。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/13 0:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/13 0:00
 * @UpdateRemark: 更新说明
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[] {1,7,3,6,2,9};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int total = 0;
        for(int num: nums) {
            total += num;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if ((sum - nums[i]) == total - sum) {
                return i;
            }
        }

        return -1;
    }
}
