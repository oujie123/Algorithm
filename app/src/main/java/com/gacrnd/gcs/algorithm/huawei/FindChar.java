package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * 描述
 * 找出字符串中第一个只出现一次的字符
 * 数据范围：输入的字符串长度满足
 * 输入描述：
 * 输入几个非空字符串
 *
 * 输出描述：
 * 输出第一个只出现一次的字符，如果不存在输出-1
 *
 * asdfasdfo
 * aabb
 *
 * @ClassName: FindChar
 * @Author: JackOu
 * @CreateDate: 2021/12/2 19:24
 */
class FindChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String c = findChar(str);
            System.out.println(c);
        }
    }

    private static String findChar(String str) {
        char[] chars = new char[128];
        for (int i = 0; i < str.length(); i++) {
            chars[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)] == 1) {
                return String.valueOf(str.charAt(i));
            }
        }
        return String.valueOf(-1);
    }
}
