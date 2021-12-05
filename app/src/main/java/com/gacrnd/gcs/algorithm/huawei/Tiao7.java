package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ55 挑7
 *
 * 描述
 * 输出小于等于 n 的与 7 有关数字的个数，包括 7 的倍数，还有包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）
 * 的个数（一组测试用例里可能有多组数据，请注意处理）
 *
 * 数据范围： 1<= n <= 30000
 *
 * 本题有多组输入
 * 输入描述：
 * 多组输入每组输入 1 个正整数 n 。( n 不大于 30000 )
 *
 * 输出描述：
 * 不大于n的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 *
 * 输入：
 * 20
 * 10
 * 输出：
 * 3
 * 1
 *
 * @ClassName: Select7
 * @Author: JackOu
 * @CreateDate: 2021/12/2 16:13
 */
class Tiao7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            int ret = count(num);
            System.out.println(ret);
        }
    }

    private static int count(int num) {
        int ret = 0;
        for (int i = 7; i <= num; i++) {
            if ( i % 7 == 0 || containSeven(i)) {
                ret++;
            }
        }
        return ret;
    }

    private static boolean containSeven(int num) {
        while (num != 0) {
            if (num % 10 == 7) return true;
            num /= 10;
        }
        return false;
    }
}
