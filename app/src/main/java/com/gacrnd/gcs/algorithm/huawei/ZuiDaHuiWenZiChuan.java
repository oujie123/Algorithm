package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ85 最长回文子串
 *
 * 描述
 * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
 * 所谓回文串，指左右对称的字符串。
 * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
 * 数据范围：字符串长度
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一个仅包含小写字母的字符串
 * <p>
 * 输出描述：
 * 返回最长回文子串的长度
 *
 * @ClassName: MaxPalindrome
 * @Author: JackOu
 * @CreateDate: 2021/12/5 10:21
 */
class ZuiDaHuiWenZiChuan {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int max = 0;
        /**
         *双指针遍历找到最长子串
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String toBeJuged = s.substring(i, j);
                if (isPalindromeString(toBeJuged)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        System.out.print(max);
    }

    /**
     * 判断一个字符串是否是回文字符串的方法
     */
    static boolean isPalindromeString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
