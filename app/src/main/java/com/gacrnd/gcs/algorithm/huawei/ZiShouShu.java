package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ99 自守数
 *
 * 描述
 * 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n(包括n)以内的自守数的个数
 *
 * 本题有多组输入数据
 *
 * 数据范围：
 *
 *
 * 输入描述：
 * int型整数
 *
 * 输出描述：
 * n以内自守数的数量。
 *
 * @ClassName: AutomorphicNumbers
 * @Author: JackOu
 * @CreateDate: 2021/12/4 22:55
 */
class ZiShouShu {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int count = 0;
            for(int i=0;i<=n;i++){
                int sum =i*i;
                String s1 = String.valueOf(i);
                String s2 = String.valueOf(sum);
                //从平方的尾部往前截取到与当前数长度相同的子串
                if(s2.substring(s2.length()-s1.length()).equals(s1)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
