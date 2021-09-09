package com.gacrnd.gcs.algorithm.leetcode.binary;

import android.app.backup.RestoreObserver;

/**
 * @author Jack_Ou  created on 2021/1/6.
 */
public class MedianofTwoSortedArrays4 {

    public static int[] merge(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int m = 0;
        int n = 0;
        for (int i = 0; i < result.length; i++) {
            if (m >= nums1.length) {
                result[i] = nums2[n++];
            } else if (n >= nums2.length) {
                result[i] = nums1[m++];
            } else if (nums1[m] <= nums2[n]) {
                result[i] = nums1[m++];
            } else {
                result[i] = nums2[n++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,2,3};
        int[] nums2 = new int[] {2,3,4};
        int[] result = merge(nums1,nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
    }
}
