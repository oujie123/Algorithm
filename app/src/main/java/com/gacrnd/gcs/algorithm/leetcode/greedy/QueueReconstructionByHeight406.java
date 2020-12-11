package com.gacrnd.gcs.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.xml.transform.Source;

/**
 * 解题思路：先排序再插入
 * 1.排序规则：按照先H高度降序，K个数升序排序
 * 2.遍历排序后的数组，根据K插入到K的位置上
 * <p>
 * 核心思想：高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
 *
 * @author Jack_Ou  created on 2020/12/11.
 */
public class QueueReconstructionByHeight406 {

    public static int[][] reconstructQueue(int[][] people) {
        // 排序好的数组
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        //插入
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] people = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue(people);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i][0] + "=" + ints[i][1]);
        }
    }
}
