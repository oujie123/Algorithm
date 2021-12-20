package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

/**
 * 有效的回文
 * 给定一个字符串，请判断它是不是一个回文字符串。我们只需要考虑字母或者数字字符，并忽略大小写。
 * 例如，"A man, a plan, a canal: Panama"是一个回文字符串，而"race a car"不是。
 *
 * @ClassName: IsPalindrome
 * @Author: JackOu
 * @CreateDate: 2021/12/3 14:08
 */
class IsPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if (!Character.isLetterOrDigit(ch1)) {
                i++;
            } else if (!Character.isLetterOrDigit(ch2)) {
                j--;
            } else {
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if (ch1 != ch2) {
                    return false;
                }

                i++;
                j--;
            }
        }

        return true;
    }
}
