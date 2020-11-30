package com.gacrnd.gcs.algorithm.Collection.List;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 *
 * @author Jack_Ou  created on 2020/11/24.
 */
public class SwapNodesInPairs {

    private static ListNode head = null;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            addNode(i);
        }
        ListNode temp = swapPairsRecursion(head);
        show(temp);
    }

    public static ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        // 先处理后面的链子
        head.next = swapPairsRecursion(next.next);
        next.next = head;
        return next;
    }

    public static void addNode(int i) {
        ListNode newNode = new ListNode(i);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public static void show(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}
