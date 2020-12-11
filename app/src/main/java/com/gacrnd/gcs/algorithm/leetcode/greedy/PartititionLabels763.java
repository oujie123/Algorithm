package com.gacrnd.gcs.algorithm.leetcode.greedy;

import com.gacrnd.gcs.algorithm.designpatterns.create.fatory.PeterClient;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * @author Jack_Ou  created on 2020/12/11.
 */
public class PartititionLabels763 {

    public static List<Integer> partitionLabels(String s) {
        //记录字符串中一个字符最后出现的位置
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partition = new ArrayList<>();
        int start = 0;
        int end = 0;
        // 计算一段多少个字母
        for (int i = 0; i < length; i++) {
            // 计算当前字母最后出现的位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // 如果当前遍历的字符是最后的字符，计算长度
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> integers = partitionLabels(s);
        System.out.println(integers.toString());
        int start = 0;
        int end = 0;
        for (int i = 0; i < integers.size(); i++) {
            end = start + integers.get(i);
            printArr(s, start, end);
            start += integers.get(i);
        }
    }

    private static void printArr(String str, int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
}
