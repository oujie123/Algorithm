package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

/**
 * 验证回文字符串 Ⅱ
 *
 * @author Jack_Ou  created on 2021/1/5.
 */
public class ValidPalindrome680 {

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 125题验证回文字符串
     */
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("eeccccbebaeeabebccceea"));
    }
}
