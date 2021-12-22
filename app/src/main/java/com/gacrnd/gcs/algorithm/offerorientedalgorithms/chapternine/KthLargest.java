package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapternine;

import java.util.PriorityQueue;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/12/23 0:04
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/23 0:04
 * @UpdateRemark: 更新说明
 */
public class KthLargest {

    private PriorityQueue<Integer> minHeap;
    private int size;

    public KthLargest(int[] nums, int size) {
        this.size = size;
        minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    private int add(int num) {
        if (minHeap.size() < size) {
            minHeap.offer(num);
        } else if (num > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(num);
        }
        return minHeap.peek();
    }
}
