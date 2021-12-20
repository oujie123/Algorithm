package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ4 字符串分隔
 *
 * 描述
 * •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于等于100)
 *
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 *
 * @ClassName: ZiFuChuanFenGe
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:37
 */
class ZiFuChuanFenGe {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNextLine()){
            String s = input.nextLine();
            split(s);
        }
    }

    public static void split(String s){
        while(s.length()>=8){
            System.out.println(s.substring(0,8));
            s=s.substring(8);
        }
        if(s.length()<8 && s.length()>0){
            s+="00000000";
            System.out.println(s.substring(0,8));
        }
    }
}
