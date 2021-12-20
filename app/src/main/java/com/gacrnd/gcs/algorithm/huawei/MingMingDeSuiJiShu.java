package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * HJ3 明明的随机数
 *
 * 描述
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
 * 他先用计算机生成了 N 个 1 到 1000 之间的随机整数（ N≤1000 ），
 * 对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 *
 * 当没有新的输入时，说明输入结束。
 *
 * 数据范围：  ，输入的数字大小满足
 * 输入描述：
 * 注意：输入可能有多组数据(用于不同的调查)。每组数据都包括多行，第一行先输入随机整数的个数 N ，接下来的 N 行再输入相应个数的整数。具体格式请看下面的"示例"。
 *
 * 输出描述：
 * 返回多行，处理后的结果
 *
 * @ClassName: MingMingDeSuiJiShu
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:35
 */
class MingMingDeSuiJiShu {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int count = in.nextInt();    //随机数总数
            int[] data = new int[count];
            for(int i=0; i < count; i++)    //读入生成的随机数
                data[i] = in.nextInt();

            Arrays.sort(data);    //使用库函数排序
            System.out.println(data[0]);    //打印排序后的第一个数（必不重复）
            for(int i=1; i < count; i++){    //打印其他数字，需与前面数字比较，不重复才能打印
                if(data[i] != data[i-1])
                    System.out.println(data[i]);
            }
        }
    }
}
