package com.gacrnd.gcs.algorithm.Collection.tree;

import android.app.Activity;
import android.icu.lang.UScript;
import android.security.ConfirmationNotAvailableException;

import com.gacrnd.gcs.algorithm.Collection.List.Node;

/**
 * 二叉平衡树
 *
 * @author Jack_Ou  created on 2020/11/30.
 */
public class AVLTree {

    public static void main(String[] args) {
        AvlNode root = null;
        root = insert(root,30);
        root = insert(root,20);
        root = insert(root,40);
        root = insert(root,10);
        root = insert(root,25);
        root = insert(root,5);
        printTree(root);
    }

    private static AvlNode insert(AvlNode root, int value) {
        if (root == null) {
            root = new AvlNode(value);
            return root;
        }

        if (value <= root.data) {
            root.leftChild = insert(root.leftChild, value);
            // 如果插入的值导致左边树失衡
            if (getHeight(root.leftChild) - getHeight(root.rightChild) > 1) {
                if (value <= root.leftChild.data) {
                    // LL 旋转
                    root = LLRotate(root);
                } else {
                    // LR 旋转
                    root = LRRotate(root);
                }
            }
        } else {
            root.rightChild = insert(root.rightChild, value);
            // 右树旋转
            if (getHeight(root.rightChild) - getHeight(root.leftChild) > 1) {
                if (value <= root.rightChild.data) {
                    // RL 旋转
                    root = RLRotate(root);
                } else {
                    // RR 旋转
                    root = RRRotate(root);
                }
            }
        }

        // 重新计算root的高度
        root.height = Math.max(getHeight(root.leftChild), getHeight(root.rightChild)) + 1;
        return root;
    }

    /*
     * LL旋转
     * 左旋示意图(对结点20进行左旋)
     *      30                       20
     *     /  \                     /  \
     *    20  40                  10   30
     *   /  \      --LL旋转-       /   /  \
     *  10   25                  5   25   40
     *  /
     * 5
     *
     */
    private static AvlNode LLRotate(AvlNode node) {
        AvlNode subNode = node.leftChild;
        node.leftChild = subNode.rightChild;
        subNode.rightChild = node;
        // 重新计算高度
        node.height = Math.max(getHeight(node.leftChild),getHeight(node.rightChild)) + 1;
        subNode.height = Math.max(getHeight(node.leftChild),getHeight(node.rightChild)) + 1;
        return subNode;
    }

    /*
     * RR旋转
     * 右旋示意图(对结点30进行左旋)
     *      20                          30
     *     /  \                        /  \
     *    10  30                     20   40
     *       /  \      --RR旋转-     /  \   \
     *      25  40                 10  25  50
     *           \
     *           50
     *
     */
    private static AvlNode RRRotate(AvlNode node) {
        AvlNode subNode = node.rightChild;
        node.rightChild = subNode.leftChild;
        subNode.leftChild = node;
        node.height = Math.max(getHeight(node.leftChild),getHeight(node.rightChild)) + 1;
        subNode.height = Math.max(getHeight(subNode.leftChild),getHeight(subNode.rightChild)) + 1;
        return subNode;
    }

    private static AvlNode LRRotate(AvlNode node) {
        // 先子树进行RR旋转
        RRRotate(node.leftChild);
        // 然后父链进行LL旋转
        return LLRotate(node);
    }

    private static AvlNode RLRotate(AvlNode node) {
        // 子树先进行LL旋转
        LLRotate(node.rightChild);
        return RRRotate(node);
    }

    private static int getHeight(AvlNode node) {
        return node == null ? -1 : node.height;
    }

    private static void printTree(AvlNode root) {
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
}
