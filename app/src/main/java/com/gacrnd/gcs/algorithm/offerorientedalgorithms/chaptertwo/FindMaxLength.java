package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

import java.util.HashMap;

/**
 * 输入一个只包含0和1的数组，请问如何求最长0和1的个数相同的连续子数组的长度？
 * 例如在数组[0, 1, 0]中有两个子数组包含相同个数的0和1，分别是[0, 1]和[1, 0]，
 * 它们的长度都是2，因此输出2。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/12 23:44
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/12 23:44
 * @UpdateRemark: 更新说明
 */
public class FindMaxLength {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        // key 存放和
        // value 存放下标
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);

        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sumToIndex.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumToIndex.get(sum));
            } else {
                // 此次sum不能放到外面，因为是求最大长度，目标sum(0)不加入到map中
                // 放外面更新了sum为0的坐标
                System.out.println(sum + "->" + i);
                sumToIndex.put(sum, i);
            }

        }
        return maxLength;
    }
}
