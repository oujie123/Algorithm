package com.gacrnd.gcs.algorithm.leetcode.bean;

/**
 * @author Jack_Ou  created on 2021/1/5.
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
