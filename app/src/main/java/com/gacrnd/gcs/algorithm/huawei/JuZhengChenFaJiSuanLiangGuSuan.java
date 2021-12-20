package com.gacrnd.gcs.algorithm.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Stack;

/**
 * HJ70 矩阵乘法计算量估算
 *
 * 描述
 * 矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：
 * <p>
 * A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * 计算A*B*C有两种顺序：（（AB）C）或者（A（BC）），前者需要计算15000次乘法，后者只需要3500次。
 * <p>
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * <p>
 * 输入描述：
 * 输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，最后输入要计算的法则
 * 计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，保证括号是匹配的且输入合法！
 * <p>
 * 输出描述：
 * 输出需要进行的乘法次数
 *
 * @ClassName: MatrixCal
 * @Author: JackOu
 * @CreateDate: 2021/12/4 19:52
 */
class JuZhengChenFaJiSuanLiangGuSuan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            List<Matrix> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int mcur = in.nextInt();
                int ncur = in.nextInt();
                list.add(new Matrix(mcur, ncur));
            }
            Stack<Matrix> stack = new Stack<>();
            int res = 0;
            String s = in.next();
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '(') {
                    res += helper(stack);
                } else if (s.charAt(i) == ')') {
                    stack.push(new Matrix(-1,-1));
                } else {
                    int cur = s.charAt(i) - 'A';
                    stack.push(list.get(cur));
                }
            }
            System.out.println(res);
        }
    }

    private static int helper(Stack<Matrix> stack) {
        Matrix m1 = stack.pop();
        Matrix m2 = stack.pop();
        stack.pop(); // 弹出")"创建的矩阵
        stack.push(m1.MatrixAfterMatrix(m2));
        return m1.mul(m2);
    }

    private static class Matrix {
        int m;
        int n;

        public Matrix(int m, int n) {
            this.m = m;
            this.n = n;
        }

        int mul(Matrix m2) {
            return this.m * this.n * m2.n;
        }

        Matrix MatrixAfterMatrix(Matrix m2) {
            return new Matrix(this.m, m2.n);
        }
    }
}
