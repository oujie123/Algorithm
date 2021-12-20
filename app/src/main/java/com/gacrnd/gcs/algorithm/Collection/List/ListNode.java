package com.gacrnd.gcs.algorithm.Collection.List;

/**
 * @author Jack_Ou  created on 2020/11/24.
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
