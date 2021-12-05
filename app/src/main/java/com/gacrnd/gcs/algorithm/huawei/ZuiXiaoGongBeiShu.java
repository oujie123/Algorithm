package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ108 求最小公倍数
 * <p>
 * 公式：a*b/gcd(a,b)
 * <p>
 * 描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 * <p>
 * 数据范围：
 * 输入描述：
 * 输入两个正整数A和B。
 * <p>
 * 输出描述：
 * 输出A和B的最小公倍数。
 *
 * @ClassName: ZuiXiaoGongBeiShu
 * @Author: JackOu
 * @CreateDate: 2021/12/5 11:37
 */
class ZuiXiaoGongBeiShu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(a * b / gcd(a, b));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
