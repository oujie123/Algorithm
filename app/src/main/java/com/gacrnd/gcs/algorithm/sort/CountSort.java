package com.gacrnd.gcs.algorithm.sort;

/**
 * 计数排序
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/12/22 23:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/22 23:10
 * @UpdateRemark: 更新说明
 */
public class CountSort {

    public int[] sortArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        int i = 0;
        for (int num = min; num <= max; num++) {
            while (count[num - min] > 0) {
                nums[i++] = num;
                count[num - min]--;
            }
        }
        return nums;
    }
}
