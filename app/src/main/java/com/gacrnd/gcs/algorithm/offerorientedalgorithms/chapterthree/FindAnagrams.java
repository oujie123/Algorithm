package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串中的所有变位词
 * 输入两个字符串s1和s2，如何找出s2的所有变位词在s1中的起始下标？假设两个输入字符串中只包含英语小写字母。
 * 例如输入字符串s1为"cbadabacg"，s2为"abc"，s2有两个变位词"cba"和"bac"是s1中的字符串，输出它们在s1中的起始下标0和5。
 *
 * @ClassName: FindAnagrams
 * @Author: JackOu
 * @CreateDate: 2021/12/3 13:52
 */
class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbadabacg", "abc"));
    }

    public static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> indices = new LinkedList<>();
        if (s1.length() >= s2.length()) {
            int[] counts = new int[26];
            for (int i = 0; i < s2.length(); ++i) {
                counts[s2.charAt(i) - 'a']++;
                counts[s1.charAt(i) - 'a']--;
            }

            if (areAllZero(counts)) {
                indices.add(0);
            }

            for (int i = s2.length(); i < s1.length(); ++i) {
                counts[s1.charAt(i) - 'a']--;
                counts[s1.charAt(i - s2.length()) - 'a']++;
                if (areAllZero(counts)) {
                    indices.add(i - s2.length() + 1);
                }
            }
        }

        return indices;
    }

    private static boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
