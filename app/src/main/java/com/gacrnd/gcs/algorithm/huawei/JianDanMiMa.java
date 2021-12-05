package com.gacrnd.gcs.algorithm.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ21 简单密码
 *
 * 描述
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，
 * 怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
 * 就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，不就是 y 了嘛，
 * 简单吧。记住，Z 往后移是 a 哦。
 * <p>
 * 数据范围： 输入的字符串长度满足
 * <p>
 * 本题有多组样例输入
 * 输入描述：
 * 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
 * <p>
 * 输出描述：
 * 输出渊子真正的密文
 *
 * @ProjectName: Algorithm
 * @Package: com.gacrnd.gcs.algorithm.huawei
 * @ClassName: SimpleEncrypt
 * @Description: java类作用描述
 * @Author: JackOu
 * @CreateDate: 2021/11/30 10:06
 */
class JianDanMiMa {

    private static Map<Character, Integer> map = new HashMap<Character, Integer>() {{
        put('a', 2);
        put('b', 2);
        put('c', 2);
        put('d', 3);
        put('e', 3);
        put('f', 3);
        put('g', 4);
        put('h', 4);
        put('i', 4);
        put('j', 5);
        put('k', 5);
        put('l', 5);
        put('m', 6);
        put('n', 6);
        put('o', 6);
        put('p', 7);
        put('q', 7);
        put('r', 7);
        put('s', 7);
        put('t', 8);
        put('u', 8);
        put('v', 8);
        put('w', 9);
        put('x', 9);
        put('y', 9);
        put('z', 9);
    }};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String sec = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sec.length(); i++) {
                char c = sec.charAt(i);
                int index = c - '0';
                if (index >=0 && index <= 9) {
                    sb.append(c);
                } else if (index >= 17 && index <= 42) {
                    if (c == 'Z') {
                        sb.append('a');
                    } else {
                        sb.append(Character.valueOf((char)(c + 33)));
                    }
                } else {
                    sb.append(map.get(c));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
