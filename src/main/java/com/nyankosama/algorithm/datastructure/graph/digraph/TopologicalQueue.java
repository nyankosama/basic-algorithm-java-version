package com.nyankosama.algorithm.datastructure.graph.digraph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by i@nyankosama.com on 2014/11/9.
 */
public class TopologicalQueue {
    //继续队列的拓扑排序
    //1. 首先计算每一个顶点的入度，并将入读为0的顶点压入队列
    //2. 重复以下操作直到队列为空：
    //3. 从队列中删除一个元素，并将其标记
    //4. 遍历被删除的顶点的所有指向的顶点，并将这些顶点的入度减少1
    //5. 如果顶点入读变为0，将它插入顶点队列

    private Queue<Integer> order;     // vertices in topological order
    private int[] indegree;           // indegree[v] = indegree of vertex v

    public TopologicalQueue(Digraph G) {
        indegree = new int[G.V()];
        order = new LinkedList<>();

        // compute indegrees
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                indegree[w]++;
            }
        }

        // initialize queue to contain all vertices with indegree = 0
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < G.V(); v++)
            if (indegree[v] == 0) queue.offer(v);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.offer(v);
            for (int w : G.adj(v)) {
                indegree[w]--;
                if (indegree[w] == 0) queue.offer(w);
            }
        }
    }

    // is G a directed acyclic graph?
    public boolean isDAG() {
        for (int v = 0; v < indegree.length; v++)
            if (indegree[v] != 0) return false;
        return true;
    }

    // the vertices in topological order (assuming G is a DAG)
    public Iterable<Integer> order() {
        return order;
    }
}
