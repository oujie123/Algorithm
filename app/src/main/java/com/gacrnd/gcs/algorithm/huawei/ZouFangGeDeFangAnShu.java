package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ91 走方格的方案数
 *
 * 描述
 * 请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，
 * 要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 注：沿棋盘格之间的边缘线行走
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：
 * 输入描述：
 * 每组样例输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 * <p>
 * 输出描述：
 * 每组样例输出一行结果
 *
 * @ClassName: Gride
 * @Author: JackOu
 * @CreateDate: 2021/12/5 10:51
 */
class ZouFangGeDeFangAnShu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(combination(n, n + m));
        }
        sc.close();
    }

    public static int combination(int n, int m) {//排列C(n,m)
        int above = factorial(m);
        int below = factorial(m - n) * factorial(n);
        return above / below;
    }

    public static int factorial(int n) {//阶乘
        if (n > 1) {
            return n * factorial(n - 1);
        }
        return n;
    }
}
