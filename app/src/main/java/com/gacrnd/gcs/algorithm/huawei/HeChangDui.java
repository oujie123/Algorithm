package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ24 合唱队
 * <p>
 * 描述
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * <p>
 * 说明：
 * <p>
 * N 位同学站成一排，音乐老师要请其中的 (N - K) 位同学出列，使得剩下的 K 位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为 1，2…，K ，他们的身高分别为 T1，T2，…，TK ，   则他们的身高满足存在 i （1<=i<=K） 使得 T1<T2<......<Ti-1<Ti>Ti+1>......>TK 。
 * <p>
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * <p>
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * 请注意处理多组输入输出！
 * <p>
 * 数据范围：
 * <p>
 * 输入描述：
 * 有多组用例，每组都包含两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 * <p>
 * 输出描述：
 * 最少需要几位同学出列
 *
 * @ClassName: HeChangDui
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:39
 */
class HeChangDui {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            sc.nextLine();
            //zuo
            int[] dp1 = new int[n];
            for (int i = 0; i < n; i++) {
                dp1[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (a[j] < a[i]) {
                        dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                    }
                }
            }
            //you
            int[] dp2 = new int[n];
            for (int i = n - 1; i >= 0; i--) {
                dp2[i] = 1;
                for (int j = n - 1; j > i; j--) {
                    if (a[j] < a[i]) {
                        dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                    }
                }
            }
            int res = 1;
            for (int i = 0; i < n; i++) {
                a[i] = dp1[i] + dp2[i] - 1;
                if (a[i] > res) {
                    res = a[i];
                }
            }
            System.out.println(n - res);
        }
    }
}
