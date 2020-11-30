package com.gacrnd.gcs.algorithm.sort;

/**
 * 选择排序算法
 *
 * @Author: Jack Ou
 * @CreateDate: 2020/11/30 23:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/30 23:06
 * @UpdateRemark: 更新说明
 */
public class SelectSort {

    public static int[] selectSort(int[] arr) {
        if (arr.length == 0) return arr;
        for (int i = 0;i<arr.length;i++){
            int minIndex = i;
            for (int j = i + 1;j < arr.length;j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = tmp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Utils.printArray(selectSort(Utils.arr));
    }
}
