package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ100 等差数列
 * <p>
 * sn = n*a1 + d * (n*(n-1)/2)
 * <p>
 * 描述
 * 等差数列 2，5，8，11，14。。。。
 * （从 2 开始的 3 为公差的等差数列）
 * 输出求等差数列前n项和
 * <p>
 * 本题有多组输入
 * <p>
 * 数据范围：
 * 输入描述：
 * 输入一个正整数n。
 * <p>
 * 输出描述：
 * 输出一个相加后的整数。
 *
 * @ClassName: DengChaShuLie
 * @Author: JackOu
 * @CreateDate: 2021/12/5 11:29
 */
class DengChaShuLie {

    private static int sum(int n) {
        return (1 + 3 * n) * n / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int res = sum(n);
            System.out.println(res);
        }
    }
}
