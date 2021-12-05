package com.gacrnd.gcs.algorithm.huawei;

/**
 * HJ38 求小球落地5次后所经历的路程和第5次反弹的高度
 *
 * 描述
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 最后的误差判断是小数点6位
 * 数据范围：输入的小球初始高度满足 1<= n <= 1000 ，且保证是一个整数
 *
 * 输入描述：
 * 输入起始高度，int型
 *
 * 输出描述：
 * 分别输出第5次落地时，共经过多少米第5次反弹多高
 *
 * 示例1
 * 输入：
 * 1
 * 输出：
 * 2.875
 * 0.03125
 *
 * @ClassName: BallLanding
 * @Author: JackOu
 * @CreateDate: 2021/11/30 19:24
 */
class XiaoQiuXiaLuo {

    public static void main(String[] args) {
        ballFalling(1);
    }

    private static void ballFalling(int n) {
        float ret = n;
        float tmp = n;
        // 第五次落地只反弹4次
        for (int i = 0; i < 4; i++) {
            tmp /= 2;
            ret += tmp * 2;
        }
        // 第五次落地还要算一次反弹高度
        tmp /= 2;
        System.out.println(ret);
        System.out.println(tmp);
    }
}
