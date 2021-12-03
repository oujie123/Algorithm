package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

/**
 * 不含重复字符的最长子字符串
 * 输入一个字符串，求该字符串中不含重复字符的最长连续子字符串的长度。例如，输入字符串"babcca"，
 * 它最长的不含重复字符串的子字符串是"abc"，长度为3。
 *
 * @ClassName: LengthOfLongestSubstring
 * @Author: JackOu
 * @CreateDate: 2021/12/3 14:00
 */
class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[256];
        int longest = s.length() > 0 ? 1 : 0;
        for (int i = 0, j = -1; i < s.length(); ++i) {
            counts[s.charAt(i)]++;
            while (hasGreaterThan1(counts)) {
                ++j;
                counts[s.charAt(j)]--;
            }

            longest = Math.max(i - j, longest);
        }

        return longest;
    }

    private boolean hasGreaterThan1(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return true;
            }
        }

        return false;
    }
}
