package com.gacrnd.gcs.algorithm.leetcode.binary;

/**
 * @author Jack_Ou  created on 2021/1/6.
 */
public class SearchInRotatedSortedArrayII81 {

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] == nums[start]) {
                start++;
                continue;
            }
            //如果左边单调
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2,5,6,0,0,1,2};
        System.out.println(search(nums,0));
    }
}
