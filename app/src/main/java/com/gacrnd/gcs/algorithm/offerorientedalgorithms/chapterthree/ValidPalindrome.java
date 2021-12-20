package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

/**
 * 最多删除一个字符得到回文
 * 给定一个字符串，请判断如果最多从字符串中删除一个字符能不能得到一个回文字符串。例如，如果输入字符串"abca"，
 * 由于删除字符'b'或者'c'就能得到一个回文字符串，因此输出为true。
 *
 * @ClassName: ValidPalindrome
 * @Author: JackOu
 * @CreateDate: 2021/12/3 14:51
 */
class ValidPalindrome {

    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        for (; start < s.length() / 2; ++start, --end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
        }

        return start == s.length() / 2
                || isPalindrome(s, start, end - 1)
                || isPalindrome(s, start + 1, end);
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }

            start++;
            end--;
        }

        return start >= end;
    }
}
