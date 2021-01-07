package com.gacrnd.gcs.algorithm.leetcode.binary;

/**
 * @author Jack_Ou  created on 2021/1/6.
 */
public class SingleElementInaSortedArray540 {

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid+1]) {
                start = mid + 2;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}
