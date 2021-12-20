package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ76 尼科彻斯定理
 *
 * 描述
 * 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 *
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 *
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 本题含有多组输入数据。
 * 数据范围：数据组数：，
 * 进阶：时间复杂度：，空间复杂度：
 *
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 输出分解后的string
 *
 * 输入：
 * 6
 * 输出：
 * 31+33+35+37+39+41
 *
 * @ClassName: NikochusTheorem
 * @Author: JackOu
 * @CreateDate: 2021/12/5 9:41
 */
class NiKeQieSiDingLi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            long sum = (long)Math.pow(n,3);
            int a1 = (int)sum/n - (n - 1);
            StringBuilder sb = new StringBuilder(Integer.toString(a1));
            for(int i = 1; i < n; i++){
                a1 = a1 + 2;
                sb.append("+");
                sb.append(a1);
            }
            System.out.println(sb);
        }
    }
}