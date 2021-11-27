package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterone;

/**
 * 二进制加法
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/9/6 23:56
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/9/6 23:56
 * @UpdateRemark: 更新说明
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11","101"));
    }

    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0; // 表示是否进一位，结果中的高位
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }

        if (carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}
