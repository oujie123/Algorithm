package com.gacrnd.gcs.algorithm.offerorientedalgorithms.chapterfour;

import com.gacrnd.gcs.algorithm.Collection.List.ListNode;

/**
 * 给你一个链表，链表中结点的顺序是L0→ L1→ L2→…→ Ln-1→ Ln，请问如何重排链表使得结点的顺序变成L0→ Ln→ L1→ Ln-1→ L2→ Ln-2→…？例如输入图4.12（a）中的链表，重排之后的链表如图4.12（b）所示。
 *
 * 图4.12：重排链表。（a）一个含有6个结点的链表。（b）重排之后的链表。
 *
 * @ClassName: ReorderList
 * @Author: JackOu
 * @CreateDate: 2021/12/3 16:37
 */
class ReorderList {

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            }
        }

        ListNode temp = slow.next;
        slow.next = null;
        link(head, reverseList(temp), dummy);
    }

    private void link(ListNode node1, ListNode node2, ListNode head) {
        ListNode prev = head;
        while (node1 != null && node2 != null) {
            ListNode temp = node1.next;

            prev.next = node1;
            node1.next = node2;
            prev = node2;

            node1 = temp;
            node2 = node2.next;
        }

        if (node1 != null) {
            prev.next = node1;
        }
    }

    private ListNode reverseList(ListNode first) {
        ListNode prev = null;
        ListNode cur = first;
        ListNode head = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            if (next == null) {
                head = cur;
            }

            prev = cur;
            cur = next;
        }

        return head;
    }
}
