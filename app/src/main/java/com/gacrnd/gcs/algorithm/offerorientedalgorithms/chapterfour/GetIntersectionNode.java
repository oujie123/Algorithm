package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 两个链表的第一个重合结点
 * 输入两个单向链表，请问如何找出它们的第一个重合结点。例如图4.5中的两个链表的第一个重合的结点的值是4。
 *
 * 1 -> 2 -> 3 ----
 *                  4 -> 5 -> 6
 *      7 ->8  ----
 * 图4.5：两个部分重合的链表，它们的第一个重合的结点的值是4。
 *
 * @ClassName: GetIntersectionNode
 * @Author: JackOu
 * @CreateDate: 2021/12/3 15:41
 */
class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1 = countList(headA);
        int count2 = countList(headB);
        int delta = Math.abs(count1 - count2);    // 计算出长度差值
        ListNode longer = count1 > count2 ? headA : headB;
        ListNode shorter = count1 > count2 ? headB : headA;
        ListNode node1 = longer;
        for (int i = 0; i < delta; ++i) {
            node1 = node1.next;
        }

        ListNode node2 = shorter;
        while (node1 != node2) {
            node2 = node2.next;
            node1 = node1.next;
        }

        return node1;
    }

    private int countList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }

}
