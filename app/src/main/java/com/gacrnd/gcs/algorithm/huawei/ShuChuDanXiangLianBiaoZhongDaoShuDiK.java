package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * 描述
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * <p>
 * 链表结点定义如下：
 * <p>
 * struct ListNode
 * {
 * int       m_nKey;
 * ListNode* m_pNext;
 * };
 * 正常返回倒数第k个结点指针，异常返回空指针
 * <p>
 * 数据范围：链表长度满足  ，  ，链表中数据满足
 * <p>
 * 本题有多组样例输入。
 *
 * @ClassName: ShuChuDanXiangLianBiaoZhongDaoShuDiK
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:43
 */
class ShuChuDanXiangLianBiaoZhongDaoShuDiK {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int len = in.nextInt();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < len; ++i) {
                s.append(in.nextInt() + " ");
            }
            int k = in.nextInt();
            if (k < 1 || k > len) System.out.println(0);
            else {
                String str = s.toString();
                String[] ss = str.split(" ");
                int count = 0;
                for (int i = 0; i < ss.length; ++i) {
                    if (i >= k) {
                        ++count;
                    }
                }
                System.out.println(ss[count]);
            }
        }
    }
}
