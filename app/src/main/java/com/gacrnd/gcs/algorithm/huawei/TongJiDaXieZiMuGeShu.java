package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ84 统计大写字母个数
 *
 * 描述
 * 找出给定字符串中大写字符(即'A'-'Z')的个数。
 * 数据范围：字符串长度：
 * 字符串中可能包含空格或其他字符
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 本题含有多组样例输入
 * 对于每组样例，输入一行，代表待统计的字符串
 * <p>
 * 输出描述：
 * 对于每组样例，输出一个整数，代表字符串中大写字母的个数
 * <p>
 * 输入：
 * add123#$%#%#O
 * 150175017(&^%&$vabovbao
 * A 1 0 11
 * 输出：
 * 1
 * 0
 * 1
 *
 * @ClassName: CountUpper
 * @Author: JackOu
 * @CreateDate: 2021/12/5 10:05
 */
class TongJiDaXieZiMuGeShu {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String s = input.nextLine();
            System.out.println(count(s));
        }
    }

    public static int count(String s) {
        int count = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c >= 'A' && c <= 'Z') {
                count++;
            }
        }
        return count;
    }
}
