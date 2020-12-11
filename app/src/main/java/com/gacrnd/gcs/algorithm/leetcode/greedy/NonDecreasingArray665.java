package com.gacrnd.gcs.algorithm.leetcode.greedy;

/**
 * @author Jack_Ou  created on 2020/12/11.
 */
public class NonDecreasingArray665 {

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (count >= 2) return false;
                if (i >= 2 && nums[i - 2] < nums[i]) {
                    nums[i - 1] = nums[i];
                } else if (i >= 2 && nums[i - 2] > nums[i]){
                    nums[i] = nums[i - 1];
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,3};
        System.out.println(checkPossibility(nums));
    }
}
