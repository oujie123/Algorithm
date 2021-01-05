package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/1/5 22:42
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/5 22:42
 * @UpdateRemark: 更新说明
 */
public class LongestWordInDictionarythroughDeleting524 {

    public static boolean isSubString(String x, String y) {
        int index = 0;
        for (int i = 0; i < y.length() && index < x.length(); i++) {
            if (x.charAt(index) == y.charAt(i)) {
                index++;
            }
        }
        return index == x.length();
    }

    public static String findLongestWord(String s, List<String> d) {
        String maxStr = "";
        for (String word : d) {
            if (isSubString(word, s)) {
                if (word.length() > maxStr.length() || (word.length() == maxStr.length() && word.compareTo(maxStr) < 0)) {
                    maxStr = word;
                }
            }
        }
        return maxStr;
    }

    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        al.add("ale");
        al.add("apple");
        al.add("monkey");
        al.add("plea");
        System.out.println(findLongestWord("abpcplea", al));
    }
}
