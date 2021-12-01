package com.gacrnd.gcs.algorithm.search;

import com.gacrnd.gcs.algorithm.Collection.tree.ConstructTree;
import com.gacrnd.gcs.algorithm.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索
 *
 * @Author: Jack Ou
 * @CreateDate: 2021/12/1 23:55
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/1 23:55
 * @UpdateRemark: 更新说明
 */
public class Bfs {

    public static void main(String[] args) {
        Integer[] nums = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode root = ConstructTree.constructTree(nums);
        System.out.println(bfs(root).toString());
    }

    public static List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return result;
    }
}
