package com.gacrnd.gcs.algorithm.Collection.tree;

import androidx.annotation.NonNull;

/**
 * @author Jack_Ou  created on 2020/11/30.
 */
public class WeightNode<E> {
    // 数据
    E data;
    // 权重值
    int weight;
    WeightNode leftChild;
    WeightNode rightChild;

    public WeightNode(E data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @NonNull
    @Override
    public String toString() {
        return "WeightNode [weight=" + weight + ",data=" + data + "]";
    }
}
