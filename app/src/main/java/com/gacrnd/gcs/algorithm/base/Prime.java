package com.gacrnd.gcs.algorithm.base;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * 判断是否是质数、质数筛选、质数因式分解、互质判断
 *
 * @author Jack_Ou  created on 2020/11/28.
 */
public class Prime {

    public static void main(String[] args) {
//        System.out.println(judgePrime(99));

//        Vector<Integer> Prims = getPrime(10);
//        for (int i = 0; i < Prims.size(); i++) {
//            System.out.println(Prims.get(i));
//        }

//        Map<Integer, Integer> result = getPrimePair(11);
//        System.out.println(result.size());
//        for (Map.Entry entry : result.entrySet()) {
//            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
//        }

        //System.out.println(gcd(9,100));

        System.out.println(mcm(6, 14));

        System.out.println(getPrime2(10));
    }

    public static List<Integer> getPrime2(int n) {
        List<Integer> list = new ArrayList<>();
        boolean flag;
        for (int i = 2; i < n; i++) {
            flag = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true; //如果有一个数除得断则这个数就不是质数
                    break;
                }
            }
            //所有的都除不断后就是质数 所以输出
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean judgePrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃氏筛 法
     *
     * @param n
     * @return
     */
    public static Vector<Integer> getPrime(int n) {
        Vector<Integer> primes = new Vector<>();
        Vector<Integer> vis = new Vector<>(n + 1);
        for (int i = 0; i < n + 1; i++) {
            vis.add(i, 0);
        }
        for (int i = 2; i <= n; i++) {
            if (vis.get(i) == 0) {
                primes.add(i);
                for (int j = i; j <= n; j += i) {
                    vis.set(j, 1);
                }
            }
        }
        return primes;
    }

    /**
     * 因式分解，分解后的值保存在hashmap中
     * <p>
     * N = pi^ci
     * hashmap中key保存pi，value保存ci
     *
     * @param n
     * @return
     */
    public static HashMap<Integer, Integer> getPrimePair(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                int num = 0;
                while (n % i == 0) {
                    num++;
                    n /= i;
                }
                hm.put(i, num);
            }
        }
        // 最后剩余不能分解的
        if (n > 1) {
            hm.put(n, 1);
        }
        return hm;
    }

    /**
     * 欧几里得算法
     * <p>
     * 求最大公约数：greatest common divisor
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 求最大公倍数：maximum common multiple
     */
    public static int mcm(int a, int b) {
        int i = Math.max(a, b);
        // 此处不用a * b -1,因为最后i会自加一次，意思是如果前面没有匹配到，最后一次就是最小公倍数
        for (; i < (a * b); i++) {
            if (i % a == 0 && i % b == 0) {
                break;
            }
        }
        return i;
    }

    /**
     * 水壶问题，本质是最大公约数问题（裴蜀定理）
     * <p>
     * 如果需要组成的水容量是最大公约数的倍数，肯定可以完成
     * <p>
     * 裴蜀定理：找到一对整数a,b,使得 ax + by = z，且 z <= x + y
     *
     * @param x 水壶1容量
     * @param y 水壶2容量
     * @param z 希望得到的容量
     * @return 是否能得到
     */
    public static boolean KettleProblem(int x, int y, int z) {
        // 求得最大公约数
        int g = gcd(x, y);
        if (z == 0 || (g != 0 && z % g == 0)) {
            if (z > x + y) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
