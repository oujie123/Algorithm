package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

/**
 * 输入一个由正整数组成的数组和一个正整数k，
 * 请问数组中有多少个数字乘积小于k的连续子数组？
 * 例如输入数组[10, 5, 2, 6]，k的值为100，有8个子数组的所有数字的乘积小于100，
 * 它们分别是[10]、[5]、[2]、[6]、[10, 5]、[5, 2]、[2, 6]和[5, 2, 6]。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/10 0:36
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/10 0:36
 * @UpdateRemark: 更新说明
 */
public class NumSubArrayProductLessThanK {

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[]{10,5,2,6}, 100));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; ++right) {
            product *= nums[right];
            while (left <= right && product >= k) {
                product /= nums[left];
                left++;
            }

            count += right >= left ? right - left + 1 : 0;
        }

        return count;
    }
}
