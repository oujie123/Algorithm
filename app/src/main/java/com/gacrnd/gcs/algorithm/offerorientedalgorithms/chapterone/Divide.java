package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterone;

/**
 * 输入两个int型整数，求它们除法的商，要求不得使用乘号'*'、除号'/'以及求余符号'%'。
 * 当发生溢出时返回最大的整数值。假设除数不为0。例如，输入15和2，输出15/2的结果，即7。
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/6 22:38
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/6 22:38
 * @UpdateRemark: 更新说明
 */
public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(100,2));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == 0x80000000 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int negative = 2;   // 记录最终输出的符号
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }

        int result = divideCore(dividend, divisor);
        return negative == 1 ? -result : result;
    }

    /**
     * dividend和divisor都被转化成负数处理，不会越界
     *
     * @param dividend 被除数
     * @param divisor  除数
     * @return 结果
     */
    private static int divideCore(int dividend, int divisor) {
        int result = 0;
        while (dividend <= divisor) {
            int quotient = 1;  //记录商
            int value = divisor;
            while (dividend >= 0xC0000000 && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }

            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
