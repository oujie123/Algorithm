package com.gacrnd.gcs.algorithm.List;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * 21.合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author Jack_Ou  created on 2020/11/24.
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1,l2);
        show(listNode);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

    public static void show(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }
}

