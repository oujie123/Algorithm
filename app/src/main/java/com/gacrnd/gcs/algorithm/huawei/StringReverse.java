package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ106 字符逆序
 *
 * 描述
 * 将一个字符串str的内容颠倒过来，并输出。
 *
 * 数据范围：
 * 输入描述：
 * 输入一个字符串，可以有空格
 *
 * 输出描述：
 * 输出逆序的字符串
 *
 * @ClassName: StringReverse
 * @Author: JackOu
 * @CreateDate: 2021/12/5 11:34
 */
class StringReverse {

    private static String reverse(String str) {
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = reverse(str);
            System.out.println(res);
        }
    }
}
