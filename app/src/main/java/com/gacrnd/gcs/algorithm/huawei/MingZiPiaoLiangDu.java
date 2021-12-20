package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  HJ45 名字的漂亮度
 *描述
 * 给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 *
 * 本题含有多组数据。
 *
 * 数据范围：输入的名字长度满足
 *
 * 输入描述：
 * 整数N，后续N个名字
 *
 * 输出描述：
 * 每个名称可能的最大漂亮程度
 *
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/11/30 23:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/30 23:30
 * @UpdateRemark: 更新说明
 */
public class MingZiPiaoLiangDu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                String str = sc.next();
                int[] chars = new int[128];
                for (int j = 0; j < str.length(); j++) {
                    chars[str.charAt(j)]++;  // 计算字符串中字符个数
                }
                Arrays.sort(chars); // 排序之后计算最大漂亮值
                int score = 0;
                int maxScore = 26;
                for (int j = chars.length - 1; j >= 0 && chars[j] != 0; j--) {
                    score += maxScore * chars[j];
                    maxScore--;
                }
                System.out.println(score);
            }
        }
    }
}
