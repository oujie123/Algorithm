package com.gacrnd.gcs.algorithm.leetcode.binary;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/1/5 23:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/1/5 23:12
 * @UpdateRemark: 更新说明
 */
public class Sqrt69 {
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1;
        int r = x;
        int mid, result;

        while (l <= r) {
            mid = (l + r) / 2;
            result = x / mid;
            if (result == mid) {
                return mid;
            } else if (result < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

//    public int mySqrt(int a) {
//        if (a == 0) return a;
//        int l = 1, r = a, mid, sqrt;
//        while (l <= r) {
//            mid = l + (r - l) / 2;
//            sqrt = a / mid;
//            if (sqrt == mid) {
//                return mid;
//            } else if (mid > sqrt) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return r;
//    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
