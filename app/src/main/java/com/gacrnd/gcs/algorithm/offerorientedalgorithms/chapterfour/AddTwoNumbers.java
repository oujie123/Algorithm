package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 链表中的数字相加
 * 给你两个表示非负整数的单向链表，请问如何实现这两个整数的相加并且把和仍然用单向链表表示？
 * 链表中的每个结点表示整数十进制的一位，并且头结点对应整数的最高位数而尾结点对应整数的个位数。
 * 1 -> 2 -> 3
 * 5 -> 3 -> 1
 * 6 -> 5 -> 4
 * 例如在图4.10（a）和（b）中的两个链表分别表示整数123和531，它们的和为654，对应的链表尾图4.10的（c）所示。
 *
 * @ClassName: AddTwoNumbers
 * @Author: JackOu
 * @CreateDate: 2021/12/3 16:10
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode reversedHead = addReversed(head1, head2);
        return reverseList(reversedHead);
    }

    private ListNode addReversed(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode sumNode = dummy;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int sum = (head1 == null ? 0 : head1.val)
                    + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode newNode = new ListNode(sum);

            sumNode.next = newNode;
            sumNode = sumNode.next;

            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }

        if (carry > 0) {
            sumNode.next = new ListNode(carry);
        }

        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode reversedHead = null;
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null)
                reversedHead = cur;

            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return reversedHead;
    }
}
