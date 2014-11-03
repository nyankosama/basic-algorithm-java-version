package com.nyankosama.algorithm.datastructure.graph.digraph;

/**
 * Created by i@nyankosama.com on 2014/11/3.
 */
public class Topological {
    //NOTE 计算拓扑节点序列
    //利用结论，一副有向图的拓扑排序是顶点的逆后序排列

    private Iterable<Integer> order; //顶点的拓扑排序

    public Topological(Digraph G) {
        DirectedCycle cycle = new DirectedCycle(G);
        if (!cycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
