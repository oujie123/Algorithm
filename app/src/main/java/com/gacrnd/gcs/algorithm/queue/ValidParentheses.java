package com.gacrnd.gcs.algorithm.queue;

import java.util.HashMap;

/**
 * 有效的括号
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author Jack_Ou  created on 2020/11/24.
 */
public class ValidParentheses {

    // 创建有效校验的数据
    private static HashMap<Character, Character> chars = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    public static void main(String[] args) {
        System.out.println(isValid( "{[]}"));
    }

    public static boolean isValid(String s) {
        if (s.length() > 0 && !chars.containsKey(s.charAt(0))) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (chars.containsKey(c)) {
                stack.push(c);
            } else {
                if (chars.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.size == 1;
    }
}
