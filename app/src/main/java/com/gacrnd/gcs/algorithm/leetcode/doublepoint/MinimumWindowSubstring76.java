package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

import java.util.Vector;

/**
 * @author Jack_Ou  created on 2021/1/5.
 */
public class MinimumWindowSubstring76 {

    public static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen == 0 || tLen == 0 || sLen < tLen) {
            return "";
        }

        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();

        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        // 记录目标字符串中字符出现的次数
        for (int i = 0; i < tLen; i++) {
            tFreq[charArrayT[i]]++;
        }

        int distance = 0;
        int minLen = sLen + 1;
        int begin = 0;

        int left = 0;
        int right = 0;
        // 滑动窗口左右边界 [left,right)
        while (right < sLen) {
            // 如果右边界的值在tFreq中没有，则继续匹配
            if (tFreq[charArrayS[right]] == 0) {
                right++;
                continue;
            }
            if (winFreq[charArrayS[right]] < tFreq[charArrayS[right]]) {
                distance++;
            }
            // 如果存在目标字符
            winFreq[charArrayS[right]]++;
            right++;

            while (distance == tLen) {
                if (right - left < minLen) {
                    minLen = right - left;
                    begin = left;
                }
                if (tFreq[charArrayS[left]] == 0) {
                    left++;
                    continue;
                }
                if (winFreq[charArrayS[left]] == tFreq[charArrayS[left]]) {
                    distance--;
                }
                // 如果存在目标字符
                winFreq[charArrayS[left]]--;
                left++;
            }
        }
        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    public static void main(String[] args) {

    }
}
