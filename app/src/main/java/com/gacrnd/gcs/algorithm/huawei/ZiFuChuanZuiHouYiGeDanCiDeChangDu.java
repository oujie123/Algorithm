package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ1 字符串最后一个单词的长度
 * <p>
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * （注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * <p>
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @ClassName: ZiFuChuanZuiHouYiGeDanCiDeChangDu
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:31
 */
class ZiFuChuanZuiHouYiGeDanCiDeChangDu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" "); //正则表达式实用性更强( str.split("\\s+"))
        int length = s[s.length - 1].length();
        System.out.println(length);
    }
}
