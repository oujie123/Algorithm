package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 描述
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。
 * 入口点为[0,0],既第一格是可以走的路。
 * 本题含有多组数据。
 * <p>
 * 数据范围： 2 <= m,n <= 10 ， 输入的内容只包含 0<= val <= 1
 * <p>
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,
 * 不考虑有多解的情况，即迷宫只有一条通道。
 * <p>
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * <p>
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 1
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (3,0)
 * (4,0)
 * (4,1)
 * (4,2)
 * (4,3)
 * (4,4)
 *
 * @ClassName: Maze
 * @Author: JackOu
 * @CreateDate: 2021/11/30 20:01
 */
class Maze {

    private static int row;
    private static int col;
    private static int[][] maze = new int[row][col];

    private static class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "(" + i + "," + j + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            row = sc.nextInt();
            col = sc.nextInt();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[row][col] = sc.nextInt();
                }
            }
            Stack<Pair> paths = new Stack<Pair>();
            dfs(maze, row, col, paths);
            for (Pair p : paths) {
                System.out.println(p);
            }
        }
    }

    private static boolean dfs(int[][] maze, int row, int col, Stack<Pair> paths) {
        if (maze[row][col] != 0) return false;
        paths.push(new Pair(row, col));
        if (maze)
    }
}
