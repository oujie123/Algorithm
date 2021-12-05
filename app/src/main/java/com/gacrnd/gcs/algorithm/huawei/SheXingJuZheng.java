package com.gacrnd.gcs.algorithm.huawei;

/**
 * HJ35 蛇形矩阵
 *
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 请注意本题含有多组样例输入。
 * <p>
 * 输入描述：
 * 输入正整数N（N不大于100）
 * <p>
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 * <p>
 * 示例1
 * 输入：
 * 4
 * 复制
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 * @ClassName: SnakeMatrix
 * @Author: JackOu
 * @CreateDate: 2021/11/30 14:00
 */
class SheXingJuZheng {

    public static void main(String[] args) {
        matrix(4);
    }

    public static void matrix(int num) {
        int y = 1;
        int colCount = 1;  // 列等差
        for (int i = 1; i <= num ; i++) {  // 行循环次数
            int x = y;
            int rowCount = i + 1; // 一行的等差值
            for (int j = 0; j <= num - i; j++) {
                System.out.print(x + " ");  // 先输出在计算下一个值
                x += rowCount++;
            }
            y += colCount++;  // 计算下一行的首元素
            System.out.println();
        }
    }
}
