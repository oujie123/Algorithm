package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ62 查找输入整数二进制中1的个数
 *
 * 描述
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 *
 * 数据范围：
 * 输入描述：
 * 输入一个整数
 *
 * 输出描述：
 * 计算整数二进制中1的个数
 *
 * @ClassName: CountBinary
 * @Author: JackOu
 * @CreateDate: 2021/12/4 23:16
 */
class ChaZhaoShuRuZhengShuErJinZhi1GeShu {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            int in = input.nextInt();
            int count=0;
            while(in!=0){
                if(in%2==1) count++;
                in=in>>1;
            }
            System.out.println(count);
        }
    }
}
