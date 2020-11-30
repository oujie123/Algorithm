package com.gacrnd.gcs.algorithm.Collection.tree;

import androidx.annotation.NonNull;

/**
 * @author Jack_Ou  created on 2020/11/30.
 */
public class AvlNode {
    //数据
    int data;
    //左子节点
    AvlNode leftChild;
    //右子节点
    AvlNode rightChild;
    // 记录该节点所在的高度
    int height;

    public AvlNode(int data) {
        this.data = data;
    }

    @NonNull
    @Override
    public String toString() {
        return "AvlNode [height=" + height + ",data=" + data + "]";
    }
}
