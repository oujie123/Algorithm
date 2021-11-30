package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 *  https://www.nowcoder.com/practice/02cb8d3597cf416d9f6ae1b9ddc4fde3?tpId=37&&tqId=21268&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/11/30 23:30
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/11/30 23:30
 * @UpdateRemark: 更新说明
 */
public class Beauty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                String str = sc.next();
                int[] chars = new int[128];
                for (int j = 0; j < str.length(); j++) {
                    chars[str.charAt(j)]++;  // 计算字符串中字符个数
                }
                Arrays.sort(chars); // 排序之后计算最大漂亮值
                int score = 0;
                int maxScore = 26;
                for (int j = chars.length - 1; j >= 0 && chars[j] != 0; j--) {
                    score += maxScore * chars[j];
                    maxScore--;
                }
                System.out.println(score);
            }
        }
    }
}
