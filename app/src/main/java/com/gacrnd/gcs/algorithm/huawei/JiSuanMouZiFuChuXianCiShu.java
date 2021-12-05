package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ2 计算某字符出现次数
 * <p>
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * <p>
 * 数据范围：  ，输入的数据有可能包含大小写字母、数字和空格
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 * <p>
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * @ClassName: JiSuanMouZiFuChuXianCiShu
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:33
 */
class JiSuanMouZiFuChuXianCiShu {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input1 = s.nextLine();
        String input2 = s.nextLine();
        String split3 = input1.toUpperCase().replaceAll(input2.toUpperCase(), "");
        System.out.println(input1.length() - split3.length());
    }
}
