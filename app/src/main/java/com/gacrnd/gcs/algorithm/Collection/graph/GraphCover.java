package com.gacrnd.gcs.algorithm.Collection.graph;

import android.util.Size;

/**
 * @author Jack_Ou  created on 2020/11/30.
 */
public class GraphCover extends Graph {

    private int[] visit = new int[size];

    /**
     * 深度优先遍历
     */
    public void deepSearch(int start) {
        visit[start] = 1;
        System.out.println(nodes[start] + "-->");
        for (int i = 0; i < size; i++) {
            if (this.edges[start][i] == 1 && visit[i] == 0) {
                deepSearch(i);
            }
        }
    }

    /**
     * 广度优先
     */
    private int[] queue = new int[size];

    public void BreadthFirst(int front, int tail) {
        int last = tail;

        // front和tail表示新接入到队列的点，需要再次遍历的。
        for (int index = front; index <= tail; index++) {
            int node = queue[index];
            //输出节点数据
            System.out.println(this.nodes[node] + "->");
            //找出所有的邻接点
            for (int i = 0; i < this.size; i++) {
                if (this.edges[node][i] == 1 && visit[i] == 0) {
                    //邻接点
                    visit[i] = 1;
                    queue[++last] = i;
                }
            }
        }

        //遍历下一批节点
        if (last > tail) {
            // 重新递归遍历新增的节点
            BreadthFirst(tail + 1, last);
        }
    }


    public void BreadthFirst(int start) {
        queue[0] = start;
        visit[start] = 1;
        BreadthFirst(0, 0);
    }


    public static void main(String[] args) {
        GraphCover graph = new GraphCover();

        graph.BreadthFirst(6);
    }
}
