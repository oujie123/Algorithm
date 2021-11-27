package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterone;

/**
 * 一个数字在素组中出现一次的算法
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/8 7:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/8 7:22
 * @UpdateRemark: 更新说明
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,0,1,100};
        System.out.println(singleNumberAppearNTimes(nums,4));
    }

    /**
     * 一个数在数组中出现1次，其他数字都出现三次。找出出现一次的数字
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        int[] bitSum = new int[32];
        for (int i = 0; i < bitSum.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                bitSum[i] += (nums[j] >> (31 - i)) & 1;
            }
        }

        for (int i = 0; i < bitSum.length; i++) {
            result = (result << 1) + (bitSum[i] % 3);
        }
        return result;
    }

    public static int singleNumberAppearNTimes(int[] nums,int n) {
        int result = 0;
        int[] bitSum = new int[32];
        for (int i = 0; i < bitSum.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                bitSum[i] += (nums[j] >> (31 - i)) & 1;
            }
        }

        for (int i = 0; i < bitSum.length; i++) {
            result = (result << 1) + (bitSum[i] % n);
        }
        return result;
    }
}
