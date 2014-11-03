package com.nyankosama.algorithm.datastructure.graph;

/**
 * Created by i@nyankosama.com on 2014/11/3.
 */
public class DepthFirstSearch {
    //NOTE 深度优先搜索，搜索与某个顶点s连通的所用顶点
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s) {

    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }
}
