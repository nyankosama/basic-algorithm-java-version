package com.nyankosama.algorithm.datastructure.graph.mst;

import com.nyankosama.algorithm.datastructure.pq.IndexMinPQ;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by i@nyankosama.com on 2014/11/9.
 */
public class PrimMST {
    //NOTE Prim算法的即时版本

    private Edge[] edgeTo;          //距离树最近的边
    private double[] distTo;        //distTo[w] = edgeTo[w].weight()
    private boolean[] marked;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        marked = new boolean[G.V()];
        for (int i = 0; i < G.V(); i++) {
            distTo[i] = Double.POSITIVE_INFINITY; //初始化为无限大
        }
        pq = new IndexMinPQ<>(G.V());
        distTo[0] = 0.0; //认为第一个节点到树的距离为0
        pq.insert(0, 0.0);
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) continue;        //v-w失败
            if (e.weight() < distTo[w]) {   //如果有从树到w节点更近的边，则更新
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) pq.changeKey(w, distTo[w]);
                else pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        List<Edge> edges = new LinkedList<>();
        for (Edge e : edgeTo) {
            if (e != null) edges.add(e);
        }
        return edges;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : edgeTo) {
            if (e != null) weight += e.weight();
        }
        return weight;
    }
}
