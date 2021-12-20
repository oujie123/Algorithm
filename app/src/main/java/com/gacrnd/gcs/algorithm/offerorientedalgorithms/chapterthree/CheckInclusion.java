package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

/**
 * 变位词
 * 输入两个字符串s1和s2，如何判断s2中是否包含s1的某个变位词？如果s2中包含s1的某个变位词，
 * 则s1至少有一个变位词是s2的子字符串。假设两个输入字符串中只包含英语小写字母。
 * 例如输入字符串s1为"ab"，s2为"dgcaf"，由于s2中包含s1的变位词"ba"，因此输出是true。
 * 如果输入字符串s1为"ac"，s2为"dcgaf"，输出为false。
 *
 * @ClassName: CheckInclusion
 * @Author: JackOu
 * @CreateDate: 2021/12/3 11:53
 */
class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() >= s1.length()) {
            int[] counts = new int[26];
            for (int i = 0; i < s1.length(); ++i) {
                counts[s1.charAt(i) - 'a']++;
                counts[s2.charAt(i) - 'a']--;
            }

            if (areAllZero(counts)) {
                return true;
            }

            for (int i = s1.length(); i < s2.length(); ++i) {
                counts[s2.charAt(i) - 'a']--;
                counts[s2.charAt(i - s1.length()) - 'a']++;
                if (areAllZero(counts)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
