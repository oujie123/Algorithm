package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * 动态规划问题
 *
 * 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。请和“子序列”的概念分开！
 *
 * 本题含有多组输入数据！
 * 数据范围：字符串长度，
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入两个字符串
 *
 * 输出描述：
 * 返回重复出现的字符
 * 示例1
 * 输入：
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出：
 * jklmnop
 *
 * @ClassName: MaxSubString
 * @Author: JackOu
 * @CreateDate: 2021/12/4 17:53
 */
class MaxSubString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String str1 = in.nextLine();//min
            String str2 = in.nextLine();//max
            if(str1.length()>=str2.length()){
                String temp = str2;
                str2 = str1;
                str1 = temp;
            }
            int minLen = str1.length();
            int maxLen = str2.length();
            int[][] array = new int[minLen][maxLen];  //记录遍历到(i,j)坐标时，当前的子字符串长度

            int max = 0;   // 记录所有遍历中的最大子字符串
            int maxIndex = 0;  // 出现最大子字符串时，所在str1中的位置

            for(int i=0;i<minLen;i++){
                for(int j=0;j<maxLen;j++){
                    if(str1.charAt(i)==str2.charAt(j)){
                        if(i==0||j==0){
                            array[i][j] = 1;
                        } else {
                            array[i][j] = 1 + array[i-1][j-1];
                        }
                        if(array[i][j]>max){
                            max = array[i][j];
                            maxIndex = i;
                        }
                    } else {
                        array[i][j] = 0;
                    }
                }
            }
            System.out.println(str1.substring(maxIndex-max + 1,maxIndex + 1));
        }
    }
}
