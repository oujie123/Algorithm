package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ71 字符串通配符
 *
 * 描述
 * 问题描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 *
 * 注意：匹配时不区分大小写。
 *
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 *
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 注意：本题含有多组样例输入！
 *
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 *
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 *
 * @ClassName: GeneralMatch
 * @Author: JackOu
 * @CreateDate: 2021/12/4 21:33
 */
class ZiFuChuanTongPeiFu {

    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        while(in.hasNext()){
//            String s1 = in.nextLine();
//            String s2 = in.nextLine();
//            boolean flag = false;
//            StringBuilder sb = new StringBuilder();
//            // 减少表达式**个数，减少不必要的递归
//            for (int i = 0; i < s1.length(); i++) {
//                if (s1.charAt(i) == '*' && flag) {
//                    continue;
//                } else {
//                    if (s1.charAt(i) == '*') {
//                        flag = true;
//                    } else {
//                        flag = false;
//                    }
//                    sb.append(s1.charAt(i));
//                }
//            }
//            System.out.println(helper(s1, s2, 0, 0));
//        }
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String regx = sc.nextLine().toLowerCase();
            String target = sc.nextLine().toLowerCase();
            regx = regx.replaceAll("\\?","[0-9a-z]{1}");
            regx = regx.replaceAll("\\*+","[0-9a-z]{0,}");
            //regx =regx.replaceAll("\\.","\\\\.");
            System.out.println(regx);
            System.out.println(target.matches(regx));
        }
    }

    private static boolean helper(String s1, String s2, int p1, int p2){
        //base case
        if (p1 == s1.length() && p2 == s2.length()){
            return true;
        }else if (p1 == s1.length() || p2 == s2.length()){
            return false;
        }
        //遇到'*'两种情况，要不就各跳过一个比较后面，要不就s2继续往后跳先不比较
        if (s1.charAt(p1) == '*'){
            return helper(s1, s2, p1+1, p2+1) || helper(s1, s2, p1, p2+1) || helper(s1,s2,p1+1,p2);
            //遇到'?'跟两个一样操作一样，直接指针都往后移一个继续比较
        }else if (s1.charAt(p1) == '?' || s1.charAt(p1) == s2.charAt(p2)){
            return helper(s1, s2, p1+1, p2+1);
        }else {
            return false;
        }
    }
}
