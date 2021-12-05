package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ97 记负均正
 * <p>
 * 描述
 * 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。
 * 0即不是正整数，也不是负数，不计入计算
 * <p>
 * 数据范围：  ，输入的整数都满足
 * 输入描述：
 * 本题有多组输入用例。
 * 首先输入一个正整数n，
 * 然后输入n个整数。
 * <p>
 * 输出描述：
 * 输出负数的个数，和所有正整数的平均值。
 *
 * @ClassName: CalNegtivePositive
 * @Author: JackOu
 * @CreateDate: 2021/12/5 11:07
 */
class JiFuJunZheng {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int cnt_in = Integer.parseInt(in.nextLine().trim());
            String[] in_str = in.nextLine().split("\\s+");
            int[] in_int = Arrays.stream(in_str).mapToInt(Integer::parseInt).toArray();

            solution(cnt_in, in_int);
        }
    }

    public static void solution(int n, int[] ints) {
        int cnt_ac = 0;//记录正数个数
        int cnt_ng = 0;//记录负数个数
        double avg = 0;//记录平均数
        double sum = 0;//记录正整数的和
        for (int i = 0; i < n; i++) {
            if (ints[i] > 0) {//正数
                cnt_ac++;
                sum += ints[i];
            }
            if (ints[i] < 0) {//负数
                cnt_ng++;
            }
        }
        avg = sum / cnt_ac;
        System.out.println(cnt_ng + " " + String.format("%.1f", avg));
    }
}
