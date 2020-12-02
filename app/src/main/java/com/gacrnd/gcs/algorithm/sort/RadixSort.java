package com.gacrnd.gcs.algorithm.sort;

import java.util.ArrayList;

/**
 * 基数排序
 *
 * 基数排序，桶排序，计数排序都是基于非比较的排序算法
 *
 * @author Jack_Ou  created on 2020/12/2.
 */
public class RadixSort {

    public static int[] sort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int recycleCount = 0;
        while (max != 0) {
            recycleCount++;
            max /= 10;
        }
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        int div = 1;
        for (int i = 0; i < recycleCount; i++) {
            // 将数组的数字放入对应的桶中
            for (int j = 0; j < arr.length; j++) {
                bucketArr.get(arr[j] / div % 10).add(arr[j]);
            }
            // 取出桶中的数放回数组
            int index=0;
            for (int j = 0; j < bucketArr.size(); j++) {
                for (int k = 0; k < bucketArr.get(j).size(); k++) {
                    arr[index++] = bucketArr.get(j).get(k);
                }
                bucketArr.get(j).clear();
            }
            div *= 10;
        }
        return arr;
    }

    public static void main(String[] args) {
        Utils.printArray(sort(Utils.SRC));
    }
}
