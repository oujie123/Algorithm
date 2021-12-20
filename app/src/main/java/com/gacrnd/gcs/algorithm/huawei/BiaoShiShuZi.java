package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ96 表示数字
 *
 * 将一个字符中所有的整数前后加上符号“*”，其他字符保持不变。连续的数字视为一个整数。
 *
 * 注意：本题有多组样例输入。
 *
 * 输入描述：
 * 输入一个字符串
 *
 * 输出描述：
 * 字符中所有出现的数字前后加上符号“*”，其他字符保持不变
 *
 * @ClassName: Number
 * @Author: JackOu
 * @CreateDate: 2021/12/4 22:51
 */
class BiaoShiShuZi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            System.out.println(input.replaceAll("([0-9]+)", "*$1*")); //把所有的数字段提取出来，前后加上星号再放回去
        }
    }
}
