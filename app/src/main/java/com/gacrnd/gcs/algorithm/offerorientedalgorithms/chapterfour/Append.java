package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.leetcode.bean.ListNode;

/**
 * 使用哨兵插入
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/12/22 23:31
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/22 23:31
 * @UpdateRemark: 更新说明
 */
public class Append {

    public ListNode append(ListNode head, int value) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode node = dummy;
        while (node.next != null) {
            node = node.next;
        }

        ListNode newNode = new ListNode(value);
        node.next = newNode;
        return dummy.next;
    }
}
