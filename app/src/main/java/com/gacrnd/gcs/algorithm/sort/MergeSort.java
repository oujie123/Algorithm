package com.gacrnd.gcs.algorithm.sort;

import java.util.Arrays;

/**
 * 1. 先分好组，sort返回分组的数组
 * 2.然后将分组的数据合并 ，merge传入待合并的数组，然后返回合并后的数组
 *
 * @Author: Jack Ou
 * @CreateDate: 2020/12/1 22:08
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/12/1 22:08
 * @UpdateRemark: 更新说明
 */
public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr.length < 2) return arr;
        int size = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr,0,size);
        int[] right = Arrays.copyOfRange(arr,size,arr.length);
        arr = merge(sort(left),sort(right));
        return arr;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < result.length;i++){
            if (leftIndex >= left.length){
                result[i] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                result[i] = left[leftIndex++];
            } else if (left[leftIndex] <= right[rightIndex]) {
                result[i] = left[leftIndex++];
            } else {
                result[i] = right[rightIndex++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Utils.printArray(sort(Utils.arr));
    }
}
