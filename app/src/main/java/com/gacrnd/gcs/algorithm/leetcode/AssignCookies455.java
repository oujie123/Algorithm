package com.gacrnd.gcs.algorithm.leetcode;

import com.gacrnd.gcs.algorithm.sort.QuickSort;
import com.gacrnd.gcs.algorithm.sort.Utils;

/**
 * 题目描述:
 * 有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃
 * 一个饼干，且只有饼干的大小不小于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩子
 * 可以吃饱。
 *
 * @author Jack_Ou  created on 2020/12/2.
 */
public class AssignCookies455 {

    public static int findContentChild(int[] children, int[] cookies) {
        QuickSort.sort(children, 0, children.length - 1);
        QuickSort.sort(cookies, 0, cookies.length - 1);
        int child = 0;
        int cookie = 0;
        while (child < children.length && cookie < cookies.length) {
            if (children[child] <= cookies[cookie]) child++;
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {
        int[] children = new int[]{1, 2};
        int[] cookies = new int[]{1, 2, 3};
        System.out.println(findContentChild(children, cookies));
    }
}
