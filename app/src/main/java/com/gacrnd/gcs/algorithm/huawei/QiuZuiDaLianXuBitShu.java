package com.gacrnd.gcs.algorithm.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * HJ86 求最大连续bit数
 *
 * 描述
 * 求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 本题含有多组样例输入。
 * 数据范围：数据组数：，
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一个int类型数字
 * <p>
 * 输出描述：
 * 输出转成二进制之后连续1的个数
 *
 * @ClassName: MaxBinary
 * @Author: JackOu
 * @CreateDate: 2021/12/5 10:25
 */
class QiuZuiDaLianXuBitShu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int key = in.nextInt();
            String s = Integer.toBinaryString(key);
            String[] split = s.split("0");
            int[] count = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                if (split[i].length() == 0) {  // 1之间有多个0的可能
                    continue;
                }
                int length = split[i].length();
                count[i] = length;
            }
            Arrays.sort(count);
            System.out.println(count[count.length - 1]);
        }
    }

}
