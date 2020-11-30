package com.gacrnd.gcs.algorithm.base;

/**
 * 快速幂法
 *
 * @author Jack_Ou  created on 2020/11/28.
 */
public class QuickPow {

    public static void main(String[] args) {
//        System.out.println(poww(2, 14));

        System.out.println(myPow(2.100F,3));
    }

    /**
     * a ^ b
     *
     * @param a
     * @param b
     * @return
     */
    public static int poww(int a, int b) {
        int base = a;
        int ans = 1;
        while (b != 0) {
            // 如果最后一位是1
            if ((b & 1) == 1) {
                ans *= base;
            }
            base *= base;
            b >>= 1;
        }
        return ans;
    }

    public static double myPow(float a, int b) {
        double ans = 1;
        if (a == 0) return 0;
        if (b < 0) {
            a = 1 / a;
            b = -b;
        }
        while (b != 0) {
            if ((b & 1) == 1) {
                ans *= a;
            }
            a *= a;
            b >>= 1;
        }
        return ans;
    }
}
