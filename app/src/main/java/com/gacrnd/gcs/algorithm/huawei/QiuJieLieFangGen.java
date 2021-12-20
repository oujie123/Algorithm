package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ107 求解立方根
 *
 * 计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 *
 * 数据范围：
 *
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 *
 * 输出描述：
 * 输入参数的立方根。保留一位小数。
 *
 * 解题思路： 1.判断正负。判断输入的数是正数还是符数，设置一个flag表示符号位，flag=0为正，flag=1为负。
 * 2.划分区间。把input的绝对值划分成小于1和大于1的两个区间，如果input小于1，设置二分的初始下界为0，上界为1.input大于1，则设置下届为0，上界为input。
 * 3.循环求解。设置一个误差d,使d=input/(target*target)-target.如果d绝对值在0到0.1之间，
 * 则说明已经找到这个input的立方根了。打印然后退出循环。如果d>0.1说明当前的target偏大，需要把上界调小；
 * 如果d<-0.1说明target偏小，需要把下界调大。
 *
 * @ClassName: Cube
 * @Author: JackOu
 * @CreateDate: 2021/12/4 23:07
 */
class QiuJieLieFangGen {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) { // 注意 while 处理多个 case
            double input = in.nextDouble();
            double low = 0,high = input;
            int flag =0;
            if(input<0){
                flag = 1;
                input = -input;
                if(input<1.0){
                    high =1;
                }
                else
                    high=input;
            }
            else if(input<1)  high =1;
            while(true){
                double target = low+(high - low)/2;
                double d = input/(target*target)-target;
                if(d>=-0.1&&d<=0.1){
                    if(flag ==1)
                        System.out.println("-"+String.format("%.1f", target));
                    else  System.out.println(String.format("%.1f", target));
                    break;
                }
                else if(d>0.1){
                    low = target;
                }
                else high = target;
            }
        }
    }
}
