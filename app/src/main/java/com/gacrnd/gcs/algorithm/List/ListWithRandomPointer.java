package com.gacrnd.gcs.algorithm.List;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 *
 * @author Jack_Ou  created on 2020/11/24.
 */
public class ListWithRandomPointer {

    private static HashMap<Node,Node> hasVisited = new HashMap<>();

    public static void main(String[] args) {

    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 如果之前访问过这个节点，就直接返回
        if (hasVisited.containsKey(head)){
            return hasVisited.get(head);
        }

        // 如果没有访问过这个节点，就新建一个，并且放入到hashmap中
        Node newNode = new Node(head.val);
        // 先加入到hashmap中，防止递归调用由于random再次指向同一个节点造成死循环
        hasVisited.put(head,newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
