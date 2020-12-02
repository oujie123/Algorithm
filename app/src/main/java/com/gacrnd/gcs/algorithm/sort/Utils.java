package com.gacrnd.gcs.algorithm.sort;

import java.util.ArrayList;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/11/30 23:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/30 23:00
 * @UpdateRemark: 更新说明
 */
public class Utils {

    public static final int[] arr = new int[]{5, 8, 6, 3, 9, 2, 1, 7, 4};
    public final static int[] SRC = {86,11,77,23,32,45,58,63,93,4,37,22};

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "->");
        }
        System.out.println();
    }

    public static void swap(int[] arr,int iIndex,int jIndex){
        int temp = arr[iIndex];
        arr[iIndex] = arr[jIndex];
        arr[jIndex] = temp;
    }

    public static void printObject(ArrayList<Integer> array){
        for(int i :array){
            System.out.print(i+"  ");
        }
        System.out.println("");
    }
}
