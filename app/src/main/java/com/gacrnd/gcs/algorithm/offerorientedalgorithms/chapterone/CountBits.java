package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterone;

/**
 * 输入一个非负数n，请计算0到n之间每个数字的二进制表示中1的个数，并输出一个数组。例如，输入n为4，
 * 由于0、1、2、3、4的二进制表示的1的个数分别为0、1、1、2、1，因此输出数组[0, 1, 1, 2, 1]。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/7 23:35
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/7 23:35
 * @UpdateRemark: 更新说明
 */
public class CountBits {

    public static void main(String[] args) {
        int[] results = countBitsThree(10);
        for (int i = 0; i < results.length; i++) {
            System.out.println(i + " -> " + results[i]);
        }
    }

    /**
     * 根据 j & (j-1) 判断1的出现个数
     * 复杂的 O(nk)  k是一个数据的位数
     *
     * @param num
     * @return
     */
    public static int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int j = i;
            while (j != 0) {
                result[i]++;
                j = j & (j - 1);
            }
        }
        return result;
    }

    /**
     * 整数i始终是 i&(i-1) 多一个1
     *
     * @param num
     * @return
     */
    public static int[] countBitsTwo(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    /**
     * 根据i/2这一位推算下一位数
     * i >> 1是取出最右边那位，然后（i & 1）计算出i 最右那位判断奇偶
     *
     * @param num
     * @return
     */
    public static int[] countBitsThree(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
