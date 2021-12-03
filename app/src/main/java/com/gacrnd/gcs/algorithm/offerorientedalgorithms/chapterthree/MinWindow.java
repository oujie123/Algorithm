package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterthree;

import java.util.HashMap;

/**
 * 含有所有字符的最短字符串
 * 输入两个字符串s和t，请找出s中包含t的所有字符的最短子字符串。例如输入s为字符串"ADDBANCAD"，
 * t为字符串"ABC"，则s中包含字符'A'、'B'、'C'的最短子字符串是"BANC"。如果不存在符合条件的子字符串，
 * 返回空字符串""。如果存在多个符合条件的子字符串，返回任意一个。
 *
 * @ClassName: MinWindow
 * @Author: JackOu
 * @CreateDate: 2021/12/3 14:04
 */
class MinWindow {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char ch : t.toCharArray()) {
            charToCount.put(ch, charToCount.getOrDefault(ch, 0) + 1);
        }

        int count = charToCount.size();
        int start = 0, end = 0, minStart = 0, minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        while (end < s.length() || (count == 0 && end == s.length())) {
            if (count > 0) {
                char endCh = s.charAt(end);
                if (charToCount.containsKey(endCh)) {
                    charToCount.put(endCh, charToCount.get(endCh) - 1);
                    if (charToCount.get(endCh) == 0) {
                        count--;
                    }
                }

                end++;
            } else {
                if (end - start < minLength) {
                    minLength = end - start;
                    minStart = start;
                    minEnd = end;
                }

                char startCh = s.charAt(start);
                if (charToCount.containsKey(startCh)) {
                    charToCount.put(startCh, charToCount.get(startCh) + 1);
                    if (charToCount.get(startCh) == 1) {
                        count++;
                    }
                }

                start++;
            }
        }

        return minLength < Integer.MAX_VALUE
                ? s.substring(minStart, minEnd)
                : "";
    }
}
