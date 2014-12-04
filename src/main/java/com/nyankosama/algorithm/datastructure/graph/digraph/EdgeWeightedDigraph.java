package com.nyankosama.algorithm.datastructure.graph.digraph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i@nyankosama.com on 2014/12/4.
 */
public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
    }

    public int V(){return V;}

    public int E(){return E;}

    public void addEdge(DirectedEdge edge) {
        this.adj[edge.from()].add(edge);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}
