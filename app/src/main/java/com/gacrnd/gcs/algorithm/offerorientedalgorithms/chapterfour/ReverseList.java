package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 *
 * @ClassName: ReverseList
 * @Author: JackOu
 * @CreateDate: 2021/12/3 16:09
 */
class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;  // 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }
}
