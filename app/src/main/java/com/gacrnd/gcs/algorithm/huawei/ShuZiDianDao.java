package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ11 数字颠倒
 *
 * 描述
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 数据范围：
 * 输入描述：
 * 输入一个int整数
 *
 * 输出描述：
 * 将这个整数以字符串的形式逆序输出
 *
 * @ProjectName: Algorithm
 * @Package: com.gacrnd.gcs.algorithm.huawei
 * @ClassName: NumberReverse
 * @Description: 数字颠倒
 * @Author: JackOu
 * @CreateDate: 2021/11/26 13:47
 */
class ShuZiDianDao {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 0 || num > (2^30 - 1)) return;
        if (num == 0) {
            System.out.println("0");
            return;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num%10);
            num /= 10;
        }
        System.out.println(sb.toString());
    }
}
