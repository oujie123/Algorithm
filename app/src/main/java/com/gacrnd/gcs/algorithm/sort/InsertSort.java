package com.gacrnd.gcs.algorithm.sort;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/12/1 0:10
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/12/1 0:10
 * @UpdateRemark: 更新说明
 */
public class InsertSort {

    public static int[] insertSort(int[] arr) {
        if (arr.length == 0) return arr;
        // 默认第一个已经排序好了，所以循环length-1次
        for (int i = 0; i < arr.length - 1; i++) {
            // 记录已经排序好的下标
            int preIndex = i;
            int currentValue = arr[i + 1];
            while (preIndex >= 0 && currentValue < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = currentValue;
        }
        return arr;
    }

    public static void main(String[] args) {
        Utils.printArray(insertSort(Utils.arr));
    }
}
