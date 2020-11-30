package com.gacrnd.gcs.algorithm.Collection.List;

/**
 * @Author: Jack Ou
 * @CreateDate: 2020/11/24 23:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/11/24 23:15
 * @UpdateRemark: 更新说明
 */
public class Node {
    int val;
    Node next;
    Node random;

    Node(int value) {
        val = value;
        next = null;
        random = null;
    }
}
