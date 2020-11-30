package com.gacrnd.gcs.algorithm.Collection.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 实现后缀表达式（逆波兰表达式，Reverse Polish notation，RPN）
 * <p>
 * 中缀表达式转后缀表达式主要用到了栈进行运算符处理，队列进行排序输出，规则为：
 * <p>
 * 1.数字直接入队列
 * 2.运算符要与栈顶元素比较
 *  ①栈为空直接入栈
 *  ②运算符优先级大于栈顶元素优先级则直接入栈
 *  ③小于或等于则出栈入列，再与栈顶元素进行比较，直到运算符优先级小于栈顶元素优先级后，操作符再入栈
 * 3.操作符是 ( 则无条件入栈
 * 4.操作符为 )，则依次出栈入列，直到匹配到第一个(为止，此操作符直接舍弃，(直接出栈舍弃
 *
 * 后缀表达式计算规则：
 * 后缀表达式3 4 + 5 × 6 -的计算
 * 1.从左至右扫描，将3和4压入堆栈；
 * 2.遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素，注意与前缀表达式做比较），计算出3+4的值，得7，再将7入栈；
 * 3.将5入栈；
 * 4.接下来是×运算符，因此弹出5和7，计算出7×5=35，将35入栈；
 * 5.将6入栈；
 * 6.最后是-运算符，计算出35-6的值，即29，由此得出最终结果。
 *
 * @author Jack_Ou  created on 2020/11/25.
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(transfer("9+(3-1)*3+10/2"));
        System.out.println(calcReversePolishNotion(transfer("9+(3-1)*3+8/2")));
        System.out.println(calcRevPolishNotation(transfer("9+(3-1)*3+8/2")));
    }

    public static int calcRevPolishNotation(String express){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <express.length() ;i++) {
            // 普通数值的处理
            if ((express.charAt(i) + "").matches("\\d")){
                stack.push(express.charAt(i) + "");
                // + - * / 运算符的处理
            }else if ((express.charAt(i) + "").matches("[\\+\\-\\*\\/]")){
                String k2 = stack.pop();
                String k1 = stack.pop();
                // 计算结果
                int res = calValue(Integer.valueOf(k1), Integer.valueOf(k2), (express.charAt(i) + ""));
                stack.push(res+"");
            }

        }
        return Integer.valueOf(stack.pop());
    }

    public static int calcReversePolishNotion(String rpn){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < rpn.length(); i++) {
            String temp = String.valueOf(rpn.charAt(i));
            if (temp.matches("\\d")){
                stack.push(temp);
            } else if (temp.matches("[\\-\\+\\*\\/]")) {
                int value2 = Integer.valueOf(stack.pop());
                int value1 = Integer.valueOf(stack.pop());
                int result = calValue(value1, value2,temp);
                stack.push(String.valueOf(result));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private static int calValue(int value1, int value2, String temp) {
        switch (temp){
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return value1 / value2;
                default:
                    throw new RuntimeException("没有支持的运算符！");
        }
    }


    public static String transfer(String origin) {
        // 用于保存操作符号
        Stack<String> stack = new Stack<>();
        // 用于保存操作数
        List<String> list = new ArrayList<>();

        for (int i = 0; i < origin.length(); i++) {
            String temp = String.valueOf(origin.charAt(i));
            if (temp.matches("\\d")) {
                list.add(temp);
            } else if (temp.matches("[\\+\\-\\*\\/]")) {
                // 如果栈是空直接入栈
                if (stack.empty()) {
                    stack.push(temp);
                    continue;
                }
                // 运算符优先级大于栈顶元素优先级则直接入栈
                // 此处要注意不和（进行对比，需要排除（
                if (!stack.peek().equals("(") && comparePriority(temp, stack.peek())) {
                    stack.push(temp);
                } else {
                    // 小于或等于则出栈入列，再与栈顶元素进行比较，直到运算符优先级小于栈顶元素优先级后，操作符再入栈
                    while (!stack.isEmpty() && !stack.peek().equals("(") && !comparePriority(temp, stack.peek())) {
                        list.add(stack.pop());
                    }
                    // 操作数再入栈
                    stack.push(temp);
                }
            } else if (temp.equals("(")) {
                stack.push(temp);
            } else if (temp.equals(")")) {
                // 操作符为 )，则依次出栈入列，直到匹配到第一个(为止，此操作符直接舍弃，(直接出栈舍弃)
                while (!("(").equals(stack.peek())) {
                    list.add(stack.pop());
                }
                // 移除"("
                stack.pop();
            }
        }

        // 将栈中括号下面的所有符号加入到队列中
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        // 输出转化后的结果
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static boolean comparePriority(String o1, String o2) {
        return getPriorityValue(o1) > getPriorityValue(o2);
    }

    // 获取符号优先级
    public static int getPriorityValue(String str) {
        switch (str) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            default:
                throw new RuntimeException("没有该类型运算符！");
        }
    }
}
