package com.gacrnd.gcs.algorithm.Collection.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 最优二叉树：哈夫曼树 (代权路径最小)
 *
 * 可以用于文件压缩，但是压缩率不高
 *
 * 哈弗曼树可以求得最优的前缀码
 * 前缀码：每个数据的编码不能是另外数据的前缀
 *
 * 各个码出现的次数：A:5  B:6  C:2  D:7  E:9
 *
 *                 29
 *               /    \
 *             13     16
 *            /  \   /  \
 *          B：6 7  D:7 E:9
 *              / \
 *            C:2 A:5
 *
 * 得到的可变编码：
 *  A    B   C    D    E
 * 001  00  010   10   11
 *
 * @author Jack_Ou  created on 2020/11/30.
 */
public class HuffmanTree {

    public static void main(String[] args) {
        List<WeightNode> nodes = new ArrayList<>();
        //把节点加入至list中
        nodes.add(new WeightNode("a", 10));
        nodes.add(new WeightNode("b", 15));
        nodes.add(new WeightNode("c", 12));
        nodes.add(new WeightNode("d", 3));
        nodes.add(new WeightNode("e", 4));
        nodes.add(new WeightNode("f", 13));
        nodes.add(new WeightNode("g", 1));
        //进行哈夫曼树的构造
        WeightNode root = createTree(nodes);
        // 打印树
        printTree(root);
    }

    private static void printTree(WeightNode root) {
        System.out.println(root.toString());
        if (root.leftChild != null) {
            System.out.print("left:");
            printTree(root.leftChild);
        }
        if (root.rightChild != null) {
            System.out.print("right:");
            printTree(root.rightChild);
        }
    }

    private static WeightNode createTree(List<WeightNode> nodes) {
        while (nodes.size() > 1) {
            sort(nodes);
            WeightNode left = nodes.get(0);
            WeightNode right = nodes.get(1);
            WeightNode parent = new WeightNode(null, left.weight + right.weight);
            parent.leftChild = left;
            parent.rightChild = right;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    public static void sort(List<WeightNode> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).weight > list.get(j + 1).weight) {
                    WeightNode tmp = list.get(j + 1);
                    list.set(j + 1, list.get(j));
                    list.set(j, tmp);
                }
            }
        }
    }
}
