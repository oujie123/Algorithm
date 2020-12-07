package com.gacrnd.gcs.algorithm.search;

import com.gacrnd.gcs.algorithm.sort.Utils;

import java.util.Arrays;

/**
 * 二分查找(折半查找)
 *
 * @author Jack_Ou  created on 2020/12/3.
 */
public class BinarySearch {

    /**
     * 返回查到元素的位置
     *
     * @param arr
     * @param value
     * @return
     */
    public static int BinarySearch(int[] arr,int value) {
        int start = 0;
        int end = arr.length -1;
        int mid ;
        while (start <= end) {
            mid = (start + end) / 2;
            if (value > arr[mid]) {
                start = mid+1;
            } else if (value < arr[mid]) {
                end = mid -1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Arrays.sort(Utils.arr);

        System.out.println(BinarySearch(Utils.arr,0));
    }
}
