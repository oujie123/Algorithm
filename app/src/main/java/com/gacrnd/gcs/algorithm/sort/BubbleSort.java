package com.gacrnd.gcs.algorithm.sort;

/**
 * 冒泡算法
 *
 * @Author: Jack Ou
 * @CreateDate: 2020/11/30 22:58
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/30 22:58
 * @UpdateRemark: 更新说明
 */
public class BubbleSort {

    public static int[] BubbleSort(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Utils.printArray(BubbleSort(Utils.arr));
    }
}
