package com.gacrnd.gcs.algorithm.leetcode.greedy;

/**
 * @author Jack_Ou  created on 2020/12/3.
 */
public class CanPlaceFlowers605 {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
            // 如果n == 0的情况直接返回true
            if (n <= 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[]{1, 0, 0, 0, 0, 1};
        System.out.println(canPlaceFlowers(flowerbed, 2));
    }
}
