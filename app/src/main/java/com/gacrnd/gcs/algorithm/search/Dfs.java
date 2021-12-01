package com.gacrnd.gcs.algorithm.search;

import com.gacrnd.gcs.algorithm.base.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/12/2 0:22
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/2 0:22
 * @UpdateRemark: 更新说明
 */
public class Dfs {

    public static void main(String[] args) {

    }

    // ====================前序遍历======================================
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preOrderDfs(root, result);
        return result;
    }

    private static void preOrderDfs(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            preOrderDfs(root.left, result);
            preOrderDfs(root.right, result);
        }
    }

    public static List<Integer> preOrderTraversalCycle(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                // 先保存中
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }

    // ====================中序遍历======================================
    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inOrderDfs(root, result);
        return result;
    }

    public static void inOrderDfs(TreeNode root, List<Integer> result) {
        if (root != null) {
            inOrderDfs(root.left, result);
            result.add(root.val);
            inOrderDfs(root.right, result);
        }
    }

    public static List<Integer> inOrderTraversalCycle(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            // 遍历左边
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();  // 拿出中间
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

    // ====================后序遍历======================================
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        postOrderDfs(root, result);
        return result;
    }

    public static void postOrderDfs(TreeNode root, List<Integer> result) {
        if (root != null) {
            postOrderDfs(root.left, result);
            postOrderDfs(root.right, result);
            result.add(root.val);
        }
    }

    public static List<Integer> postOrderTraversalCycle(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (cur != null && cur.right != prev) {
                cur = cur.right;  // 如果没有遍历过右子树，就先遍历
            } else {
                cur = stack.pop();
                result.add(cur.val);
                prev = cur;
                cur = null;
            }
        }
        return result;
    }
}
