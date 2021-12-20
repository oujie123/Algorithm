package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

/**
 * 输入一个正整数组成的数组和一个正整数k，请问数组中和大于或等于k的连续
 * 子数组的最短长度是多少？如果不存在所有数字之和大于k的子数组，则返回0。
 * 例如输入数组[5, 1, 4, 3]，k的值为7，和大于或等于7的最短连续子数组是[4, 3]，因此输出它的长度2。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/9 23:52
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/9 23:52
 * @UpdateRemark: 更新说明
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{5, 1, 4, 3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int k = 0; k < nums.length; k++) {
            sum += nums[k];
            while (i < k && sum >= target) {
                minLen = Math.min(minLen, k - i + 1);
                sum -= nums[i++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
