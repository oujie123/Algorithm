package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ83 二维数组操作
 *
 * 描述
 * 有一个大小的数据表，你会依次进行以下5种操作：
 * 1.输入和，初始化大小的表格。
 * 2.输入x_1x
 * 3.输入，在第行上方添加一行。
 * 4.输入，在第列左边添加一列。
 * 5.输入、，查找坐标为的单元格的值。
 * 请编写程序，判断对表格的各种操作是否合法。
 * <p>
 * 详细要求:
 * <p>
 * 1.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误。
 * 2.对于插入操作，如果插入后行数或列数超过9了则应返回错误。如果插入成功了则将数据表恢复至初始化的大小，多出的数据则应舍弃。
 * 3.所有输入坐标操作，对大小的表格，行号坐标只允许0~m-1，列号坐标只允许0~n-1。超出范围应该返回错误。
 * <p>
 * 输入描述：
 * 输入数据按下列顺序输入：
 * 1 表格的行列值
 * 2 要交换的两个单元格的行列值
 * 3 输入要插入的行的数值
 * 4 输入要插入的列的数值
 * 5 输入要查询的单元格的坐标
 * <p>
 * 输出描述：
 * 输出按下列顺序输出：
 * 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 * 2 输出交换单元格是否成功
 * 3 输出插入行是否成功
 * 4 输出插入列是否成功
 * 5 输出查询单元格数据是否成功
 *
 * @ClassName: Matrix
 * @Author: JackOu
 * @CreateDate: 2021/12/5 10:01
 */
class ErWeiShuZuCaoZuo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r, c, r1, c1, r2, c2, ri, ci, rt, ct;
        while (sc.hasNext()) {
            r = sc.nextInt();
            c = sc.nextInt();
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            ri = sc.nextInt();
            ci = sc.nextInt();
            rt = sc.nextInt();
            ct = sc.nextInt();

            if (r <= 9 && c <= 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            if ((r1 < r && r2 < r) && (c1 < c && c2 < c)) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            //插入行和列的时候,要注意,只有在原来的行和列是小于9的情况下才能插入
            if (ri < r && r < 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            if (ci < c && c < 9) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }

            //无论怎么插入行和列, 表格永远是初始的规格大小
            if (rt < r && ct < c) {
                System.out.println(0);
            } else {
                System.out.println(-1);
            }
        }
    }
}
