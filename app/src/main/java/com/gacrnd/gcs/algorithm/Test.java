package com.gacrnd.gcs.algorithm;

import com.gacrnd.gcs.algorithm.base.TreeNode;
import com.gacrnd.gcs.algorithm.sort.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Jack Ou
 * @CreateDate: 2021/12/20 22:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2021/12/20 22:21
 * @UpdateRemark: 更新说明
 */
public class Test {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5, 8, 6, 3, 9, 2, 1, 7, 4};
        //sort(arr, 0, arr.length - 1);
        //Utils.printArray(sort(arr));
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.intValue() - o1.intValue();
            }
        });
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        //Utils.printArray(arr);
    }

    private static void sort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int povit = arr[start];
        int i = start;
        int j = end;
        int temp;
        while (i != j) {
            while (i < j && povit <= arr[j]) {
                j--;
            }
            while (i < j && povit >= arr[i]) {
                i++;
            }
            if (i < j) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[i];
        arr[i] = povit;
        arr[start] = temp;

        sort(arr, start, i - 1);
        sort(arr, i + 1, end);
    }

    private static int[] sort(int[] arr) {
        if (arr.length < 2) return arr;
        int index = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, index);
        int[] right = Arrays.copyOfRange(arr, index, arr.length);
        return merge(sort(left), sort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int[] ret = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        for (int i = 0; i < ret.length; i++) {
            if (indexLeft >= left.length) {
                ret[i] = right[indexRight++];
            } else if (indexRight >= right.length) {
                ret[i] = left[indexLeft++];
            } else if (left[indexLeft] <= right[indexRight]) {
                ret[i] = left[indexLeft++];
            } else {
                ret[i] = right[indexRight++];
            }
        }
        return ret;
    }

    private static List<Integer> bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            ret.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return ret;
    }

}
