package com.gacrnd.gcs.algorithm.huawei;

import java.util.LinkedList;
import java.util.Queue;
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

    private static class Point {
        int x;
        int y;
        Point father; // 保存上一个节点

        public Point(int i, int j, Point f) {
            this.x = i;
            this.y = j;
            this.father = f;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            row = sc.nextInt();
            col = sc.nextInt();
            int[][] maze = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    maze[i][j] = sc.nextInt();
                }
            }
            // 广度优先遍历路径
            Queue<Point> q = new LinkedList<Point>();
            q.offer(new Point(0, 0, null));
            maze[0][0] = 1; // 走过的路径标1，防止无限循环
            Point cur = null; // 记录当前所在的位置
            while(true) {
                cur = q.poll();
                int x = cur.x;
                int y = cur.y;
                // 如果遍历到最后一个节点就退出
                if (x == row - 1 && y == col -1) {
                    break;
                } else {
                    // 下
                    if (x + 1 < row && maze[x + 1][y] == 0) {
                        maze[x + 1][y] = 1;
                        q.offer(new Point(x + 1, y, cur));
                    }
                    // 右
                    if (y + 1 < col && maze[x][y+1] == 0) {
                        maze[x][y+1] = 1;
                        q.offer(new Point(x, y + 1, cur));
                    }
                    // 上
                    if (x - 1 >= 0 && maze[x - 1][y] == 0) {
                        maze[x - 1][y] = 1;
                        q.offer(new Point(x - 1, y, cur));
                    }
                    // 左
                    if (y - 1 >= 0 && maze[x][y - 1] == 0) {
                        maze[x][y - 1] = 1;
                        q.offer(new Point(x, y - 1, cur));
                    }
                }
            }
            // 找到路径了，father就是路径，但是此时的cur是在出口位置，路径输出需要回溯
            Stack<Point> stack = new Stack<Point>();
            while(cur != null) {
                stack.push(cur);
                cur = cur.father;
            }
            while(!stack.isEmpty()) {
                Point tmp = stack.pop();
                System.out.println(tmp.toString());
            }
        }
    }
}
