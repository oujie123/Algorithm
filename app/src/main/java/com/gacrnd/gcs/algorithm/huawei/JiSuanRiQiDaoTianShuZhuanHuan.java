package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ73 计算日期到天数转换
 *
 * 描述
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 输入一行，每行空格分割，分别是年，月，日
 *
 * 输出描述：
 * 输出是这一年的第几天
 *
 * @ClassName: CountDay
 * @Author: JackOu
 * @CreateDate: 2021/12/5 9:15
 */
class JiSuanRiQiDaoTianShuZhuanHuan {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int[] month_day = {31,28,31,30,31,30,31,31,30,31,30,31};
            int sum = 0;
            for(int i = 0; i < month - 1; i++){
                sum += month_day[i];
            }
            sum += day;
            if(month > 2 && is_leap(year)){
                sum += 1;
            }
            System.out.println(sum);
        }
    }

    public static boolean is_leap(int n){
        if(n % 4 == 0 && n % 100 != 0 || n % 400 == 0){
            return true;
        }else{
            return false;
        }
    }
}
