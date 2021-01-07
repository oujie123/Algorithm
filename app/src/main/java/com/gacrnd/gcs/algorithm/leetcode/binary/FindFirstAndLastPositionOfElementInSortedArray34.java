package com.gacrnd.gcs.algorithm.leetcode.binary;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/1/5 23:34
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/5 23:34
 * @UpdateRemark: 更新说明
 */
public class FindFirstAndLastPositionOfElementInSortedArray34 {

    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    /**
     *
     * @param nums
     * @param target
     * @param lower 为false的话，是查找目标大的第一个数的位置，如果为true，就一直缩短右边界，使得找到最左的target值
     * @return
     */
    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * [5,7,7,8,8,10]
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[] {5,7,7,8,8,10};
        //3
        System.out.println(binarySearch(array,7,true));
    }
}
