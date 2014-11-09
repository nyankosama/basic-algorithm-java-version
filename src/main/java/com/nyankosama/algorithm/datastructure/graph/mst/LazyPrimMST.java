package com.nyankosama.algorithm.datastructure.graph.mst;

import com.nyankosama.algorithm.datastructure.pq.MinPQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by i@nyankosama.com on 2014/11/9.
 */
public class LazyPrimMST {
    //NOTE
    //1. 延时的Prim算法
    //2. 会用最小优先队列来计算横切边

    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public Iterable<Edge> edges() {
        return mst;
    }

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<>(G.E());
        marked = new boolean[G.V()];
        mst = new LinkedList<>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w]) continue;
            mst.offer(e);
            if (!marked[v]) visit(G, v);
            if (!marked[w]) visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) pq.insert(e);
        }
    }

    public double weight() {
        double weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
