package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * HJ101 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 *
 * 描述
 * 输入整型数组和排序标识，对其元素按照升序或降序进行排序
 * <p>
 * 数据范围：  ，元素大小满足
 * 输入描述：
 * 第一行输入数组元素个数
 * 第二行输入待排序的数组，每个数用空格隔开
 * 第三行输入一个整数0或1。0代表升序排序，1代表降序排序
 * <p>
 * 输出描述：
 * 输出排好序的数字
 *
 * @ClassName: Sort
 * @Description: java类作用描述
 * @Author: JackOu
 * @CreateDate: 2021/11/26 13:17
 */
class ShuRuZhengXingShuZuHePaiXuBiaoShi {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            Integer[] nums = new Integer[num];
            for (int i = 0; i < num; i++) {
                nums[i] = scanner.nextInt();
            }
            int flag = scanner.nextInt();
            sortByFlag(nums, flag);
            print(nums);
        }
    }

    private static void print(Integer[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void sortByFlag(Integer[] nums, int flag) {
        // 升序
        if (flag == 0) {
            Arrays.sort(nums, new Comparator<Integer>() {
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
        } else if (flag == 1) {
            Arrays.sort(nums, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }
    }
}
