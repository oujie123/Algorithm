package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ75 公共子串计算
 *
 * 描述
 * 给定两个只包含小写字母的字符串，计算两个字符串的最大公共子串的长度。
 * <p>
 * 注：子串的定义指一个字符串删掉其部分前缀和后缀（也可以不删）后形成的字符串。
 * 数据范围：字符串长度：
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入两个只包含小写字母的字符串
 * <p>
 * 输出描述：
 * 输出一个整数，代表最大公共子串的长度
 * <p>
 * 输入：
 * asdfas
 * werasdfaswer
 * 输出：
 * 6
 *
 * @ClassName: CommonSubString
 * @Author: JackOu
 * @CreateDate: 2021/12/5 9:32
 */
class GongGongZiChuan {

//    asdfas
//    werasdfaswer

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inLine1 = in.nextLine();
        String inLine2 = in.nextLine();
        String s1 = inLine1.length() < inLine2.length() ? inLine1 : inLine2;  // 短的字符串
        String s2 = inLine1.length() < inLine2.length() ? inLine2 : inLine1;  // 长的字符串
        int n = 0;
        for (int i = 0; i < s1.length(); i++) {              // 头指针从第一位开始递增
            for (int j = s1.length(); j > i; j--) {          // 尾指针从最后一位开始缩减
                if (s2.contains(s1.substring(i, j))) {  // 第一次发现合集的长度一定是最大的
                    n = Math.max(j - i,n); // 取每一次比较的最大值
                }
            }
        }
        System.out.println(n);
    }
}
