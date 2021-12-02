package com.gacrnd.gcs.algorithm.huawei;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 描述
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：输入的数据满足
 * 输入描述：
 * 输入一个偶数
 * <p>
 * 输出描述：
 * 输出两个素数
 * <p>
 * 输入：
 * 20
 * 输出：
 * 7
 * 13
 *
 * @ClassName: FindPrimeNumber
 * @Author: JackOu
 * @CreateDate: 2021/12/2 19:59
 */
class FindPrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            List<Integer> primes = getPrime(num);
            Map<Integer, Integer> map = new HashMap<>();
            // 找到和为num的键值对
            for (int i = 0; i < primes.size(); i++) {
                for (int j = i; j < primes.size(); j++) {
                    if (num == (primes.get(i) + primes.get(j))) {
                        map.put(primes.get(i), primes.get(j));
                    }
                }
            }
            System.out.println(primes);
            // 求出最小的差值
            int k = 0, v = 0, min = Integer.MAX_VALUE;
            for (int key : map.keySet()) {
                int tmp = Math.abs((int)map.get(key) - key);
                if (tmp <= min) {
                    k = key;
                    v = (int)map.get(key);
                    min = tmp;
                }
            }
            System.out.println(k);
            System.out.println(v);
        }
    }

    private static List<Integer> getPrime(int num) {
        List<Integer> list = new ArrayList<>();
        boolean flag;
        for (int i = 2; i < num; i++) {
            flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }
}
