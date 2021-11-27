package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * 描述
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 *
 * 数据范围：字符串长度满足
 * 输入描述：输入一行以空格来分隔的句子
 *
 * 输出描述：输出句子的逆序
 *
 * @ProjectName: Algorithm
 * @Package: com.gacrnd.gcs.algorithm.huawei
 * @ClassName: WordsReverse
 * @Description: java类作用描述
 * @Author: JackOu
 * @CreateDate: 2021/11/26 15:48
 */
class WordsReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();
            getReverseWords(tmp);
        }
    }

    private static void getReverseWords(String tmp) {
        String[] words = tmp.split("[^A-Za-z]");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
