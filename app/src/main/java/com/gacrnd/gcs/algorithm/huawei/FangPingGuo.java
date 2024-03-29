package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ61 放苹果
 *
 * 描述
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * <p>
 * 数据范围：0 <= m <= 10, 1 <= n <= 10;
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 输入描述：
 * 输入两个int整数
 * <p>
 * 输出描述：
 * 输出结果，int型
 * <p>
 * ========================================================================
 * <p>
 * 解题分析：
 * #  设f(m,n) 为m个苹果，n个盘子的放法数目，则先对n作讨论，
 * #  当n>m：必定有n-m个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响。即if(n>m) f(m,n) = f(m,m)
 * #  当n<=m：不同的放法可以分成两类：
 * #        1、有至少一个盘子空着，即相当于f(m,n) = f(m,n-1);
 * #        2、所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，不影响不同放法的数目，即f(m,n) = f(m-n,n).
 * #   而总的放苹果的放法数目等于两者的和，即 f(m,n) =f(m,n-1)+f(m-n,n)
 * #   递归出口条件说明：
 * #        当n=1时，所有苹果都必须放在一个盘子里，所以返回１；当没有苹果可放时，定义为１种放法；
 * #        递归的两条路，第一条n会逐渐减少，终会到达出口n==1;
 * #        第二条m会逐渐减少，因为n>m时，我们会return f(m,m)　所以终会到达出口m==0．
 *
 * @ProjectName: Algorithm
 * @Package: com.gacrnd.gcs.algorithm.huawei
 * @ClassName: PutAppple
 * @Description: java类作用描述
 * @Author: JackOu
 * @CreateDate: 2021/11/27 15:44
 */
class FangPingGuo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int apple = sc.nextInt();
            int plate = sc.nextInt();
            System.out.println(count(apple, plate));
        }
    }

    private static int count(int apple, int plate) {
        if (apple == 0 || plate == 1) return 1;
        if (plate > apple) {
            return count(apple, apple);  // 盘子数目大于苹果数目，多余的盘子可以不算
        } else {
            return count(apple, plate - 1) + count(apple - plate, plate);
        }
    }
}
