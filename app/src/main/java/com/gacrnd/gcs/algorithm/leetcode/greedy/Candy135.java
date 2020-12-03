package com.gacrnd.gcs.algorithm.leetcode.greedy;

import java.sql.SQLOutput;
import java.util.SortedMap;
import java.util.Vector;

/**
 * 题目描述:
 * 一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，规则是如果一
 * 个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果；所
 * 有孩子至少要有一个糖果。求解最少需要多少个糖果。
 *
 * @author Jack_Ou  created on 2020/12/2.
 */
public class Candy135 {

    public static int candy(int[] score) {
        int size = score.length;
        if (size < 2) return size;

        int[] candyPerChild = new int[size];
        // 先给每个孩子一个糖果
        for (int i = 0; i < size; i++) {
            candyPerChild[i] = 1;
        }

        // 从左往右扫描
        for (int i = 0; i < size - 1; i++) {
            if (score[i + 1] > score[i]) {
                candyPerChild[i + 1] = candyPerChild[i] + 1;
            }
        }
        // 从右往左扫描
        for (int i = size - 1; i > 0; i--) {
            if (score[i -1] > score[i]){
                candyPerChild[i - 1] = candyPerChild[i] + 1;
            }
        }

        return sum(candyPerChild);
    }

    private static int sum(int[] candyPerChild) {
        int sum = 0;
        for (int i = 0; i < candyPerChild.length; i++) {
            sum += candyPerChild[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,0,2};
        System.out.println(candy(arr));
    }
}
