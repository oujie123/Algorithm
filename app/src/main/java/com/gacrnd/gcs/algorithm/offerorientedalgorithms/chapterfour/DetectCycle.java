package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 链表中环的入口结点
 * 一个链表中包含环，如何找出环的入口结点？从链表的头结点开始沿着next指针进入环的第一个结点为环的入口结点。
 *  1 -> 2 -> 3 -> 4 -> 5 -> 6
 *            |______________|
 * 例如，在图4.3的链表中，环的入口结点是结点3。
 *
 * @ClassName: DetectCycle
 * @Author: JackOu
 * @CreateDate: 2021/12/3 15:22
 */
class DetectCycle {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(getNodeInLoop(node1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode inLoop = getNodeInLoop(head);
        if (inLoop == null) {
            return null;
        }

        ListNode node = head;
        while (node != inLoop) {
            node = node.next;
            inLoop = inLoop.next;
        }

        return node;
    }

    private static ListNode getNodeInLoop(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head.next;
        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if (slow == fast)
                return slow;

            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }

        return null;
    }
}
