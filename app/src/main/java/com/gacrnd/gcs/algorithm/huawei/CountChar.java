package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * 描述
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 本题包含多组输入。
 * 数据范围：输入的字符串长度满足
 *
 * 输入描述：
 * 输入一行字符串，可以有空格
 *
 * 输出描述：
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 *
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出：
 * 26
 * 3
 * 10
 * 12
 *
 * @ClassName: CountChar
 * @Author: JackOu
 * @CreateDate: 2021/11/30 19:49
 */
class CountChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            count(str);
        }
    }

    private static void count(String str) {
        int space = 0;
        int letter = 0;
        int digit = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetter(c)) {
                letter++;
            } else if (Character.isDigit(c)) {
                digit++;
            } else if (c == ' ') {
                space++;
            } else {
                other++;
            }
        }
        System.out.println(letter);
        System.out.println(space);
        System.out.println(digit);
        System.out.println(other);
    }
}
