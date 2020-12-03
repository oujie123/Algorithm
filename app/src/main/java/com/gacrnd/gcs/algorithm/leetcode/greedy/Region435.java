package com.gacrnd.gcs.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 区间调度问题
 *
 * @author Jack_Ou  created on 2020/12/2.
 */
public class Region435 {

    /**
     * 求最多有几个不重叠区域
     *
     * @param intvs
     * @return
     */
    public static int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    /**
     * 需要移除多少个重叠的区域
     *
     * @param intervals
     * @return
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }


    /**
     * 主要考虑边界问题，求最多不重合问题
     *
     * @param intvs
     * @return
     */
    int findMinArrowShots(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按 end 升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            // 把 >= 改成 > 就行了
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2},{2,4},{1,3}};
        System.out.println(intervalSchedule(arr));
    }
}
