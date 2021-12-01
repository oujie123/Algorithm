package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * 比如1 2 3 4 5 6 7 8 9 0 3，输入从第K（>=1)个数开始，共输出后面的n个数。输出的数用分号隔开。
 * 每行只能输出20个数，每行的结尾不是’；‘就直接回车就好。若是超过数据量的大小了，k+n-1>实际数据量下标，就按照实际数据量输出即可
 * <p>
 * 比如：1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
 * <p>
 * 2 25
 * <p>
 * 输出： 2；3；4；5；6；7；8；9；0；1；2；3；4；5；6；7；8；9；0；1
 *         2；3；4
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/12/1 21:20
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/1 21:20
 * @UpdateRemark: 更新说明
 */
public class SubString2 {

    public static void main(String[] args) {
        String str = "1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 1 2 3 4";
        String[] strs = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        String tmp = sb.toString();
        String subStr = tmp.substring(1, tmp.length() >= 25 ? 25 : tmp.length());
        System.out.println(subStr);
        if (subStr.length() > 20) {
            int index = subStr.length() / 20;
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < 20; j++) {
                    char c = subStr.charAt(j + i * 20);
                    if (j != 19) {
                        System.out.print(c + ";");
                    } else {
                        System.out.print(c);
                    }
                }
                System.out.println();
            }
            // 输出剩下的
            int rest = subStr.length() % 20;
            for (int i = 0; i < rest; i++) {
                char c = subStr.charAt(i + index * 20);
                if (i != rest - 1) {
                    System.out.print(c + ";");
                } else {
                    System.out.print(c);
                }
            }
        } else {
            // 输出剩下的
            int rest = subStr.length();
            for (int i = 0; i < rest; i++) {
                char c = subStr.charAt(i);
                if (i != rest - 1) {
                    System.out.print(c + ";");
                } else {
                    System.out.print(c);
                }
            }
        }
    }
}
