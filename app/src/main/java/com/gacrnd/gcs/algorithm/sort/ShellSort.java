package com.gacrnd.gcs.algorithm.sort;

/**
 * 希尔排序：优化了插入排序（缩小增量排序）
 *
 * @Author: Jack Ou
 * @CreateDate: 2020/12/1 21:06
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/12/1 21:06
 * @UpdateRemark: 更新说明
 */
public class ShellSort {

    public static int[] shellSort1(int[] arr) {
        if (arr.length == 0) return arr;
        int gap = arr.length / 2;
        while (gap > 0) {
            // 对分组的数组进行插入排序
            for (int i = 0; i < arr.length - gap; i++) {
                int preIndex = i;
                int tmp = arr[preIndex + gap];
                while (preIndex >= 0 && arr[preIndex] > tmp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = tmp;
            }
            gap /= 2;
        }
        return arr;
    }

    public static int[] shellSort2(int[] arr) {
        if (arr.length == 0) return arr;
        int gap = arr.length / 2;
        while (gap > 0) {
            // 默认第一个是有序的
            for (int i = gap; i < arr.length; i++) {
                int preIndex = i -gap;
                int current = arr[i];
                while (gap >=0 && arr[preIndex] > current) {
                    arr[i] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap /= 2;
        }

        return arr;
    }

    public static void main(String[] args) {
        Utils.printArray(shellSort1(Utils.arr));
        Utils.printArray(shellSort2(Utils.arr));
    }
}
