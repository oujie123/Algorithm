package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * 描述
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 *
 * 数据范围：表达式计算结果和过程中满足  ，字符串长度满足
 *
 * 输入描述：
 * 输入一个算术表达式
 *
 * 输出描述：得到计算结果
 *
 * @ProjectName: Algorithm
 * @Package: com.gacrnd.gcs.algorithm.huawei
 * @ClassName: Calculate
 * @Description: java类作用描述
 * @Author: JackOu
 * @CreateDate: 2021/11/26 17:04
 */
class Calculate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String str = sc.nextLine();
            process(str);
        }
    }

    public static void process(String str) {
        String s1 = str.replace("[","(");
        String s2 = s1.replace("{","(");
        String s3 = s2.replace("]",")");
        String s4 = s3.replace("}",")");
        System.out.print(solve(s4));
    }

    // 返回子括号的结果
    public static int solve(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        char[] chs = s.toCharArray();
        int len = chs.length;
        int number = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = chs[i];
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '(') {
                int j = i + 1;
                int count = 1;
                while (count > 0) {
                    // 遍历后面的子数据
                    if (chs[j] == '(') count++;
                    if (chs[j] == ')') count--;
                    j++;
                }
                number = solve(s.substring(i + 1, j - 1));
                i = j - 1;
            }
            if (!Character.isDigit(c) || i == len - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-1 * number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                } else if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                number = 0;
                sign = c;
            }
        }

        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
