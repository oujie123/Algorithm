package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

/**
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: nums1 = [1,2,2,3,5,6]
 *
 * @author Jack_Ou  created on 2020/12/11.
 */
public class MergeSortedArray88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[pos--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        // 如果第二个数据还有值，需要全部放入第一个数组
        while (n >= 0) {
            nums1[pos--] = nums2[n--];
        }
    }

    public static void main(String[] args) {
//        String str = "5653525348485166838648487246694848";
//        for (int i = 0; i < str.length(); i += 2) {
//            String temp = str.substring(i, i + 2);
//            System.out.println((char) Integer.parseInt(temp));
//        }
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1, 3, num2, num2.length);
        for (int i = 0; i < num1.length; i++) {
            System.out.print(num1[i]);
        }
    }

}
