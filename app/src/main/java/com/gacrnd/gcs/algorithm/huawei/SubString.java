package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/11/30 23:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/30 23:51
 * @UpdateRemark: 更新说明
 */
public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int num = sc.nextInt();
            str = str.substring(0, num);
            System.out.println(str);
        }
    }
}
