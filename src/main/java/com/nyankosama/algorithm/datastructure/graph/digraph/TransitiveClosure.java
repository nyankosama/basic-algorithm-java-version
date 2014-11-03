package com.nyankosama.algorithm.datastructure.graph.digraph;

/**
 * Created by i@nyankosama.com on 2014/11/3.
 */
public class TransitiveClosure {
    //NOTE 计算有向图的传递闭包来常数时间判断顶点对的可达性

    private DirectedDFS[] all;

    public TransitiveClosure(Digraph G) {
        all = new DirectedDFS[G.V()];
        for (int v = 0; v < G.V(); v++) {
            all[v] = new DirectedDFS(G, v);
        }
    }

    public boolean reachable(int v, int w) {
        return all[v].marked(w);
    }
}
