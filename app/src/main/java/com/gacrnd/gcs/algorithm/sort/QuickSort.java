package com.gacrnd.gcs.algorithm.sort;

/**
 * @author Jack_Ou  created on 2020/12/2.
 */
public class QuickSort {

    public static void sort(int[] arr, int start, int end) {
        if (start >= end)
            return;

        if (start < end) {
            // 记录比pivot小的坐标
            int i = start;
            // 记录比pivot大的坐标
            int j = end;
            int pivot = arr[start];
            int temp;
            while (i != j) {
                while (i<j && pivot <= arr[j]){
                    j--;
                }
                while (i<j && pivot >= arr[i]){
                    i++;
                }
                if (i<j){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            // 将pivot放入中间
            temp = arr[i];
            arr[i] = pivot;
            arr[start] = temp;

            // 递归处理子数组
            sort(arr,start,i-1);
            sort(arr,i+1,end);
        }
    }

    public static void main(String[] args) {
        sort(Utils.arr,0,Utils.arr.length -1);
        Utils.printArray(Utils.arr);
    }
}
