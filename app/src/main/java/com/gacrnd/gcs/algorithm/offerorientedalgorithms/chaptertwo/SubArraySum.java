package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

import java.util.HashMap;

/**
 * 输入一个整数数组和一个整数k，请问数组中有多少个数字之和等于k的连续子数组？
 * 例如输入数组[1, 1, 1]，k的值为2，有2个连续子数组之和等于2。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/12 23:24
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/12 23:24
 * @UpdateRemark: 更新说明
 */
public class SubArraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1};
        System.out.println(subArraySum(nums,2));
    }

    public static int subArraySum(int[] nums, int k) {
        // key 存放sum
        // value 存放次数
        HashMap<Integer, Integer> sums = new HashMap<>();
        sums.put(0,1);  // 第一次sum与k相等

        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            count += sums.getOrDefault(sum - k, 0);
            sums.put(sum, sums.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
