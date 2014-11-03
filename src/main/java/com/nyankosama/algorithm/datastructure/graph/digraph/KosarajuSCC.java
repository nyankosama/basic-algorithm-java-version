package com.nyankosama.algorithm.datastructure.graph.digraph;

/**
 * Created by i@nyankosama.com on 2014/11/3.
 */
public class KosarajuSCC {
    //NOTE Kosaraju算法计算有向图的强连通分量
    //1. 在给定的有向图G中，使用DepthFirstOrder来计算它的反向图CR的逆后序排列
    //2. 使用1中得到的顺序进行来访问G中的节点，进行深度优先搜索
    //3. 所有在同一个递归dfs()调用中被访问到的顶点都在同一个强连通分量中

    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        DepthFirstOrder order = new DepthFirstOrder(G);
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }

    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
