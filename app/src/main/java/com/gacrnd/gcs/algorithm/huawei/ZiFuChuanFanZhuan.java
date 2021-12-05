package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ12 字符串反转
 *
 * 描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * <p>
 * 输入描述：
 * 输入一行，为一个只包含小写字母的字符串。
 * <p>
 * 输出描述：
 * 输出该字符串反转后的字符串。
 *
 * @ProjectName: Algorithm
 * @Package: com.gacrnd.gcs.algorithm.huawei
 * @ClassName: CharReverse
 * @Description: 字符串反转
 * @Author: JackOu
 * @CreateDate: 2021/11/26 14:19
 */
class ZiFuChuanFanZhuan {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String src = sc.nextLine();
        int len = src.length();
        if (len > 1000) return;
        StringBuilder sb = new StringBuilder(src);
        // 偷懒办法
//        sb.reverse();
//        System.out.println(sb.toString());

        // 正常思维办法
//        for (int i = len - 1; i >= 0; i--) {
//            sb.append(src.charAt(i));
//        }

        // 节约时间的办法
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = src.charAt(len - 1 - i);
            sb.setCharAt(len - 1 - i, src.charAt(i));
            sb.setCharAt(i, tmp);
        }
        System.out.println(sb.toString());
    }
}
