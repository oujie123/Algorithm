package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

/**
 * 回文子字符串的个数
 * 给定一个字符串，请问字符串里有多少回文连续子字符串？例如，字符串里"abc"有3个回文字符串，
 * 分别为"a"、"b"、"c"；而字符串"aaa"里有6个回文子字符串，分别为"a"、"a"、"a"、"aa"、"aa"和"aaa"。
 *
 * @ClassName: CountPalindrome
 * @Author: JackOu
 * @CreateDate: 2021/12/3 14:56
 */
class CountPalindrome {

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i, i + 1);
        }

        return count;
    }

    private int countPalindrome(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length()
                && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }

        return count;
    }
}
