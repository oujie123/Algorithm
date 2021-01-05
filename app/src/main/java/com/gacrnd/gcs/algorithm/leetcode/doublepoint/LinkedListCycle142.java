package com.gacrnd.gcs.algorithm.leetcode.doublepoint;

import com.gacrnd.gcs.algorithm.leetcode.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jack_Ou  created on 2021/1/5.
 */
public class LinkedListCycle142 {

    /**
     * 哈希数组方法
     * 时间和空间复杂度都是O(N)
     *
     * @param head
     * @return
     */
    public static ListNode detectCycleI(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    /**
     * fast 指针已经走完了环的n圈
     * 快慢指针相遇时：fast走过的总长度：a+n(b+c)+b = a+(n+1)b+nc
     * 快慢指针相遇时：slow走过的总长度：2(a+b)
     * =》  a = c+(n−1)(b+c)
     *
     * 快慢指针方式：时间复杂度O(N)，空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public static ListNode detectCycleII(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode tail = new ListNode(-4);
        ListNode a3 = new ListNode(0, tail);
        ListNode a2 = new ListNode(2, a3);
        ListNode a1 = new ListNode(3, a2);
        tail.next = a2;
        ListNode result = detectCycleI(a1);
        while (result != null) {
            System.out.println("==" + result.val);
            result = result.next;
        }
    }
}
