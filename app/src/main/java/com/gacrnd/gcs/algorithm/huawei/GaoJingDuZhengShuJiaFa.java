package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * HJ57 高精度整数加法
 *
 * 描述
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：
 * 输入描述：
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * <p>
 * 输出描述：
 * 输出求和后的结果
 * <p>
 * 示例1
 * 输入：
 * 9876543210
 * 1234567890
 * 输出：
 * 11111111100
 *
 * @ClassName: HighPrecisionAdd
 * @Author: JackOu
 * @CreateDate: 2021/12/2 16:37
 */
class GaoJingDuZhengShuJiaFa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String ret = add(s1, s2);
            System.out.println(ret);
        }
    }

    private static String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (s1.length() < s2.length()) {
            String tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        for (int i = 0; i < s2.length(); i++) {
            int n1 = s1.charAt(s1.length() - 1 - i) - '0';
            int n2 = s2.charAt(s2.length() - 1 - i) - '0';
            int sum = n1 + n2 + (flag ? 1 : 0);
            if (sum > 9) {
                flag = true;
                sb.append(sum % 10);
            } else {
                flag = false;
                sb.append(sum);
            }
        }
        int len = s1.length() - s2.length();
        if (len == 0) {
            if (flag) {
                sb.append(1);
            }
        } else {
            for (int i = len - 1; i >= 0 ; i--) {
                if (flag) {
                    int sum = s1.charAt(i) - '0' + 1;
                    if (sum > 9) {
                        flag = true;
                        sb.append(sum % 10);
                    } else {
                        flag = false;
                        sb.append(sum);
                    }
                } else {
                    sb.append(s1.charAt(i));
                }
            }
        }
        return sb.reverse().toString();
    }
}
