package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 如何判断一个链表是不是回文？要求解法的时间复杂度是O(n)，另外不得使用超过O(1)的辅助空间。如果一个链表是回文，
 * 那么链表中结点序列从前往后看和从后往前看是相同的。例如，图4.13中的链表的结点序列从前往后看和从后往前看都是1、2、3、3、2、1，
 * 因此这是一个回文链表。
 *
 * @ClassName: IsPalindromeNodeList
 * @Author: JackOu
 * @CreateDate: 2021/12/3 16:39
 */
class IsPalindromeNodeList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = slow.next;
        if (fast.next != null) {
            secondHalf = slow.next.next;
        }

        slow.next = null;
        // return equals(secondHalf, reverseList(head));
        return true;  // 伪代码
    }

    public ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                reversedHead = cur;
            }

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return reversedHead;
    }
}
