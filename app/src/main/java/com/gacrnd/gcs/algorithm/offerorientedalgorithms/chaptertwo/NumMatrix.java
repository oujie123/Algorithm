package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chaptertwo;

/**
 * 输入一个二维矩阵，如何计算给定左上角坐标和右下角坐标的子矩阵数字之和？
 * 对同一个二维矩阵，计算子矩阵数字之和的函数可能输入不同的坐标而被反复调用多次。
 * 例如输入图2.1中的二维矩阵，以及左上角坐标为(2, 1)和右下角坐标为(4, 3)，该函数输出8。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/13 0:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/13 0:07
 * @UpdateRemark: 更新说明
 */
public class NumMatrix {

    private static int[][] sums;

    public static void main(String[] args) {

    }

    /**
     * construct sum matrix
     *
     * @param matrix
     */
    public static void numMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int[][] sums = new int[matrix.length + 1][matrix[0].length + 1]; // +1防止越界
        for (int i = 0; i < matrix.length; i++) {
            int sumRow = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sumRow += matrix[i][j];
                sums[i + 1][j + 1] = sums[i][j + 1] + sumRow;  // 上一行的和 加上本行大小
            }
        }
    }

    public static int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}
