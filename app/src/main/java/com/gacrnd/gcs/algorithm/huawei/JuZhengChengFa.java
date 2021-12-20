package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ69 矩阵乘法
 *
 * 描述
 * 如果A是个x行y列的矩阵，B是个y行z列的矩阵，把A和B相乘，其结果将是另一个x行z列的矩阵C。这个矩阵的每个元素是由下面的公式决定的
 *
 * 矩阵的大小不超过100*100
 * 输入描述：
 * 输入包含多组数据，每组数据包含：
 * 第一行包含一个正整数x，代表第一个矩阵的行数
 * 第二行包含一个正整数y，代表第一个矩阵的列数和第二个矩阵的行数
 * 第三行包含一个正整数z，代表第二个矩阵的列数
 * 之后x行，每行y个整数，代表第一个矩阵的值
 * 之后y行，每行z个整数，代表第二个矩阵的值
 *
 * 输出描述：
 * 对于每组输入数据，输出x行，每行z个整数，代表两个矩阵相乘的结果
 *
 * @ClassName: MatrixMultiplication
 * @Author: JackOu
 * @CreateDate: 2021/12/4 19:17
 */
class JuZhengChengFa {

    public int[][] mul(int[][] mat1, int [][]mat2) {
        int x = mat1.length, y = mat2.length, z = mat2[0].length;
        int[][] res = new int[x][z];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < z; j++) {
                for (int k = 0; k < y; k++) {  // 每次循环要加y次，y必须在最里面
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        JuZhengChengFa solution = new JuZhengChengFa();
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int x = in.nextInt(), y = in.nextInt(), z = in.nextInt();
            int[][] mat1 = new int[x][y];
            int[][] mat2 = new int[y][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    mat1[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    mat2[i][j] = in.nextInt();
                }
            }
            int[][] res = solution.mul(mat1, mat2);
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
