package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 删除倒数第k个结点
 * 给你一个链表，请问如何删除链表中的倒数第k个结点？假设链表中结点的总数为n，那么1≤k≤n。要求只能遍历链表一次。
 * 例如输入图4.1中（a）的链表，删除倒数第2个结点之后的链表如图4.1中（b）所示。
 *
 * a: 1 -> 2 -> 3 -> 4 -> 5 -> 6
 * b: 1 -> 2 -> 3 -> 4 -> 6
 *
 * 图4.1：从链表中删除倒数第2个结点。（a）一个包含6个结点的链表。（b）删除倒数第2个结点（值为5的结点）之后的链表。
 *
 * @ClassName: RemoveNthFromEnd
 * @Author: JackOu
 * @CreateDate: 2021/12/3 14:59
 */
class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode front = head;
        ListNode back = dummy;
        for (int i = 0; i < n; i++) {
            front = front.next;    // 使用front来计算长度
        }

        while (front != null) {
            front = front.next;
            back = back.next;
        }

        back.next = back.next.next;
        return dummy.next;
    }
}
