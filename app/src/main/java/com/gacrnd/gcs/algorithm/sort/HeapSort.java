package com.gacrnd.gcs.algorithm.sort;

/**
 * @author Jack_Ou  created on 2020/12/2.
 */
public class HeapSort {

    private static int len;

    public static int[] sort(int[] arr) {
        len = arr.length;
        if (len < 1) return arr;
        // 1.构建一个最大堆
        buildMaxHeap(arr);
        //2.循环将堆首位（最大值）与末位交换，然后在重新调整最大堆
        while (len > 0) {
            Utils.swap(arr, 0, len - 1);
            len--;
            adjustHeap(arr, 0);
        }
        return arr;
    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i);
        }
    }

    private static void adjustHeap(int[] arr, int i) {
        int maxIndex = i;
        // 获取基于i节点左子节点的下标
        int left = 2 * i + 1;
        int right = 2 * (i+1);
        // 如果有左子树，且左子树大于父节点，则将最大指针指向左子树
        if (left < len && arr[maxIndex] < arr[left]){
            maxIndex = left;
        }
        if (right < len && arr[maxIndex] < arr[right]) {
            maxIndex = right;
        }
        //如果父节点不是最大值，则将父节点与最大值交换，并且递归调整与父节点交换的位置。
        if (maxIndex != i) {
            Utils.swap(arr,maxIndex,i);
            // 基于maxIndex在调整，防止替换后的值不是最大的
            adjustHeap(arr,maxIndex);
        }
    }

    public static void main(String[] args) {
        Utils.printArray(sort(Utils.arr));
    }
}
