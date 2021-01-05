package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

/**
 * @author Jack_Ou  created on 2021/1/5.
 */
public class SumOfSquareNumbers633 {

    public static boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while (a <= b) {
            int result = a * a + b * b;
            if (result > c) {
                b--;
            } else if (result < c) {
                a++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(1000000));
    }
}
