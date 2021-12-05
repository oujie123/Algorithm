package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ72 百钱买百鸡问题
 *
 * 描述
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 * 现要求你打印出所有花一百元买一百只鸡的方式。
 * 输入描述：
 * 输入任何一个整数，即可运行程序。
 *
 * 输出描述：
 *  输出有数行，每行三个整数，分别代表鸡翁，母鸡，鸡雏的数量
 *
 * @ClassName: BuyChicken
 * @Author: JackOu
 * @CreateDate: 2021/12/4 23:23
 */
class BaiQianBaiJi {

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            F(sc.nextInt());
        }
    }


    public static void F(int num) {

//        5x+3y+z/3=100;
//        x+y+z=100;
//        简化得 7x+4y=100;
        int x,y,z,middle;
        for(x = 0; x<=14;x++){
            if((100 - 7*x) % 4 == 0){
                y = (100 - 7*x) / 4;
                z = 100-x-y;
                System.out.print(x +" ");
                System.out.print(y +" ");
                System.out.print(z +" ");
                System.out.println();
            }
        }
    }
}
