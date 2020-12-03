package com.gacrnd.gcs.algorithm.search;

/**
 * 暴力破解
 *
 * @Author: Jack Ou
 * @CreateDate: 2020/12/3 23:33
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/12/3 23:33
 * @UpdateRemark: 更新说明
 */
public class BruteForce {

    public static boolean bruteForce(String src, String target) {
        int srcLen = src.length();
        int targetLen = target.length();
        if (targetLen > srcLen) {
            System.out.println("the length of source string is less than the target's length");
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < srcLen && j < targetLen) {
            if (src.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j >= targetLen) {
            int index = i - j;
            System.out.println("match success! index:" + index);
            return true;
        } else {
            System.out.println("match failed!");
            return false;
        }
    }

    public static void main(String[] args) {
        String src = "BBC ABCDAB ABCDDABCDABDE";
        String tar = "ABCDABD";
        System.out.println(bruteForce(src, tar));
    }
}
