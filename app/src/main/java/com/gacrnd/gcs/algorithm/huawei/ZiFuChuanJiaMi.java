package com.gacrnd.gcs.algorithm.huawei;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

/**
 * HJ36 字符串加密
 *
 * 描述
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
 * 如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，并将新建立的字母表中未出现的字母按照正常字母表顺序加入新字母表。如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y (实际需建立小写字母的字母表，此字母表仅为方便演示）
 *
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一
 * 一取代原文的字母(字母字符的大小写状态应该保留)。因此，使用这个密匙， Attack AT DAWN (黎明时攻击)就会被加密为Tpptad TP ITVH。
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 *
 * 本题有多组输入数据。
 *
 * 数据范围：1 <= n <= 100 ，保证输入的字符串中仅包含小写字母
 *
 * 输入描述：
 * 先输入key和要加密的字符串
 *
 * 输出描述：
 * 返回加密后的字符串
 *
 * 输入：
 * nihao
 * ni
 * 输出：
 * le
 *
 * @ClassName: StringEncrypt
 * @Author: JackOu
 * @CreateDate: 2021/11/30 16:58
 */
class ZiFuChuanJiaMi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine();
            encrypt(s1, s2);
        }
    }

    private static void encrypt(String key, String str) {
        LinkedHashSet<Character> secSet = new LinkedHashSet<Character>();  // 保证顺序
        // 读入起始密码值
        for (int i = 0; i < key.length(); i++) {
            secSet.add(key.charAt(i));
        }

        // 加入剩下的密码值
        for (int i = 0; i < 26; i++) {
            secSet.add((char)('A' + i));
        }

        // 拼接加密后的密文
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>(secSet);
        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);
            if (tmp == ' ') {
                sb.append(tmp);
            } else if (!Character.isLetter(tmp)) {
                sb.append(list.get(tmp - 'A'));
            } else {
                int index = tmp - 'a';
                sb.append((char)(list.get(index) - 'A' + 'a'));
            }
        }

        System.out.println(sb.toString());
    }
}
