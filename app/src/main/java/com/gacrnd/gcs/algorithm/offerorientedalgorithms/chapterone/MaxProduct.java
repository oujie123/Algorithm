package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterone;

/**
 * 输入一个字符串数组words，请计算当两个字符串words[i]和words[j]不包含
 * 相同字符时它们长度的乘积的最大值。如果没有不包含相同字符的一对字符串，
 * 那么返回0。假设字符串中只包含英语的小写字母。例如，输入的字符串数组
 * words为["abcw", "foo", "bar", "fxyz","abcdef"]，数组中的字符串"bar"与
 * "foo"没有相同的字符，它们长度的乘积为9。"abcw"与" fxyz "也没有相同的字符
 * ，它们长度的乘积是16，这是不含相同字符的一对字符串的长度乘积的最大值。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/8 7:49
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/8 7:49
 * @UpdateRemark: 更新说明
 */
public class MaxProduct {

    public static void main(String[] args) {
        String[] words = new String[]{"abcw","foo","bar","fxyz","abcdef"};
        System.out.println(maxProductTwo(words));
    }

    /**
     * 用哈希表记录字符串中出现的字符
     *
     * @param words
     * @return
     */
    public static int maxProductOne(String[] words) {

        boolean[][] flags = new boolean[words.length][26];

        // 记录每个单词出现了哪些字符
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i][c - 'a'] = true;
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int k = 0;
                // 判断26字母中是否有重合的，有就直接break,判断是否遍历完了26位
                for (; k < 26; k++) {
                    // 只能使用&&  使用==的话有同时为false的情况
                    if (flags[i][k] && flags[j][k]) {
                        break;
                    }
                }

                if (k == 26) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }

        return result;
    }

    /**
     * 用int记录单词字母所在位置
     *
     * @param words
     * @return
     */
    public static int maxProductTwo(String[] words) {
        int[] flags = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                flags[i] |= 1 << (c - 'a');
            }
        }

        int result = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((flags[i] & flags[j]) == 0) {
                    int prod = words[i].length() * words[j].length();
                    result = Math.max(result, prod);
                }
            }
        }
        return result;
    }
}
